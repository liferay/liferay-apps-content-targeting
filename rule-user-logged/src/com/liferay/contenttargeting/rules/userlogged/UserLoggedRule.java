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

package com.liferay.contenttargeting.rules.userlogged;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.UserGroupLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class UserLoggedRule extends BaseRule {

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		long userGroupId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		return UserGroupLocalServiceUtil.hasUserUserGroup(
			anonymousUser.getUserId(), userGroupId);
	}

	@Override
	public String getCategoryKey() {
		return "user-membership";
	}

	@Override
	public String getIcon() {
		return "icon-group";
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		try {
			long userGroupId = GetterUtil.getLong(
				ruleInstance.getTypeSettings());

			UserGroup userGroup = UserGroupLocalServiceUtil.fetchUserGroup(
				userGroupId);

			if (userGroup == null) {
				return StringPool.BLANK;
			}

			return userGroup.getName();
		}
		catch (Exception e) {
		}

		return StringPool.BLANK;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		return values.get("userGroupId");
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		long userGroupId = 0;

		if (ruleInstance != null) {
			userGroupId = GetterUtil.getLong(ruleInstance.getTypeSettings());
		}

		context.put("userGroupId", userGroupId);

		Company company = (Company)context.get("company");

		List<UserGroup> userGroups = new ArrayList<UserGroup>();

		try {
			userGroups = UserGroupLocalServiceUtil.getUserGroups(
				company.getCompanyId());
		}
		catch (SystemException e) {
		}

		context.put("userGroups", userGroups);
	}

}