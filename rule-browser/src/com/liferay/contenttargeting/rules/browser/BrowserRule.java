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

package com.liferay.contenttargeting.rules.browser;

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
public class BrowserRule extends BaseRule {

	public static final String CHROME = "Chrome";

	public static final String FIREFOX = "Firefox";

	public static final String IE = "IE";

	public static final String OPERA = "Opera";

	public static final String SAFARI = "Safari";

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

		String browser = ruleInstance.getTypeSettings();

		if (browser.equals(CHROME) && BrowserSnifferUtil.isChrome(request)) {
			return true;
		}
		else if (browser.equals(FIREFOX) &&
				 BrowserSnifferUtil.isFirefox(request)) {

			return true;
		}
		else if (browser.equals(IE) && BrowserSnifferUtil.isIe(request)) {
			return true;
		}
		else if (browser.equals(OPERA) && BrowserSnifferUtil.isOpera(request)) {
			return true;
		}
		else if (browser.equals(SAFARI) &&
				 BrowserSnifferUtil.isSafari(request)) {

			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-globe";
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

		return values.get("browser");
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		String browser = StringPool.BLANK;

		if (ruleInstance != null) {
			browser = ruleInstance.getTypeSettings();
		}

		context.put("browsers", _AVAILABLE_BROWSERS);
		context.put("browser", browser);
	}

	private static final String[] _AVAILABLE_BROWSERS = {
		CHROME, FIREFOX, IE, OPERA, SAFARI
	};

}