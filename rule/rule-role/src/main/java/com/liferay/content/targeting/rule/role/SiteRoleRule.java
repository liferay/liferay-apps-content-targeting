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

package com.liferay.content.targeting.rule.role;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseJSPRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.categories.UserAttributesRuleCategory;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Element;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class SiteRoleRule extends BaseJSPRule {

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

			return _userGroupRoleLocalService.hasUserGroupRole(
				anonymousUser.getUserId(), siteId, roleId);
		}
		catch (JSONException jsone) {
		}

		return false;
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment, Element ruleInstanceElement,
			RuleInstance ruleInstance)
		throws Exception {

		String typeSettings = ruleInstance.getTypeSettings();

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			long roleId = jsonObj.getLong("roleId");

			Role role = _roleLocalService.fetchRole(roleId);

			if (role == null) {
				throw new PortletDataException(
					getExportImportErrorMessage(
						userSegment, ruleInstance, Role.class.getName(),
						String.valueOf(roleId), Constants.EXPORT));
			}

			long siteId = jsonObj.getLong("siteId");

			Group group = _groupLocalService.fetchGroup(siteId);

			if (group == null) {
				throw new PortletDataException(
					getExportImportErrorMessage(
						userSegment, ruleInstance, Group.class.getName(),
						String.valueOf(siteId), Constants.EXPORT));
			}

			jsonObj = JSONFactoryUtil.createJSONObject();

			jsonObj.put("roleUuid", role.getUuid());
			jsonObj.put("siteUuid", group.getUuid());

			ruleInstance.setTypeSettings(jsonObj.toString());

			portletDataContext.addReferenceElement(
				ruleInstance, ruleInstanceElement, role,
				PortletDataContext.REFERENCE_TYPE_WEAK, true);

			portletDataContext.addReferenceElement(
				ruleInstance, ruleInstanceElement, group,
				PortletDataContext.REFERENCE_TYPE_WEAK, true);
		}
		catch (JSONException jsone) {
		}
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

			Role role = _roleLocalService.fetchRole(roleId);

			if (role == null) {
				return StringPool.DASH;
			}

			long siteId = jsonObj.getLong("siteId");

			Group group = _groupLocalService.fetchGroup(siteId);

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
	public void importData(
			PortletDataContext portletDataContext, UserSegment userSegment,
			RuleInstance ruleInstance)
		throws Exception {

		String typeSettings = ruleInstance.getTypeSettings();

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			String roleUuid = jsonObj.getString("roleUuid");

			Role role = _roleLocalService.fetchRoleByUuidAndCompanyId(
				roleUuid, portletDataContext.getCompanyId());

			if (role == null) {
				throw new PortletDataException(
					getExportImportErrorMessage(
						userSegment, ruleInstance, Role.class.getName(),
						roleUuid, Constants.IMPORT));
			}

			String siteUuid = jsonObj.getString("siteUuid");

			Group group = _groupLocalService.fetchGroupByUuidAndCompanyId(
				siteUuid, portletDataContext.getCompanyId());

			if (group == null) {
				throw new PortletDataException(
					getExportImportErrorMessage(
						userSegment, ruleInstance, Group.class.getName(),
						siteUuid, Constants.IMPORT));
			}

			jsonObj = JSONFactoryUtil.createJSONObject();

			jsonObj.put("roleId", role.getRoleId());
			jsonObj.put("siteId", group.getGroupId());

			ruleInstance.setTypeSettings(jsonObj.toString());
		}
		catch (JSONException jsone) {
		}
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
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.rule.role)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	@Override
	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		long roleId = 0;
		long siteId = 0;

		if (!values.isEmpty()) {
			roleId = GetterUtil.getLong(values.get("roleId"));
			siteId = GetterUtil.getLong(values.get("siteId"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				roleId = jsonObj.getLong("roleId");
				siteId = jsonObj.getLong("siteId");
			}
			catch (JSONException jsone) {
			}
		}

		context.put("roleId", roleId);
		context.put("siteId", siteId);
	}

	@Reference(unbind = "-")
	protected void setGroupLocalService(GroupLocalService groupLocalService) {
		_groupLocalService = groupLocalService;
	}

	@Reference(unbind = "-")
	protected void setRoleLocalService(RoleLocalService roleLocalService) {
		_roleLocalService = roleLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserGroupRoleLocalService(
		UserGroupRoleLocalService userGroupRoleLocalService) {

		_userGroupRoleLocalService = userGroupRoleLocalService;
	}

	private static final String _FORM_TEMPLATE_PATH = "/view_site.jsp";

	private GroupLocalService _groupLocalService;
	private RoleLocalService _roleLocalService;
	private UserGroupRoleLocalService _userGroupRoleLocalService;

}