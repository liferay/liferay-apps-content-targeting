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

package com.liferay.content.targeting.web.display.context;

import com.liferay.content.targeting.api.model.RuleCategoriesRegistry;
import com.liferay.content.targeting.web.util.RuleTemplate;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletURL;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingEditUserSegmentDisplayContext
	extends BaseContentTargetingUserSegmentDisplayContext {

	public ContentTargetingEditUserSegmentDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);
	}

	public List<RuleTemplate> getAddedRuleTemplates() {
		if (_addedRuleTemplates != null) {
			return _addedRuleTemplates;
		}

		_addedRuleTemplates = (List<RuleTemplate>)request.getAttribute(
			"addedRuleTemplates");

		return _addedRuleTemplates;
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = liferayPortletResponse.createRenderURL();

		backURLObject.setParameter("mvcPath", "/view.jsp");
		backURLObject.setParameter("tabs1", "user-segments");

		return backURLObject.toString();
	}

	public String getCssItemsClass() {
		List<RuleTemplate> addedRuleTemplates = getAddedRuleTemplates();

		String cssItemsClass = StringPool.BLANK;

		if (!addedRuleTemplates.isEmpty()) {
			cssItemsClass = "has-items";
		}

		_cssItemsClass = cssItemsClass;

		return _cssItemsClass;
	}

	public String getRedirect() {
		if (Validator.isNotNull(_redirect)) {
			return _redirect;
		}

		String redirect = ParamUtil.getString(request, "redirect");

		if (Validator.isNull(redirect)) {
			PortletURL redirectURLObject =
				liferayPortletResponse.createRenderURL();

			redirectURLObject.setParameter("mvcPath", "/view.jsp");
			redirectURLObject.setParameter("tabs1", "user-segments");

			redirect = redirectURLObject.toString();
		}

		_redirect = redirect;

		return _redirect;
	}

	public RuleCategoriesRegistry getRuleCategoriesRegistry() {
		if (_ruleCategoriesRegistry != null) {
			return _ruleCategoriesRegistry;
		}

		_ruleCategoriesRegistry = (RuleCategoriesRegistry)request.getAttribute(
			"ruleCategoriesRegistry");

		return _ruleCategoriesRegistry;
	}

	public List<RuleTemplate> getRuleTemplates() {
		if (_ruleTemplates != null) {
			return _ruleTemplates;
		}

		_ruleTemplates = (List<RuleTemplate>)request.getAttribute(
			"ruleTemplates");

		return _ruleTemplates;
	}

	private List<RuleTemplate> _addedRuleTemplates;
	private String _cssItemsClass;
	private String _redirect;
	private RuleCategoriesRegistry _ruleCategoriesRegistry;
	private List<RuleTemplate> _ruleTemplates;

}