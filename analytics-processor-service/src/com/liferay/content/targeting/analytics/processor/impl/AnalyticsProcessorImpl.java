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

package com.liferay.content.targeting.analytics.processor.impl;

import com.liferay.content.targeting.analytics.processor.AnalyticsProcessor;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eduardo Garcia
 */
@Component
public class AnalyticsProcessorImpl implements AnalyticsProcessor {

	@Override
	public String addTrackingLinks(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String content) {

		Matcher linkMatcher = _LINK_PATTERN.matcher(content);

		StringBuffer stringBuffer = new StringBuffer();

		while (linkMatcher.find()) {
			String trackingLinkURL = getTrackingLinkURL(
					companyId, userId, anonymousUserId, className, classPK,
					elementId, linkMatcher.group(2));

			StringBundler sb = new StringBundler(3);

			sb.append(linkMatcher.group(1));
			sb.append(trackingLinkURL);
			sb.append(linkMatcher.group(3));

			linkMatcher.appendReplacement(stringBuffer, sb.toString());
		}

		linkMatcher.appendTail(stringBuffer);

		return stringBuffer.toString();
	}

	@Override
	public String getTrackingEventURL(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String event, String additionalInfo) {

		String trackingEventURL = StringPool.BLANK;

		try {
			Company company = CompanyLocalServiceUtil.getCompany(companyId);

			String portalURL = PortalUtil.getPortalURL(
				company.getVirtualHostname(), PortalUtil.getPortalPort(false),
				false);

			trackingEventURL = portalURL + _TRACK_PATH;

			if (userId > 0) {
				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "userId", String.valueOf(userId));
			}

			if (anonymousUserId > 0) {
				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "anonymousUserId",
					String.valueOf(anonymousUserId));
			}

			trackingEventURL = HttpUtil.addParameter(
				trackingEventURL, "className", className);
			trackingEventURL = HttpUtil.addParameter(
				trackingEventURL, "classPK", String.valueOf(classPK));
			trackingEventURL = HttpUtil.addParameter(
				trackingEventURL, "elementId", elementId);
			trackingEventURL = HttpUtil.addParameter(
				trackingEventURL, "event", event);
			trackingEventURL = HttpUtil.addParameter(
				trackingEventURL, "additionalInfo", additionalInfo);
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return trackingEventURL;
	}

	@Override
	public String getTrackingImageHTML(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String additionalInfo) {

		String trackingImageURL = getTrackingImageURL(
			companyId, userId, anonymousUserId, className, classPK, elementId,
			additionalInfo);

		return String.format(_IMAGE_PATTERN, trackingImageURL);
	}

	@Override
	public String getTrackingImageURL(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String additionalInfo) {

		String trackingImageURL = getTrackingEventURL(
			companyId, userId, anonymousUserId, className, classPK, elementId,
			"view", additionalInfo);

		trackingImageURL = HttpUtil.addParameter(
			trackingImageURL, "imageId", StringUtil.randomId());

		return trackingImageURL;
	}

	@Override
	public String getTrackingLinkURL(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String redirect) {

		String trackingLinkURL = getTrackingEventURL(
			companyId, userId, anonymousUserId, className, classPK, elementId,
			"click", redirect);

		trackingLinkURL = HttpUtil.addParameter(
			trackingLinkURL, "linkId", StringUtil.randomId());
		trackingLinkURL = HttpUtil.addParameter(
			trackingLinkURL, "redirect", redirect);

		return trackingLinkURL;
	}

	@Override
	public void trackEvent(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String event, String additionalInfo) {

		Message message = new Message();

		message.put("additionalInfo", additionalInfo);
		message.put("anonymousUserId", anonymousUserId);
		message.put("className", className);
		message.put("classPK", classPK);
		message.put("companyId", companyId);
		message.put("elementId", elementId);
		message.put("event", event);
		message.put("userId", userId);

		MessageBusUtil.sendMessage("liferay/analytics", message);
	}

	private static final String _IMAGE_PATTERN = "<img alt=\"\" src=\"%s\" />";

	private static final Pattern _LINK_PATTERN = Pattern.compile(
		"(<a\\s+.*?href=\")([^\"]+)(\")");

	private static Log _log = LogFactoryUtil.getLog(
		AnalyticsProcessorImpl.class);

	private final static String _TRACK_PATH = "/o/analytics-processor/track";

}