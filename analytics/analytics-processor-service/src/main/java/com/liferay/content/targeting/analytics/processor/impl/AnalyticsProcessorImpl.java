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
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(property = {"service.ranking:Integer=100"})
public class AnalyticsProcessorImpl implements AnalyticsProcessor {

	@Override
	public String getTrackingEventURL(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String referrerClassName, long[] referrerClassPKs,
		String elementId, String event, String additionalInfo) {

		String trackingEventURL = StringPool.BLANK;

		try {
			Company company = _companyLocalService.getCompany(companyId);

			String portalURL = PortalUtil.getPortalURL(
				company.getVirtualHostname(), PortalUtil.getPortalPort(false),
				false);

			trackingEventURL = portalURL + _TRACK_PATH;

			trackingEventURL = HttpUtil.addParameter(
				trackingEventURL, "event", event);

			if (userId > 0) {
				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "userId", String.valueOf(userId));
			}

			if (anonymousUserId > 0) {
				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "anonymousUserId",
					String.valueOf(anonymousUserId));
			}

			if (Validator.isNotNull(className) && (classPK > 0)) {
				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "className", className);
				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "classPK", classPK);
			}

			if (Validator.isNotNull(referrerClassName) &&
				Validator.isNotNull(referrerClassPKs)) {

				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "referrerClassName", referrerClassName);
				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "referrerClassPK",
					StringUtil.merge(referrerClassPKs));
			}

			if (Validator.isNotNull(elementId)) {
				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "elementId", elementId);
			}

			if (Validator.isNotNull(additionalInfo)) {
				trackingEventURL = HttpUtil.addParameter(
					trackingEventURL, "additionalInfo", additionalInfo);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return trackingEventURL;
	}

	@Override
	public String getTrackingImageHTML(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String referrerClassName, long[] referrerClassPKs,
		String elementId, String additionalInfo) {

		String trackingImageURL = getTrackingImageURL(
			companyId, userId, anonymousUserId, className, classPK,
			referrerClassName, referrerClassPKs, elementId, additionalInfo);

		return String.format(_IMAGE_PATTERN, trackingImageURL);
	}

	@Override
	public String getTrackingImageURL(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String referrerClassName, long[] referrerClassPKs,
		String elementId, String additionalInfo) {

		String trackingImageURL = getTrackingEventURL(
			companyId, userId, anonymousUserId, className, classPK,
			referrerClassName, referrerClassPKs, elementId, "view",
			additionalInfo);

		trackingImageURL = HttpUtil.addParameter(
			trackingImageURL, "imageId", StringUtil.randomId());

		return trackingImageURL;
	}

	@Override
	public String getTrackingLinkURL(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String referrerClassName, long[] referrerClassPKs,
		String elementId, String redirect) {

		String trackingLinkURL = getTrackingEventURL(
			companyId, userId, anonymousUserId, className, classPK,
			referrerClassName, referrerClassPKs, elementId, "click", redirect);

		trackingLinkURL = HttpUtil.addParameter(
			trackingLinkURL, "linkId", StringUtil.randomId());
		trackingLinkURL = HttpUtil.addParameter(
			trackingLinkURL, "redirect", redirect);

		return trackingLinkURL;
	}

	@Override
	public String getTrackingPath() {
		return _TRACK_PATH;
	}

	@Override
	public String replaceLinks(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String referrerClassName, long[] referrerClassPKs,
		String elementId, String content) {

		StringBuffer stringBuffer = new StringBuffer();

		Matcher linkMatcher = _LINK_PATTERN.matcher(content);

		while (linkMatcher.find()) {
			String trackingLinkURL = getTrackingLinkURL(
				companyId, userId, anonymousUserId, className, classPK,
				referrerClassName, referrerClassPKs, elementId,
				linkMatcher.group(1));

			StringBundler sb = new StringBundler(1);

			sb.append(trackingLinkURL);

			linkMatcher.appendReplacement(stringBuffer, sb.toString());
		}

		linkMatcher.appendTail(stringBuffer);

		return stringBuffer.toString();
	}

	@Override
	public String replaceLinksHTML(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String referrerClassName, long[] referrerClassPKs,
		String elementId, String content) {

		StringBuffer stringBuffer = new StringBuffer();

		Matcher linkMatcher = _LINK_PATTERN_HTML.matcher(content);

		while (linkMatcher.find()) {
			String trackingLinkURL = getTrackingLinkURL(
				companyId, userId, anonymousUserId, className, classPK,
				referrerClassName, referrerClassPKs, elementId,
				linkMatcher.group(2));

			StringBundler sb = new StringBundler(3);

			sb.append(linkMatcher.group(1));
			sb.append(trackingLinkURL);
			sb.append(linkMatcher.group(3));

			linkMatcher.appendReplacement(stringBuffer, sb.toString());
		}

		linkMatcher.appendTail(stringBuffer);

		return stringBuffer.toString();
	}

	@Reference(unbind = "-")
	public void setCompanyLocalService(
		CompanyLocalService companyLocalService) {

		_companyLocalService = companyLocalService;
	}

	@Override
	public void trackEvent(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String referrerClassName, long[] referrerClassPKs,
		String elementId, String event, String additionalInfo) {

		Message message = new Message();

		message.put("additionalInfo", additionalInfo);
		message.put("anonymousUserId", anonymousUserId);
		message.put("className", className);
		message.put("classPK", classPK);
		message.put("companyId", companyId);
		message.put("elementId", elementId);
		message.put("event", event);

		if (Validator.isNotNull(referrerClassName) &&
			Validator.isNotNull(referrerClassPKs)) {

			Map<String, long[]> referrers = new HashMap<>();

			referrers.put(referrerClassName, referrerClassPKs);

			message.put("referrers", referrers);
		}

		message.put("userId", userId);

		MessageBusUtil.sendMessage("liferay/analytics", message);
	}

	private static final String _IMAGE_PATTERN = "<img alt=\"\" src=\"%s\" />";

	private static final Pattern _LINK_PATTERN = Pattern.compile(
		"(([htf]+tp)s?:\\/\\/[^\\s]+)");

	private static final Pattern _LINK_PATTERN_HTML = Pattern.compile(
		"(<a\\s+.*?href=\")([^\"]+)(\")");

	private static final String _TRACK_PATH = "/o/analytics-processor/track";

	private static final Log _log = LogFactoryUtil.getLog(
		AnalyticsProcessorImpl.class);

	private CompanyLocalService _companyLocalService;

}