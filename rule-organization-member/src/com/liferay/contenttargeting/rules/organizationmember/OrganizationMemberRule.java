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

package com.liferay.contenttargeting.rules.organizationmember;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class OrganizationMemberRule extends BaseRule {

	@Override
	public boolean evaluate(
			RuleInstance ruleInstance, AnonymousUser anonymousUser)
		throws Exception {

		long organizationId = GetterUtil.getLong(
			ruleInstance.getTypeSettings());

		return UserLocalServiceUtil.hasOrganizationUser(
			organizationId, anonymousUser.getUserId());
	}

	@Override
	public String getIcon() {
		return "icon-globe";
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		try {
			long organizationId = GetterUtil.getLong(
				ruleInstance.getTypeSettings());

			Organization organization =
				OrganizationLocalServiceUtil.fetchOrganization(organizationId);

			if (organization == null) {
				return StringPool.BLANK;
			}

			return organization.getName();
		}
		catch (SystemException e) {
		}

		return StringPool.BLANK;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		return values.get("organizationId");
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		long organizationId = 0;

		if (ruleInstance != null) {
			organizationId = GetterUtil.getLong(ruleInstance.getTypeSettings());
		}

		context.put("organizationId", organizationId);

		Company company = (Company)context.get("company");

		List<Organization> organizations = new ArrayList<Organization>();

		try {
			organizations = OrganizationLocalServiceUtil.getOrganizations(
				company.getCompanyId(),
				OrganizationConstants.ANY_PARENT_ORGANIZATION_ID);
		}
		catch (SystemException e) {
		}

		context.put("organizations", organizations);
	}

}