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

package com.liferay.content.targeting.rule.visited;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.exception.InvalidRuleException;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.categories.BehaviorRuleCategory;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Element;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class PageVisitedRule extends BaseRule {

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
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		long plid = GetterUtil.getLong(ruleInstance.getTypeSettings());

		int count = _analyticsEventLocalService.getAnalyticsEventsCount(
			anonymousUser.getAnonymousUserId(), Layout.class.getName(), plid,
			"view");

		if (count > 0) {
			return true;
		}

		return false;
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment, Element ruleInstanceElement,
			RuleInstance ruleInstance)
		throws Exception {

		long plid = GetterUtil.getLong(ruleInstance.getTypeSettings());

		Layout layout = _layoutLocalService.fetchLayout(plid);

		if (layout != null) {
			ruleInstance.setTypeSettings(layout.getUuid());

			portletDataContext.addReferenceElement(
				ruleInstance, ruleInstanceElement, layout,
				PortletDataContext.REFERENCE_TYPE_WEAK, true);

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, Layout.class.getName(),
				String.valueOf(plid), Constants.EXPORT));
	}

	@Override
	public String getIcon() {
		return "icon-file";
	}

	@Override
	public String getRuleCategoryKey() {
		return BehaviorRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		long plid = GetterUtil.getLong(ruleInstance.getTypeSettings());

		Layout layout = null;

		try {
			layout = _layoutLocalService.fetchLayout(plid);
		}
		catch (SystemException se) {
		}

		if (layout != null) {
			return layout.getTitle(locale);
		}

		return StringPool.BLANK;
	}

	@Override
	public void importData(
			PortletDataContext portletDataContext, UserSegment userSegment,
			RuleInstance ruleInstance)
		throws Exception {

		String layoutUuid = ruleInstance.getTypeSettings();

		Layout layout = null;

		layout = _layoutLocalService.fetchLayoutByUuidAndGroupId(
			layoutUuid, portletDataContext.getGroupId(), false);

		if (layout == null) {
			layout = _layoutLocalService.fetchLayoutByUuidAndGroupId(
				layoutUuid, portletDataContext.getGroupId(), true);
		}

		if (layout != null) {
			ruleInstance.setTypeSettings(String.valueOf(layout.getPlid()));

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, Layout.class.getName(), layoutUuid,
				Constants.IMPORT));
	}

	@Override
	public String processRule(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidRuleException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String friendlyURL = values.get("friendlyURL");
		boolean privateLayout = GetterUtil.getBoolean(
			values.get("privateLayout"), false);

		try {
			long liveGroupId = themeDisplay.getSiteGroupIdOrLiveGroupId();
			Layout layout = _layoutLocalService.fetchLayoutByFriendlyURL(
				liveGroupId, privateLayout, friendlyURL);

			if (layout != null) {
				return String.valueOf(layout.getPlid());
			}
			else {
				throw new InvalidRuleException(
					"a-page-with-this-friendly-url-could-not-be-found");
			}
		}
		catch (SystemException se) {
		}

		return StringPool.BLANK;
	}

	@Reference(unbind = "-")
	public void setAnalyticsEventLocalService(
		AnalyticsEventLocalService analyticsEventLocalService) {

		_analyticsEventLocalService = analyticsEventLocalService;
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_PAGE;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		ThemeDisplay themeDisplay = (ThemeDisplay)context.get("themeDisplay");

		String friendlyURLPrivateBase = StringPool.BLANK;
		String friendlyURLPublicBase = StringPool.BLANK;

		try {
			LayoutSet layoutSet = themeDisplay.getLayoutSet();

			boolean privateLayoutSet = layoutSet.isPrivateLayout();

			layoutSet.setPrivateLayout(false);
			friendlyURLPublicBase = PortalUtil.getGroupFriendlyURL(
				layoutSet, themeDisplay);

			layoutSet.setPrivateLayout(true);
			friendlyURLPrivateBase = PortalUtil.getGroupFriendlyURL(
				layoutSet, themeDisplay);

			layoutSet.setPrivateLayout(privateLayoutSet);
		}
		catch (Exception e) {
			_log.error(e);
		}

		String friendlyURL = StringPool.BLANK;
		boolean privateLayout = false;

		if (!values.isEmpty()) {
			friendlyURL = values.get("friendlyURL");
			privateLayout = GetterUtil.getBoolean(
				values.get("privateLayout"), false);
		}
		else if (ruleInstance != null) {
			long plid = GetterUtil.getLong(ruleInstance.getTypeSettings());

			try {
				Layout layout = _layoutLocalService.fetchLayout(plid);

				if (layout != null) {
					friendlyURL = layout.getFriendlyURL();
					privateLayout = layout.isPrivateLayout();
				}
			}
			catch (SystemException se) {
			}
		}

		context.put("friendlyURL", friendlyURL);
		context.put("privateLayout", privateLayout);

		if (privateLayout) {
			context.put("friendlyURLBase", friendlyURLPrivateBase);
		}
		else {
			context.put("friendlyURLBase", friendlyURLPublicBase);
		}

		context.put("friendlyURLPublicBase", friendlyURLPublicBase);
		context.put("friendlyURLPrivateBase", friendlyURLPrivateBase);

		Group scopeGroup = (Group)context.get("scopeGroup");

		long groupId = (scopeGroup != null) ? scopeGroup.getGroupId() : 0;

		boolean trackingPageEnabled = AnalyticsUtil.isAnalyticsPageEnabled(
			groupId);

		context.put("trackingPageEnabled", trackingPageEnabled);

		if (!trackingPageEnabled) {
			ContentTargetingContextUtil.populateContextAnalyticsSettingsURLs(
				context);
		}
	}

	@Reference(unbind = "-")
	protected void setLayoutLocalService(
		LayoutLocalService layoutLocalService) {

		_layoutLocalService = layoutLocalService;
	}

	private static final String _FORM_TEMPLATE_PATH_PAGE =
		"templates/ct_fields_page.ftl";

	private static final Log _log = LogFactoryUtil.getLog(
		PageVisitedRule.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private LayoutLocalService _layoutLocalService;

}