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

package com.liferay.content.targeting.tracking.action.page;

import com.liferay.content.targeting.InvalidTrackingActionException;
import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.content.targeting.api.model.BaseTrackingAction;
import com.liferay.content.targeting.api.model.TrackingAction;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

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
	public void exportData(
			PortletDataContext portletDataContext, Element campaignElement,
			Campaign campaign, Element trackingActionInstanceElement,
			TrackingActionInstance trackingActionInstance)
		throws Exception {

		String typeSettings = trackingActionInstance.getTypeSettings();

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

		String friendlyURL = jsonObj.getString("friendlyURL");

		boolean privateLayout = jsonObj.getBoolean("privateLayout", false);

		Layout layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
			portletDataContext.getScopeGroupId(), privateLayout, friendlyURL);

		if (layout != null ) {
			portletDataContext.addReferenceElement(
				trackingActionInstance, trackingActionInstanceElement, layout,
				PortletDataContext.REFERENCE_TYPE_WEAK, true);

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				campaign, trackingActionInstance, Layout.class.getName(),
				friendlyURL, Constants.EXPORT));
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
	public void importData(
			PortletDataContext portletDataContext, Campaign campaign,
			TrackingActionInstance trackingActionInstance)
		throws Exception {

		String typeSettings = trackingActionInstance.getTypeSettings();

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

		String friendlyURL = jsonObj.getString("friendlyURL");
		boolean privateLayout = jsonObj.getBoolean("privateLayout", false);

		Layout layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
			portletDataContext.getScopeGroupId(), privateLayout, friendlyURL);

		if (layout != null ) {
			trackingActionInstance.setReferrerClassPK(layout.getPlid());

			return;
		}

		trackingActionInstance.setReferrerClassPK(0);

		throw new PortletDataException(
			getExportImportErrorMessage(
				campaign, trackingActionInstance, Layout.class.getName(),
				friendlyURL, Constants.IMPORT));
	}

	@Override
	public String processTrackingAction(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidTrackingActionException {

		String friendlyURL = values.get("friendlyURL");
		boolean privateLayout = GetterUtil.getBoolean(
			values.get("privateLayout"), false);

		if (Validator.isNotNull(friendlyURL)) {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			String friendlyURLPrivateBase = StringPool.BLANK;
			String friendlyURLPublicBase = StringPool.BLANK;
			Layout layout = null;

			try {
				friendlyURLPublicBase = PortalUtil.getGroupFriendlyURL(
					themeDisplay.getScopeGroup(), false, themeDisplay);
				friendlyURLPrivateBase = PortalUtil.getGroupFriendlyURL(
					themeDisplay.getScopeGroup(), true, themeDisplay);

				layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
					themeDisplay.getScopeGroupId(), privateLayout, friendlyURL);
			}
			catch (Exception e) {
				_log.error(e);
			}

			if (layout != null) {
				values.put("referrerClassName", Layout.class.getName());
				values.put("referrerClassPK", String.valueOf(layout.getPlid()));

				JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

				jsonObj.put("friendlyURL", friendlyURL);
				jsonObj.put("privateLayout", privateLayout);

				if (privateLayout) {
					jsonObj.put("friendlyURLBase", friendlyURLPrivateBase);
				}
				else {
					jsonObj.put("friendlyURLBase", friendlyURLPublicBase);
				}

				return jsonObj.toString();
			}
			else {
				throw new InvalidTrackingActionException(
					"a-page-with-this-friendly-url-could-not-be-found");
			}
		}

		return StringPool.BLANK;
	}

	@Override
	protected void populateContext(
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context, Map<String, String> values) {

		String alias = StringPool.BLANK;
		String eventType = StringPool.BLANK;
		String friendlyURL = StringPool.BLANK;
		Layout layout = null;
		boolean privateLayout = false;

		long scopeGroupId = GetterUtil.getLong(context.get("scopeGroupId"));

		if (!values.isEmpty()) {
			alias = values.get("alias");
			eventType = values.get("eventType");
			friendlyURL = values.get("friendlyURL");
			privateLayout = GetterUtil.getBoolean(
				values.get("privateLayout"), false);

			try {
				layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
					scopeGroupId, privateLayout, friendlyURL);
			}
			catch (SystemException e) {
				_log.error(e);
			}
		}
		else if (trackingActionInstance != null) {
			alias = trackingActionInstance.getAlias();
			eventType = trackingActionInstance.getEventType();
			long referrerClassPK = trackingActionInstance.getReferrerClassPK();

			try {
				layout = LayoutLocalServiceUtil.fetchLayout(referrerClassPK);
			}
			catch (SystemException e) {
				_log.error(e);
			}
		}

		context.put("alias", alias);
		context.put("eventType", eventType);
		context.put("eventTypes", getEventTypes());

		ThemeDisplay themeDisplay = (ThemeDisplay)context.get("themeDisplay");

		String friendlyURLPrivateBase = StringPool.BLANK;
		String friendlyURLPublicBase = StringPool.BLANK;

		try {
			friendlyURLPublicBase = PortalUtil.getGroupFriendlyURL(
				themeDisplay.getScopeGroup(), false, themeDisplay);
			friendlyURLPrivateBase = PortalUtil.getGroupFriendlyURL(
					themeDisplay.getScopeGroup(), true, themeDisplay);
		}
		catch (Exception e) {
			_log.error(e);
		}

		if (layout != null) {
			friendlyURL = layout.getFriendlyURL();
			privateLayout = layout.isPrivateLayout();
		}

		context.put("friendlyURL", friendlyURL);
		context.put("privateLayout", privateLayout);

		if (privateLayout) {
			context.put("friendlyURLBase", friendlyURLPrivateBase);
		}
		else {
			context.put("friendlyURLBase", friendlyURLPublicBase);
		}

		context.put("friendlyURLPrivateBase", friendlyURLPrivateBase);
		context.put("friendlyURLPublicBase", friendlyURLPublicBase);

		boolean trackingPageEnabled = AnalyticsUtil.isAnalyticsPageEnabled(
			scopeGroupId);

		context.put("trackingPageEnabled", trackingPageEnabled);

		if (!trackingPageEnabled) {
			ContentTargetingContextUtil.populateContextAnalyticsSettingsURLs(
				context);
		}
	}

	private static final String[] _EVENT_TYPES = {"view"};

	private static Log _log = LogFactoryUtil.getLog(PageTrackingAction.class);

}