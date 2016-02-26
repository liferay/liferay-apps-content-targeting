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
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.categories.UserAttributesRuleCategory;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Element;

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
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class RegularRoleRule extends BaseRule {

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

		long roleId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		Role role = _roleLocalService.fetchRole(roleId);

		if (role == null) {
			return false;
		}

		if (anonymousUser.getUserId() != 0) {
			return _roleLocalService.hasUserRole(
				anonymousUser.getUserId(), roleId);
		}

		String roleName = role.getName();

		if (roleName.equals(RoleConstants.GUEST)) {
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

		long roleId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		Role role = _roleLocalService.fetchRole(roleId);

		if (role != null) {
			ruleInstance.setTypeSettings(role.getUuid());

			portletDataContext.addReferenceElement(
				ruleInstance, ruleInstanceElement, role,
				PortletDataContext.REFERENCE_TYPE_WEAK, true);

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, Role.class.getName(),
				String.valueOf(roleId), Constants.EXPORT));
	}

	@Override
	public String getIcon() {
		return "icon-group";
	}

	@Override
	public String getRuleCategoryKey() {
		return UserAttributesRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		long roleId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		try {
			Role role = _roleLocalService.fetchRole(roleId);

			return role.getTitle(locale);
		}
		catch (SystemException se) {
		}

		return StringPool.BLANK;
	}

	@Override
	public void importData(
			PortletDataContext portletDataContext, UserSegment userSegment,
			RuleInstance ruleInstance)
		throws Exception {

		String roleUuid = ruleInstance.getTypeSettings();

		Role role = _roleLocalService.fetchRoleByUuidAndCompanyId(
			roleUuid, portletDataContext.getCompanyId());

		if (role != null) {
			ruleInstance.setTypeSettings(String.valueOf(role.getRoleId()));

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, Role.class.getName(), roleUuid,
				Constants.IMPORT));
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		return values.get("roleId");
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

		if (!values.isEmpty()) {
			roleId = GetterUtil.getLong(values.get("roleId"));
		}
		else if (ruleInstance != null) {
			roleId = GetterUtil.getLong(ruleInstance.getTypeSettings());
		}

		context.put("roleId", roleId);

		Company company = (Company)context.get("company");

		List<Role> roles = new ArrayList<>();

		try {

			// See LPS-55480

			roles = _roleLocalService.getRoles(
				company.getCompanyId(), new int[] {RoleConstants.TYPE_REGULAR});
		}
		catch (SystemException se) {
		}

		context.put("roles", roles);
	}

	@Reference(unbind = "-")
	protected void setRoleLocalService(RoleLocalService roleLocalService) {
		_roleLocalService = roleLocalService;
	}

	private static final String _FORM_TEMPLATE_PATH =
		"templates/ct_fields_regular.ftl";

	private RoleLocalService _roleLocalService;

}