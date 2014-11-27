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

package com.liferay.content.targeting.rule.device;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.categories.SessionAttributesRuleCategory;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.PortletDataException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mobile.device.rulegroup.RuleGroupProcessorUtil;
import com.liferay.portal.kernel.mobile.device.rulegroup.rule.RuleHandler;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.mobiledevicerules.model.MDRRule;
import com.liferay.portlet.mobiledevicerules.model.MDRRuleGroup;
import com.liferay.portlet.mobiledevicerules.service.MDRRuleGroupLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
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
 * @author Julio Camarero
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class DeviceRule extends BaseRule {

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

		long mdrRuleGroupId = getMDRRuleGroupId(ruleInstance);

		if (mdrRuleGroupId <= 0) {
			return false;
		}

		MDRRuleGroup mdrRuleGroup = null;

		try {
			mdrRuleGroup = MDRRuleGroupLocalServiceUtil.getMDRRuleGroup(
				mdrRuleGroupId);
		}
		catch (SystemException se) {
			_log.error(se);

			return false;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return evaluateRuleGroup(mdrRuleGroup, themeDisplay);
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment, Element ruleInstanceElement,
			RuleInstance ruleInstance)
		throws Exception {

		long mdrRuleGroupId = getMDRRuleGroupId(ruleInstance);

		MDRRuleGroup mdrRuleGroup =
			MDRRuleGroupLocalServiceUtil.fetchMDRRuleGroup(mdrRuleGroupId);

		if (mdrRuleGroup != null) {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

			jsonObj.put("mdrRuleGroupId", mdrRuleGroup.getUuid());

			ruleInstance.setTypeSettings(jsonObj.toString());

			portletDataContext.addReferenceElement(
				userSegment, userSegmentElement, mdrRuleGroup,
				PortletDataContext.REFERENCE_TYPE_DEPENDENCY, true);

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, MDRRuleGroup.class.getName(),
				String.valueOf(mdrRuleGroupId), Constants.EXPORT));
	}

	@Override
	public String getIcon() {
		return "icon-tablet";
	}

	@Override
	public String getRuleCategoryKey() {
		return SessionAttributesRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		long mdrRuleGroupId = getMDRRuleGroupId(ruleInstance);

		if (mdrRuleGroupId <= 0) {
			return StringPool.BLANK;
		}

		MDRRuleGroup mdrRuleGroup = null;

		try {
			mdrRuleGroup = MDRRuleGroupLocalServiceUtil.fetchMDRRuleGroup(
				mdrRuleGroupId);
		}
		catch (SystemException se) {
			_log.error(se);
		}

		if (mdrRuleGroup == null) {
			return StringPool.BLANK;
		}

		StringBuilder sb = new StringBuilder(3);

		sb.append(LanguageUtil.get(locale, "device-family"));
		sb.append(StringPool.COLON);
		sb.append(StringPool.SPACE);
		sb.append(mdrRuleGroup.getName(locale));

		String description = mdrRuleGroup.getDescription(locale);

		if (Validator.isNotNull(description)) {
			sb.append(StringPool.COLON);
			sb.append(StringPool.SPACE);
			sb.append(mdrRuleGroup.getDescription(locale));
		}

		return sb.toString();
	}

	@Override
	public void importData(
			PortletDataContext portletDataContext, UserSegment userSegment,
			RuleInstance ruleInstance)
		throws Exception {

		String mdrRuleGroupUuid = StringPool.BLANK;

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
				ruleInstance.getTypeSettings());

			mdrRuleGroupUuid = jsonObj.getString("mdrRuleGroupId");
		}
		catch (JSONException jse) {
		}

		MDRRuleGroup mdrRuleGroup =
			MDRRuleGroupLocalServiceUtil.fetchMDRRuleGroupByUuidAndGroupId(
				mdrRuleGroupUuid, portletDataContext.getScopeGroupId());

		if (mdrRuleGroup != null ) {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

			jsonObj.put("mdrRuleGroupId", mdrRuleGroup.getRuleGroupId());

			ruleInstance.setTypeSettings(jsonObj.toString());

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, MDRRuleGroup.class.getName(),
				mdrRuleGroupUuid, Constants.IMPORT));
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		long mdrRuleGroupId = GetterUtil.getInteger(
			values.get("mdrRuleGroupId"));

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("mdrRuleGroupId", mdrRuleGroupId);

		return jsonObj.toString();
	}

	protected boolean evaluateRule(MDRRule rule, ThemeDisplay themeDisplay) {
		RuleGroupProcessorUtil.getRuleHandler(rule.getType());

		RuleHandler ruleHandler = RuleGroupProcessorUtil.getRuleHandler(
			rule.getType());

		if (ruleHandler != null) {
			return ruleHandler.evaluateRule(rule, themeDisplay);
		}
		else if (_log.isWarnEnabled()) {
			_log.warn("No rule handler registered for type " + rule.getType());
		}

		return false;
	}

	protected boolean evaluateRuleGroup(
			MDRRuleGroup mdrRuleGroup, ThemeDisplay themeDisplay)
		throws SystemException {

		Collection<MDRRule> mdrRules = mdrRuleGroup.getRules();

		for (MDRRule mdrRule : mdrRules) {
			if (!evaluateRule(mdrRule, themeDisplay)) {
				return false;
			}
		}

		return true;
	}

	protected long getMDRRuleGroupId(RuleInstance ruleInstance) {
		long mdrRuleGroupId = 0;

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
				ruleInstance.getTypeSettings());

			mdrRuleGroupId = jsonObj.getLong("mdrRuleGroupId");
		}
		catch (JSONException jse) {
		}

		return mdrRuleGroupId;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		long mdrRuleGroupId = 0;

		if (!values.isEmpty()) {
			mdrRuleGroupId = GetterUtil.getInteger(
				values.get("mdrRuleGroupId"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				mdrRuleGroupId = jsonObj.getInt("mdrRuleGroupId");
			}
			catch (JSONException jse) {
			}
		}

		context.put("mdrRuleGroupId", mdrRuleGroupId);

		LinkedHashMap<String, Object> params =
			new LinkedHashMap<String, Object>();

		params.put("includeGlobalScope", Boolean.TRUE);

		long groupId = GetterUtil.getLong(context.get("scopeGroupId"));

		List<MDRRuleGroup> mdrRuleGroups = new ArrayList<MDRRuleGroup>();

		try {
			mdrRuleGroups = MDRRuleGroupLocalServiceUtil.searchByKeywords(
				groupId, null, params, false, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		}
		catch (SystemException se) {
			_log.error(se);
		}

		context.put("mdrRuleGroups", mdrRuleGroups);

		boolean hasMDRViewPermission =
			ContentTargetingContextUtil.hasControlPanelPortletViewPermission(
				context, PortletKeys.MOBILE_DEVICE_SITE_ADMIN);

		if (hasMDRViewPermission) {
			context.put(
				"mDRURL",
				ContentTargetingContextUtil.getSiteAdministrationPortletURL(
					context, PortletKeys.MOBILE_DEVICE_SITE_ADMIN, null));
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DeviceRule.class);

}