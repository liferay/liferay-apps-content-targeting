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

package com.liferay.content.targeting.rule.organization.member;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.categories.UserAttributesRuleCategory;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
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
public class OrganizationMemberRule extends BaseRule {

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

		long organizationId = GetterUtil.getLong(
			ruleInstance.getTypeSettings());

		return _userLocalService.hasOrganizationUser(
			organizationId, anonymousUser.getUserId());
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment, Element ruleInstanceElement,
			RuleInstance ruleInstance)
		throws Exception {

		long organizationId = GetterUtil.getLong(
			ruleInstance.getTypeSettings());

		Organization organization = _organizationLocalService.fetchOrganization(
			organizationId);

		if (organization != null) {
			ruleInstance.setTypeSettings(organization.getUuid());

			portletDataContext.addReferenceElement(
				ruleInstance, ruleInstanceElement, organization,
				PortletDataContext.REFERENCE_TYPE_WEAK, true);

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, Organization.class.getName(),
				String.valueOf(organizationId), Constants.EXPORT));
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
		try {
			long organizationId = GetterUtil.getLong(
				ruleInstance.getTypeSettings());

			Organization organization =
				_organizationLocalService.fetchOrganization(organizationId);

			if (organization == null) {
				return StringPool.BLANK;
			}

			return organization.getName();
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

		String organizationUuid = ruleInstance.getTypeSettings();

		Organization organization =
			_organizationLocalService.fetchOrganizationByUuidAndCompanyId(
				organizationUuid, portletDataContext.getCompanyId());

		if (organization != null) {
			ruleInstance.setTypeSettings(
				String.valueOf(organization.getOrganizationId()));

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, Organization.class.getName(),
				organizationUuid, Constants.IMPORT));
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		return values.get("organizationId");
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		long organizationId = 0;

		if (!values.isEmpty()) {
			organizationId = GetterUtil.getLong(values.get("organizationId"));
		}
		else if (ruleInstance != null) {
			organizationId = GetterUtil.getLong(ruleInstance.getTypeSettings());
		}

		context.put("organizationId", organizationId);

		Company company = (Company)context.get("company");

		List<Organization> organizations = new ArrayList<>();

		try {

			// See LPS-50218

			organizations = _organizationLocalService.getOrganizations(
				company.getCompanyId(),
				OrganizationConstants.ANY_PARENT_ORGANIZATION_ID);
		}
		catch (SystemException se) {
		}

		context.put("organizations", organizations);

		if ((organizations == null) || organizations.isEmpty()) {
			boolean hasUsersAdminViewPermission =
				ContentTargetingContextUtil.
					hasControlPanelPortletViewPermission(
						context, PortletKeys.USERS_ADMIN);

			if (hasUsersAdminViewPermission) {
				context.put(
					"usersAdminURL",
					ContentTargetingContextUtil.getControlPanelPortletURL(
						context, PortletKeys.USERS_ADMIN, null));
			}
		}
	}

	@Reference(unbind = "-")
	protected void setOrganizationLocalService(
		OrganizationLocalService organizationLocalService) {

		_organizationLocalService = organizationLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private OrganizationLocalService _organizationLocalService;
	private UserLocalService _userLocalService;

}