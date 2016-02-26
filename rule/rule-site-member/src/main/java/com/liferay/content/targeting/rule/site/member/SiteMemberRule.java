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

package com.liferay.content.targeting.rule.site.member;

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
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.GroupService;
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
public class SiteMemberRule extends BaseRule {

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

		long siteId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		return _userLocalService.hasGroupUser(
			siteId, anonymousUser.getUserId());
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment, Element ruleInstanceElement,
			RuleInstance ruleInstance)
		throws Exception {

		long groupId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		Group group = _groupLocalService.fetchGroup(groupId);

		if (group == null) {
			throw new PortletDataException(
				getExportImportErrorMessage(
					userSegment, ruleInstance, Group.class.getName(),
					String.valueOf(groupId), Constants.EXPORT));
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
		try {
			long siteId = GetterUtil.getLong(ruleInstance.getTypeSettings());

			Group group = _groupLocalService.fetchGroup(siteId);

			if (group == null) {
				return StringPool.BLANK;
			}

			return group.getDescriptiveName(locale);
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

		String groupUuid = ruleInstance.getTypeSettings();

		Group group = _groupLocalService.fetchGroupByUuidAndCompanyId(
			groupUuid, portletDataContext.getCompanyId());

		if (group != null) {
			ruleInstance.setTypeSettings(String.valueOf(group.getGroupId()));

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, Group.class.getName(), groupUuid,
				Constants.IMPORT));
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		return values.get("siteId");
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		long siteId = 0;

		if (!values.isEmpty()) {
			siteId = GetterUtil.getLong(values.get("siteId"));
		}
		else if (ruleInstance != null) {
			siteId = GetterUtil.getLong(ruleInstance.getTypeSettings());
		}

		context.put("siteId", siteId);

		Company company = (Company)context.get("company");

		List<Group> sites = new ArrayList<>();

		try {
			sites = _groupService.getGroups(
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
						context, PortletKeys.SITE_ADMIN);

			if (hasSitesAdminViewPermission) {
				context.put(
					"sitesAdminURL",
					ContentTargetingContextUtil.getControlPanelPortletURL(
						context, PortletKeys.SITE_ADMIN, null));
			}
		}
	}

	@Reference(unbind = "-")
	protected void setGroupLocalService(GroupLocalService groupLocalService) {
		_groupLocalService = groupLocalService;
	}

	@Reference(unbind = "-")
	protected void setGroupService(GroupService groupService) {
		_groupService = groupService;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private GroupLocalService _groupLocalService;
	private GroupService _groupService;
	private UserLocalService _userLocalService;

}