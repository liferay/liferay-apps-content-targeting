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

package com.liferay.content.targeting.analytics.web.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.servlet.BufferCacheServletResponse;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.registry.Filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true, property = {"servlet-context-name=/"},
	service = Filter.class
)
public class YoutubeVideoHtmlFilter extends BaseFilter {

	public static final String SKIP_FILTER =
		YoutubeVideoHtmlFilter.class.getName() + "SKIP_FILTER";

	@Override
	public boolean isFilterEnabled(
		HttpServletRequest request, HttpServletResponse response) {

		try {
			Company company = PortalUtil.getCompany(request);

			long companyId = company.getCompanyId();

			boolean youtubeTrackingEnabled = PrefsPropsUtil.getBoolean(
				companyId, "content.targeting.analytics.youtube.enabled");

			if (youtubeTrackingEnabled && !isAlreadyFiltered(request)) {
				return true;
			}
		}
		catch (Exception e) {
		}

		return false;
	}

	protected String getContent(HttpServletRequest request, String content) {
		Matcher youtubeEmbedVideoIframeMatcher =
			_YOUTUBE_EMBED_VIDEO_IFRAME_PATTERN.matcher(content);

		StringBuffer stringBuffer = new StringBuffer();

		while (youtubeEmbedVideoIframeMatcher.find()) {
			String youtubeEmbededVideoUrl =
				youtubeEmbedVideoIframeMatcher.group(4);

			Matcher youtubeEmbedVideoUrlIdMatcher =
				_YOUTUBE_EMBED_VIDEO_URL_ID_PATTERN.matcher(
					youtubeEmbededVideoUrl);

			if (!youtubeEmbedVideoUrlIdMatcher.matches()) {
				continue;
			}

			// Prevent Youtube security errors

			youtubeEmbededVideoUrl = sanitizeURL(youtubeEmbededVideoUrl, true);

			youtubeEmbededVideoUrl = HttpUtil.addParameter(
				youtubeEmbededVideoUrl, "enablejsapi", 1);

			String youtubeEmbedVideoIframeAtributtes =
				youtubeEmbedVideoIframeMatcher.group(2) + " id=" +
					youtubeEmbedVideoUrlIdMatcher.group(1);

			StringBundler sb = new StringBundler(5);

			sb.append(youtubeEmbedVideoIframeMatcher.group(1));
			sb.append(youtubeEmbedVideoIframeAtributtes);
			sb.append(youtubeEmbedVideoIframeMatcher.group(3));
			sb.append(youtubeEmbededVideoUrl);
			sb.append(youtubeEmbedVideoIframeMatcher.group(5));

			youtubeEmbedVideoIframeMatcher.appendReplacement(
				stringBuffer, sb.toString());
		}

		youtubeEmbedVideoIframeMatcher.appendTail(stringBuffer);

		if (stringBuffer.length() != 0) {
			return stringBuffer.toString();
		}

		return content;
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	protected boolean isAlreadyFiltered(HttpServletRequest request) {
		if (request.getAttribute(SKIP_FILTER) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		request.setAttribute(SKIP_FILTER, Boolean.TRUE);

		if (_log.isDebugEnabled()) {
			String completeURL = HttpUtil.getCompleteURL(request);

			_log.debug("Processing Youtube URLs for " + completeURL);
		}

		BufferCacheServletResponse bufferCacheServletResponse =
			new BufferCacheServletResponse(response);

		processFilter(
			YoutubeVideoHtmlFilter.class.getName(), request,
			bufferCacheServletResponse, filterChain);

		String content = bufferCacheServletResponse.getString();

		String contentType = response.getContentType();

		if ((contentType != null) &&
			contentType.startsWith(ContentTypes.TEXT_HTML)) {

			content = getContent(request, content);

			ServletResponseUtil.write(response, content);
		}
		else {
			ServletResponseUtil.write(response, bufferCacheServletResponse);
		}
	}

	private String sanitizeURL(String url, boolean secure) {
		if (url.startsWith(StringPool.DOUBLE_SLASH)) {
			url = url.replace(StringPool.DOUBLE_SLASH, StringPool.BLANK);
		}

		if (!url.startsWith(Http.HTTP)) {
			url = Http.HTTP_WITH_SLASH + url;
		}

		return HttpUtil.protocolize(url, secure);
	}

	private static final Pattern _YOUTUBE_EMBED_VIDEO_IFRAME_PATTERN =
		Pattern.compile(
			"(<iframe\\s+)(.*)(\\s+src=\\\")([^\\\"]*)" +
				"(\\\".*>.*?<\\/iframe>)");

	private static final Pattern _YOUTUBE_EMBED_VIDEO_URL_ID_PATTERN =
		Pattern.compile(".*\\/embed\\/([a-zA-Z0-9_\\\\-]{11}).*");

	private static final Log _log = LogFactoryUtil.getLog(
		YoutubeVideoHtmlFilter.class);

}