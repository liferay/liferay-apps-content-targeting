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

package com.liferay.contenttargeting.trackingactions.page;

import com.liferay.contenttargeting.api.model.BaseTrackingAction;
import com.liferay.contenttargeting.api.model.TrackingAction;
import com.liferay.contenttargeting.model.TrackingActionInstance;
import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = TrackingAction.class)
public class PageTrackingAction extends BaseTrackingAction {

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
		return "icon-file";
	}

	@Override
	public String getSummary(
		TrackingActionInstance trackingActionInstance, Locale locale) {

		String summary = LanguageUtil.format(
			locale, "tracking-page-x",
			new Object[] {
				trackingActionInstance.getAlias(),
			});

		return summary;
	}

	@Override
	public String processTrackingAction(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws Exception {

		String friendlyURL = values.get("friendlyURL");

		if (Validator.isNotNull(friendlyURL)) {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			// Retrieve layout by friendly url from public or private layout set

			Layout layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
				themeDisplay.getScopeGroupId(), false, friendlyURL);

			if (layout == null) {
				layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
					themeDisplay.getScopeGroupId(), true, friendlyURL);
			}

			if (layout != null) {
				values.put("referrerClassName", Layout.class.getName());
				values.put("referrerClassPK", String.valueOf(layout.getPlid()));

				JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

				jsonObj.put("friendlyURL", friendlyURL);

				return jsonObj.toString();
			}
			else {
				throw new NoSuchLayoutException();
			}
		}

		return StringPool.BLANK;
	}

	@Override
	protected void populateContext(
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context) {

		String alias = StringPool.BLANK;
		String eventType = StringPool.BLANK;
		long referrerClassPK = 0;

		if (trackingActionInstance != null) {
			alias = trackingActionInstance.getAlias();
			eventType = trackingActionInstance.getEventType();
			referrerClassPK = trackingActionInstance.getReferrerClassPK();
		}

		context.put("alias", alias);
		context.put("eventType", eventType);
		context.put("eventTypes", getEventTypes());

		String friendlyURL = StringPool.BLANK;

		try {
			Layout layout = LayoutLocalServiceUtil.getLayout(referrerClassPK);

			friendlyURL = layout.getFriendlyURL();
		}
		catch (Exception e) {
		}

		context.put("friendlyURL", friendlyURL);

		boolean trackingPageEnabled = false;

		Company company = (Company)context.get("company");

		try {
			trackingPageEnabled = PrefsPropsUtil.getBoolean(
				company.getCompanyId(),
				"content.targeting.analytics.page.enabled");
		}
		catch (SystemException se) {
		}

		context.put("trackingPageEnabled", trackingPageEnabled);
	}

	private static final String[] _EVENT_TYPES = {"view"};

}