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

package com.liferay.content.targeting.portlet.action;

import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RuleCategoriesRegistry;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.exception.InvalidRuleException;
import com.liferay.content.targeting.exception.InvalidRulesException;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.portlet.util.RuleTemplate;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.RuleInstanceService;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.taglib.aui.ValidatorTag;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.EDIT_USER_SEGMENT
	},
	service = MVCRenderCommand.class
)
public class EditUserSegmentMVCActionCommand extends BaseMVCRenderCommand {

	@Override
	public String doRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		long userSegmentId = ParamUtil.getLong(renderRequest, "userSegmentId");

		renderRequest.setAttribute(
			"ruleCategoriesRegistry", _ruleCategoriesRegistry);

		Map<String, Rule> rules = _rulesRegistry.getRules();

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		boolean isolated = themeDisplay.isIsolated();

		try {
			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

			themeDisplay.setIsolated(true);

			renderRequest.setAttribute("rules", rules.values());

			List<RuleInstance> ruleInstances = getRulesFromRequest(
				renderRequest, renderResponse);

			if (ruleInstances.isEmpty() && (userSegmentId > 0)) {
				ruleInstances = _ruleInstanceService.getRuleInstances(
					userSegmentId);
			}

			List<RuleTemplate> addedRuleTemplates = new ArrayList<>();

			if (!ruleInstances.isEmpty()) {
				renderRequest.setAttribute("ruleInstances", ruleInstances);

				InvalidRulesException ire = getInvalidRulesException(
					renderRequest);

				for (RuleInstance ruleInstance : ruleInstances) {
					Rule rule = _rulesRegistry.getRule(
						ruleInstance.getRuleKey());

					if (rule == null) {
						continue;
					}

					RuleTemplate ruleTemplate = new RuleTemplate();

					if (ruleInstance.getRuleInstanceId() > 0) {
						ruleTemplate.setInstanceId(
							String.valueOf(ruleInstance.getRuleInstanceId()));
					}
					else {
						ruleTemplate.setInstanceId(ruleInstance.getRuleGuid());
					}

					ruleTemplate.setRule(rule);

					String html = getRuleHtml(
						rule, ruleInstance, renderRequest, renderResponse,
						ruleInstance.getValues(),
						ire.getRuleExceptions(ruleInstance.getRuleGuid()));

					ruleTemplate.setTemplate(HtmlUtil.escapeAttribute(html));

					addedRuleTemplates.add(ruleTemplate);
				}
			}

			renderRequest.setAttribute(
				"addedRuleTemplates", addedRuleTemplates);

			List<RuleTemplate> ruleTemplates = new ArrayList<>();

			for (Rule rule : rules.values()) {
				if (!rule.isVisible()) {
					continue;
				}

				RuleTemplate ruleTemplate = new RuleTemplate();

				ruleTemplate.setRule(rule);

				String html = getRuleHtml(
					rule, null, renderRequest, renderResponse, null, null);

				ruleTemplate.setTemplate(HtmlUtil.escapeAttribute(html));

				ruleTemplates.add(ruleTemplate);
			}

			renderRequest.setAttribute("ruleTemplates", ruleTemplates);
		}
		finally {
			themeDisplay.setIsolated(isolated);
		}

		return ContentTargetingPath.EDIT_USER_SEGMENT;
	}

	protected InvalidRulesException getInvalidRulesException(
		PortletRequest portletRequest) {

		if (SessionErrors.contains(
				portletRequest, InvalidRulesException.class.getName())) {

			return (InvalidRulesException)SessionErrors.get(
				portletRequest, InvalidRulesException.class.getName());
		}
		else {
			return new InvalidRulesException();
		}
	}

	protected String getRuleHtml(
		Rule rule, RuleInstance ruleInstance, RenderRequest renderRequest,
		RenderResponse renderResponse, Map<String, String> values,
		List<InvalidRuleException> exceptions) {

		Map<String, Object> context = cloneRequestContext(
			renderRequest, renderResponse);

		String html = StringPool.BLANK;

		if ((exceptions != null) && !exceptions.isEmpty()) {
			try {
				context.put("exceptions", exceptions);

				html += ContentTargetingContextUtil.parseTemplate(
					getClass(), "templates/ct_exceptions.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		Map<String, List<ValidatorTag>> validatorTagsMap = new HashMap<>();

		request.setAttribute("aui:form:validatorTagsMap", validatorTagsMap);

		if (values == null) {
			values = Collections.emptyMap();
		}

		html += rule.getFormHTML(ruleInstance, context, values);

		if (!validatorTagsMap.isEmpty()) {
			try {
				context.put("validatorTagsMap", validatorTagsMap);

				html += ContentTargetingContextUtil.parseTemplate(
					getClass(), "templates/ct_validators.ftl", context);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		return html;
	}

	protected List<RuleInstance> getRulesFromRequest(
			PortletRequest request, PortletResponse response)
		throws Exception {

		List<RuleInstance> ruleInstances = new ArrayList<>();

		String userSegmentRules = ParamUtil.getString(
			request, "userSegmentRules");

		if (Validator.isNull(userSegmentRules)) {
			return ruleInstances;
		}

		JSONObject jSONObject = JSONFactoryUtil.createJSONObject(
			userSegmentRules);

		String rules = jSONObject.getString("fields");

		JSONArray jSONArray = JSONFactoryUtil.createJSONArray(rules);

		for (int i = 0; i < jSONArray.length(); i++) {
			JSONObject jSONObjectRule = jSONArray.getJSONObject(i);

			long ruleInstanceId = 0;

			String type = jSONObjectRule.getString("type");

			if (type.contains(StringPool.UNDERLINE)) {
				String[] ids = type.split(StringPool.UNDERLINE);

				ruleInstanceId = GetterUtil.getLong(ids[1]);
				type = ids[0];
			}

			String id = jSONObjectRule.getString("id");

			Map<String, String> ruleValues = getJSONValues(
				jSONObjectRule.getJSONArray("data"), response.getNamespace(),
				id);

			RuleInstance ruleInstance =
				_ruleInstanceLocalService.createRuleInstance(ruleInstanceId);

			ruleInstance.setRuleGuid(id);
			ruleInstance.setRuleKey(type);
			ruleInstance.setValues(ruleValues);

			ruleInstances.add(ruleInstance);
		}

		return ruleInstances;
	}

	@Reference(unbind = "unsetRuleCategoriesRegistry")
	protected void setRuleCategoriesRegistry(
		RuleCategoriesRegistry ruleCategoriesRegistry) {

		_ruleCategoriesRegistry = ruleCategoriesRegistry;
	}

	@Reference(unbind = "unsetRuleInstanceLocalService")
	protected void setRuleInstanceLocalService(
		RuleInstanceLocalService ruleInstanceLocalService) {

		_ruleInstanceLocalService = ruleInstanceLocalService;
	}

	@Reference(unbind = "unsetRuleInstanceService")
	protected void setRuleInstanceService(
		RuleInstanceService ruleInstanceService) {

		_ruleInstanceService = ruleInstanceService;
	}

	@Reference(unbind = "unsetRulesRegistry")
	protected void setRulesRegistry(RulesRegistry rulesRegistry) {
		_rulesRegistry = rulesRegistry;
	}

	protected void unsetRuleCategoriesRegistry() {
		_ruleCategoriesRegistry = null;
	}

	protected void unsetRuleInstanceLocalService() {
		_ruleInstanceLocalService = null;
	}

	protected void unsetRuleInstanceService() {
		_ruleInstanceService = null;
	}

	protected void unsetRulesRegistry() {
		_rulesRegistry = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditUserSegmentMVCActionCommand.class);

	private RuleCategoriesRegistry _ruleCategoriesRegistry;
	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RuleInstanceService _ruleInstanceService;
	private RulesRegistry _rulesRegistry;

}