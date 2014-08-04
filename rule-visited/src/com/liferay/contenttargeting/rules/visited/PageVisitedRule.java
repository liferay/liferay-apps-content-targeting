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

package com.liferay.contenttargeting.rules.visited;

import com.liferay.analytics.service.AnalyticsEventLocalService;
import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.rulecategories.BehaviorRuleCategory;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

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

		int count = 0;

		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			AnalyticsEventLocalService analyticsEventLocalService =
				ServiceTrackerUtil.getService(
					AnalyticsEventLocalService.class,
					bundle.getBundleContext());

			count = analyticsEventLocalService.getAnalyticsEventsCount(
				Layout.class.getName(), plid, "view");
		}
		catch (Exception e) {
		}

		if (count > 0) {
			return true;
		}

		return false;
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
			layout = LayoutLocalServiceUtil.fetchLayout(plid);
		}
		catch (SystemException e) {
		}

		if (layout != null) {
			return layout.getTitle(locale);
		}

		return StringPool.BLANK;
	}

	@Override
	public String processRule(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		String friendlyURL = values.get("friendlyURL");

		try {
			Layout layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
				themeDisplay.getScopeGroupId(), false, friendlyURL);

			if (layout == null) {
				layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
					themeDisplay.getScopeGroupId(), true, friendlyURL);
			}

			return String.valueOf(layout.getPlid());
		}
		catch (SystemException e) {
		}

		return StringPool.BLANK;
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_PAGE;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		String friendlyURL = StringPool.BLANK;

		if (ruleInstance != null) {
			long plid = GetterUtil.getLong(ruleInstance.getTypeSettings());

			try {
				Layout layout = LayoutLocalServiceUtil.fetchLayout(plid);

				friendlyURL = layout.getFriendlyURL();
			}
			catch (SystemException e) {
			}
		}

		context.put("friendlyURL", friendlyURL);

		Company company = (Company)context.get("company");

		boolean trackingPageEnabled = false;

		try {
			trackingPageEnabled = PrefsPropsUtil.getBoolean(
				company.getCompanyId(),
				"content.targeting.analytics.page.enabled");
		}
		catch (SystemException e) {
		}

		context.put("trackingPageEnabled", trackingPageEnabled);
	}

	protected static final String _FORM_TEMPLATE_PATH_PAGE =
		"templates/ct_fields_page.ftl";

}