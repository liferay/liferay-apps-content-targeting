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

package com.liferay.contenttargeting.trackingactions.youtube;

import com.liferay.contenttargeting.api.model.BaseTrackingAction;
import com.liferay.contenttargeting.api.model.TrackingAction;
import com.liferay.contenttargeting.model.TrackingActionInstance;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = TrackingAction.class)
public class YoutubeTrackingAction extends BaseTrackingAction {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public List<String> getEventTypes() {
		return ListUtil.fromArray(_EVENT_TYPES);
	}

	@Override
	public String getIcon() {
		return "icon-youtube";
	}

	@Override
	public String getSummary(
		TrackingActionInstance trackingActionInstance, Locale locale) {

		String summary = LanguageUtil.format(
			locale, "tracking-action-x-in-youtube-x",
			new Object[] {
				trackingActionInstance.getEventType(),
				trackingActionInstance.getElementId()
			});

		return summary;
	}

	@Override
	protected void populateContext(
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context) {

		String alias = StringPool.BLANK;
		String elementId = StringPool.BLANK;
		String eventType = StringPool.BLANK;

		if (trackingActionInstance != null) {
			alias = trackingActionInstance.getAlias();
			elementId = trackingActionInstance.getElementId();
			eventType = trackingActionInstance.getEventType();
		}

		context.put("alias", alias);
		context.put("elementId", elementId);
		context.put("eventType", eventType);
		context.put("eventTypes", getEventTypes());

		boolean trackingYoutubeEnabled = false;

		Company company = (Company)context.get("company");

		try {
			trackingYoutubeEnabled = PrefsPropsUtil.getBoolean(
				company.getCompanyId(),
				"content.targeting.analytics.youtube.enabled");
		}
		catch (SystemException se) {
		}

		context.put("trackingYoutubeEnabled", trackingYoutubeEnabled);
	}

	// See html/js/analytics/integrations/youtube_iframe.js in Analytics Hook

	private static final String[] _EVENT_TYPES = {
		"unstarted", "ended", "playing", "paused", "buffering", "video-cued"};

}