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

package com.liferay.contenttargeting.rules.device;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.rulecategories.SessionAttributesRuleCategory;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class DeviceRule extends BaseRule {

	public static final String DESKTOP = "Desktop";

	public static final String MOBILE = "Mobile";

	public static final String TABLET = "Tablet";

	public static boolean isTablet(HttpServletRequest request) {
		return false;
	}

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

		String device = ruleInstance.getTypeSettings();

		if (device.equals(DESKTOP) && !BrowserSnifferUtil.isMobile(request) &&
			!isTablet(request)) {

			return true;
		}
		else if (device.equals(MOBILE) &&
				 BrowserSnifferUtil.isMobile(request)) {

			return true;
		}
		else if (device.equals(TABLET) && isTablet(request)) {
			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-tablet";
	}

	@Override
	public String getRuleCategoryKey() {
		return SessionAttributesRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		return LanguageUtil.get(locale, ruleInstance.getTypeSettings());
	}

	@Override
	public String processRule(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws Exception {

		return values.get("device");
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		String device = StringPool.BLANK;

		if (ruleInstance != null) {
			device = ruleInstance.getTypeSettings();
		}

		context.put("devices", _AVAILABLE_DEVICES);
		context.put("device", device);
	}

	private static final String[] _AVAILABLE_DEVICES = {
		DESKTOP, MOBILE, TABLET
	};

}