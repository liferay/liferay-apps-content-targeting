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

package com.liferay.content.targeting.rule.user.group.member;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseJSPRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.categories.UserAttributesRuleCategory;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
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
public class UserGroupMemberRule extends BaseJSPRule {

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

		long userGroupId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		return _userGroupLocalService.hasUserUserGroup(
			anonymousUser.getUserId(), userGroupId);
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment, Element ruleInstanceElement,
			RuleInstance ruleInstance)
		throws Exception {

		long userGroupId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		UserGroup userGroup = _userGroupLocalService.fetchUserGroup(
			userGroupId);

		if (userGroup != null) {
			ruleInstance.setTypeSettings(userGroup.getUuid());

			portletDataContext.addReferenceElement(
				ruleInstance, ruleInstanceElement, userGroup,
				PortletDataContext.REFERENCE_TYPE_WEAK, true);

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, UserGroup.class.getName(),
				String.valueOf(userGroupId), Constants.EXPORT));
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
		try {
			long userGroupId = GetterUtil.getLong(
				ruleInstance.getTypeSettings());

			UserGroup userGroup = _userGroupLocalService.fetchUserGroup(
				userGroupId);

			if (userGroup == null) {
				return StringPool.DASH;
			}

			return userGroup.getName();
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

		String userGroupUuid = ruleInstance.getTypeSettings();

		UserGroup userGroup =
			_userGroupLocalService.fetchUserGroupByUuidAndCompanyId(
				userGroupUuid, portletDataContext.getCompanyId());

		if (userGroup != null) {
			ruleInstance.setTypeSettings(
				String.valueOf(userGroup.getUserGroupId()));

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, UserGroup.class.getName(),
				userGroupUuid, Constants.IMPORT));
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		return values.get("userGroupId");
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.rule.user.group.member)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		long userGroupId = 0;

		if (!values.isEmpty()) {
			userGroupId = GetterUtil.getLong(values.get("userGroupId"));
		}
		else if (ruleInstance != null) {
			userGroupId = GetterUtil.getLong(ruleInstance.getTypeSettings());
		}

		context.put("userGroupId", userGroupId);
	}

	@Reference(unbind = "-")
	protected void setUserGroupLocalService(
		UserGroupLocalService userGroupLocalService) {

		_userGroupLocalService = userGroupLocalService;
	}

	private UserGroupLocalService _userGroupLocalService;

}