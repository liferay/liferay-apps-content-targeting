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

package com.liferay.content.targeting.rule.os;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.SessionAttributesRuleCategory;
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
public class OSRule extends BaseRule {

	public static final String ANDROID = "Android";

	public static final String IOS = "iOS";

	public static final String LINUX = "Linux";

	public static final String MAC = "Mac";

	public static final String WINDOWS = "Windows";

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

		String os = ruleInstance.getTypeSettings();

		if (os.equals(ANDROID) && BrowserSnifferUtil.isAndroid(request)) {
			return true;
		}
		else if (os.equals(IOS) && BrowserSnifferUtil.isMac(request) &&
				 BrowserSnifferUtil.isMobile(request)) {

			return true;
		}
		else if (os.equals(LINUX) && BrowserSnifferUtil.isLinux(request)) {
			return true;
		}
		else if (os.equals(MAC) && BrowserSnifferUtil.isMac(request) &&
				 !BrowserSnifferUtil.isMobile(request)) {

			return true;
		}
		else if (os.equals(WINDOWS) && BrowserSnifferUtil.isWindows(request)) {
			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-desktop";
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
		Map<String, String> values) {

		return values.get("os");
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		String os = StringPool.BLANK;

		if (!values.isEmpty()) {
			os = values.get("os");
		}
		else if (ruleInstance != null) {
			os = ruleInstance.getTypeSettings();
		}

		context.put("operatingSystems", _AVAILABLE_OS);
		context.put("os", os);
	}

	private static final String[] _AVAILABLE_OS = {
		ANDROID, IOS, LINUX, MAC, WINDOWS
	};

}