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

package com.liferay.portal.contenttargeting.rule.role;

import com.liferay.portal.contenttargeting.anonymoususers.model.AnonymousUser;
import com.liferay.portal.contenttargeting.api.model.BaseRule;
import com.liferay.portal.contenttargeting.api.model.Rule;
import com.liferay.portal.contenttargeting.model.RuleInstance;
import com.liferay.portal.contenttargeting.rulecategories.UserAttributesRuleCategory;
import com.liferay.portal.contenttargeting.util.ContentTargetingContextUtil;
import com.liferay.portal.contenttargeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.GroupServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
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
public class SiteRoleRule extends BaseRule {

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

		String typeSettings = ruleInstance.getTypeSettings();

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			long siteId = jsonObj.getLong("siteId");

			if (siteId <= 0) {
				return false;
			}

			long roleId = jsonObj.getLong("roleId");

			return UserGroupRoleLocalServiceUtil.hasUserGroupRole(
				anonymousUser.getUserId(), siteId, roleId);
		}
		catch (JSONException e) {
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-globe";
	}

	@Override
	public String getRuleCategoryKey() {
		return UserAttributesRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			long roleId = jsonObj.getLong("roleId");

			Role role = RoleLocalServiceUtil.fetchRole(roleId);

			if (role == null) {
				return StringPool.BLANK;
			}

			long siteId = jsonObj.getLong("siteId");

			Group group = GroupLocalServiceUtil.fetchGroup(siteId);

			if (group == null) {
				return role.getTitle(locale);
			}

			StringBundler sb = new StringBundler();

			sb.append(role.getTitle(locale));
			sb.append(StringPool.SPACE);
			sb.append(group.getDescriptiveName(locale));

			return sb.toString();
		}
		catch (Exception e) {
		}

		return StringPool.BLANK;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		long roleId = GetterUtil.getLong(values.get("roleId"));
		long siteId = GetterUtil.getLong(values.get("siteId"));

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("roleId", roleId);
		jsonObj.put("siteId", siteId);

		return jsonObj.toString();
	}

	@Override
	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		long roleId = 0;
		long siteId = 0;

		if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				roleId = jsonObj.getLong("roleId");
				siteId = jsonObj.getLong("siteId");
			}
			catch (JSONException jse) {
			}
		}

		context.put("roleId", roleId);
		context.put("siteId", siteId);

		Company company = (Company)context.get("company");

		List<Role> roles = new ArrayList<Role>();

		try {
			roles = RoleLocalServiceUtil.getRoles(
				company.getCompanyId(), new int[] {RoleConstants.TYPE_SITE});

			Role role = RoleLocalServiceUtil.fetchRole(
				company.getCompanyId(), RoleConstants.SITE_MEMBER);

			List<Role> removeRoles = new ArrayList<Role>();

			removeRoles.add(role);

			roles = ListUtil.remove(roles, removeRoles);
		}
		catch (SystemException e) {
		}

		context.put("roles", roles);

		List<Group> sites = new ArrayList<Group>();

		try {
			sites = GroupServiceUtil.getGroups(
				company.getCompanyId(), GroupConstants.ANY_PARENT_GROUP_ID,
				true);
		}
		catch (Exception e) {
		}

		context.put("sites", sites);

		if ((sites == null) || sites.isEmpty()) {
			boolean hasSitesAdminViewPermission =
				ContentTargetingContextUtil.
					hasControlPanelPortletViewPermission(
						context, PortletKeys.SITES_ADMIN);

			if (hasSitesAdminViewPermission) {
				context.put(
					"sitesAdminURL",
					ContentTargetingContextUtil.getControlPanelPortletURL(
						context, PortletKeys.SITES_ADMIN, null));
			}
		}
	}

	protected static final String _FORM_TEMPLATE_PATH =
		"templates/ct_fields_site.ftl";

}