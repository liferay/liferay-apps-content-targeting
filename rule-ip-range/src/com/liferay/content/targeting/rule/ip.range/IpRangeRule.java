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

package com.liferay.content.targeting.rule.ip.range;

import com.liferay.content.targeting.InvalidRuleException;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.SessionAttributesRuleCategory;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Brian Chan
 */
@Component(immediate = true, service = Rule.class)
public class IpRangeRule extends BaseRule {

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

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
			ruleInstance.getTypeSettings());

		long userIp = _ipToLong(anonymousUser.getLastIp());
		long ipFrom = _ipToLong(jsonObj.getString("ipFrom"));
		long ipTo = _ipToLong(jsonObj.getString("ipTo"));

		if ((userIp >= ipFrom) && (userIp <= ipTo)) {
			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-sitemap";
	}

	@Override
	public String getRuleCategoryKey() {
		return SessionAttributesRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String summary = StringPool.BLANK;

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
				ruleInstance.getTypeSettings());

			String ipFrom = jsonObj.getString("ipFrom");
			String ipTo = jsonObj.getString("ipTo");

			if (Validator.isNotNull(ipFrom) && Validator.isNotNull(ipTo)) {
				summary = LanguageUtil.format(
					locale, "user-ip-is-between-x-and-x",
					new Object[] {ipFrom, ipTo});
			}
		}
		catch (Exception e) {
		}

		return summary;
	}

	@Override
	public String processRule(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidRuleException {

		String ipFrom = values.get("ipFrom");
		String ipTo = values.get("ipTo");

		try {
			long lIpFrom = _ipToLong(ipFrom);
			long lIpTo = _ipToLong(ipTo);

			if (lIpFrom > lIpTo) {
				throw new InvalidRuleException("invalid-ip-range");
			}
		}
		catch (UnknownHostException uhe) {
			throw new InvalidRuleException("invalid-ip-format");
		}

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("ipFrom", ipFrom);
		jsonObj.put("ipTo", ipTo);

		return jsonObj.toString();
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		String ipFrom = StringPool.BLANK;
		String ipTo = StringPool.BLANK;

		if (!values.isEmpty()) {
			ipFrom = values.get("ipFrom");
			ipTo = values.get("ipTo");
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				ipFrom = jsonObj.getString("ipFrom");
				ipTo = jsonObj.getString("ipTo");
			}
			catch (JSONException jse) {
			}
		}

		context.put("ipFrom", ipFrom);
		context.put("ipTo", ipTo);
	}

	private long _ipToLong(String ip) throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getByName(ip);

		inetAddress.getAddress();

		byte[] octets = inetAddress.getAddress();

		long result = 0;

		for (byte octet : octets) {
			result <<= 8;
			result |= octet & 0xff;
		}

		return result;
	}

}