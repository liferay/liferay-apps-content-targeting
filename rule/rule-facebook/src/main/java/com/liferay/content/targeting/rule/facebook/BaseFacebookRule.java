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

package com.liferay.content.targeting.rule.facebook;

import com.liferay.content.targeting.api.model.BaseJSPRule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.facebook.FacebookConnectUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Company;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
public abstract class BaseFacebookRule extends BaseJSPRule {

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.rule.facebook)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	protected abstract void doPopulateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values);

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		Company company = (Company)context.get("company");

		boolean isFbLoginEnabled = false;

		try {
			isFbLoginEnabled = FacebookConnectUtil.isEnabled(
				company.getCompanyId());
		}
		catch (SystemException se) {
		}

		context.put("isFbLoginEnabled", isFbLoginEnabled);

		if (!isFbLoginEnabled) {
			boolean hasPortalSettingsViewPermission =
				ContentTargetingContextUtil.
					hasControlPanelPortletViewPermission(
						context, PortletKeys.PORTAL_SETTINGS);

			if (hasPortalSettingsViewPermission) {
				Map<String, String> params = new HashMap<>();

				params.put("historyKey", "_130_authentication");

				context.put(
					"portalSettingsURL",
					ContentTargetingContextUtil.getControlPanelPortletURL(
						context, PortletKeys.PORTAL_SETTINGS, params));
			}
		}

		doPopulateContext(ruleInstance, context, values);
	}

}