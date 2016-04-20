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

import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RuleCategoriesRegistry;
import com.liferay.content.targeting.api.model.RuleCategory;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService;
import com.liferay.content.targeting.service.RuleInstanceService;
import com.liferay.content.targeting.util.UserSegmentConstants;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.content.targeting.util.comparator.RuleCategoryNameComparator;
import com.liferay.content.targeting.util.comparator.RuleInstanceNameComparator;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingViewUserSegmentDisplayContext
	extends BaseContentTargetingUserSegmentDisplayContext {

	public ContentTargetingViewUserSegmentDisplayContext(
		AnonymousUserUserSegmentLocalService
			anonymousUserUserSegmentLocalService,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		RuleCategoriesRegistry ruleCategoriesRegistry,
		RuleInstanceService ruleInstanceService, RulesRegistry rulesRegistry) {

		super(liferayPortletRequest, liferayPortletResponse);

		_anonymousUserUserSegmentLocalService =
			anonymousUserUserSegmentLocalService;
		_ruleCategoriesRegistry = ruleCategoriesRegistry;
		_ruleInstanceService = ruleInstanceService;
		_rulesRegistry = rulesRegistry;
	}

	public ContentTargetingViewUserSegmentDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);

		_anonymousUserUserSegmentLocalService = null;
		_ruleCategoriesRegistry = null;
		_ruleInstanceService = null;
		_rulesRegistry = null;
	}

	public long getClassPK() {
		if (_classPK != null) {
			return _classPK;
		}

		if (Objects.equals(getTabs1(), "reports")) {
			_classPK = ParamUtil.getLong(request, "classPK");
		}
		else {
			_classPK = ParamUtil.getLong(request, "userSegmentId");
		}

		return _classPK;
	}

	public String getDescription() {
		if (Validator.isNotNull(_description)) {
			return _description;
		}

		UserSegment userSegment = getUserSegment();

		if (userSegment != null) {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			_description = userSegment.getDescription(themeDisplay.getLocale());
		}

		return _description;
	}

	public String getReportsURL() {
		if (Validator.isNotNull(_reportsURL)) {
			return _reportsURL;
		}

		PortletURL reportsURL = liferayPortletResponse.createRenderURL();

		reportsURL.setParameter(
			"mvcRenderCommandName",
			ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT);
		reportsURL.setParameter("tabs1", "reports");
		reportsURL.setParameter(
			"classNameId",
			String.valueOf(
				PortalUtil.getClassNameId(UserSegment.class.getName())));
		reportsURL.setParameter("classPK", String.valueOf(getClassPK()));
		reportsURL.setParameter("viewType", UserSegmentConstants.VIEW_TYPE);

		_reportsURL = reportsURL.toString();

		return _reportsURL;
	}

	public Rule getRuleByRuleInstance(RuleInstance ruleInstance) {
		if (ruleInstance == null) {
			return null;
		}

		Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

		return rule;
	}

	public List<RuleCategory> getRuleCategories() {
		if (ListUtil.isNotEmpty(_ruleCategories)) {
			return _ruleCategories;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		List<RuleInstance> ruleInstances = getRuleInstances();

		List<RuleCategory> ruleCategories = new ArrayList<>();

		Set<RuleCategory> ruleCategoriesSet = new HashSet<>();

		for (RuleInstance ruleInstance : ruleInstances) {
			Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

			RuleCategory ruleCategory = _ruleCategoriesRegistry.getRuleCategory(
				rule.getRuleCategoryKey());

			ruleCategoriesSet.add(ruleCategory);
		}

		ruleCategories.addAll(ruleCategoriesSet);

		_ruleCategories = ListUtil.sort(
			ruleCategories,
			new RuleCategoryNameComparator(themeDisplay.getLocale()));

		return _ruleCategories;
	}

	public List<RuleInstance> getRuleInstances() {
		if (ListUtil.isNotEmpty(_ruleInstances)) {
			return _ruleInstances;
		}

		long userSegmentId = getUserSegmentId();

		List<RuleInstance> ruleInstances = new ArrayList<>();

		if (userSegmentId > 0) {
			ruleInstances = _ruleInstanceService.getRuleInstances(
				userSegmentId);
		}

		_ruleInstances = ruleInstances;

		return _ruleInstances;
	}

	public List<RuleInstance> getRulesByCategory(String ruleCategoryKey) {
		Map<String, List<RuleInstance>> ruleInstanceMap = _getRuleInstanceMap();

		List<RuleInstance> ruleInstances = ruleInstanceMap.get(ruleCategoryKey);

		if (ListUtil.isNotEmpty(ruleInstances)) {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			return ListUtil.sort(
				ruleInstances,
				new RuleInstanceNameComparator(
					themeDisplay.getLocale(), _rulesRegistry));
		}
		else {
			return new ArrayList<>();
		}
	}

	public String getSummaryURL() {
		if (Validator.isNotNull(_summaryURL)) {
			return _summaryURL;
		}

		PortletURL summaryURL = liferayPortletResponse.createRenderURL();

		summaryURL.setParameter(
			"mvcRenderCommandName",
			ContentTargetingMVCCommand.VIEW_USER_SEGMENT);
		summaryURL.setParameter("tabs1", "summary");
		summaryURL.setParameter(
			"userSegmentId", String.valueOf(getUserSegmentId()));

		_summaryURL = summaryURL.toString();

		return _summaryURL;
	}

	public String getTabs1() {
		if (Validator.isNotNull(_tabs1)) {
			return _tabs1;
		}

		_tabs1 = ParamUtil.getString(request, "tabs1", "summary");

		return _tabs1;
	}

	@Override
	public long getUserSegmentId() {
		if (_userSegmentId != null) {
			return _userSegmentId;
		}

		if (Objects.equals(getTabs1(), "reports")) {
			_userSegmentId = ParamUtil.getLong(request, "classPK");
		}
		else {
			_userSegmentId = ParamUtil.getLong(request, "userSegmentId");
		}

		return _userSegmentId;
	}

	public int getUsersNumber() throws PortalException {
		if (_usersNumber != null) {
			return _usersNumber;
		}

		if (_anonymousUserUserSegmentLocalService != null) {
			_usersNumber =
				_anonymousUserUserSegmentLocalService.
					getAnonymousUsersByUserSegmentIdCount(
						getUserSegmentId(), true);
		}
		else {
			_usersNumber = 0;
		}

		return _usersNumber;
	}

	public boolean isShowReports() {
		if (Objects.equals(getTabs1(), "reports")) {
			return true;
		}

		return false;
	}

	public boolean isShowSummary() {
		if (Objects.equals(getTabs1(), "summary")) {
			return true;
		}

		return false;
	}

	public boolean showSearch() {
		if (_showSearch != null) {
			return _showSearch;
		}

		_showSearch = ParamUtil.getBoolean(request, "showSearch");

		return _showSearch;
	}

	private Map<String, List<RuleInstance>> _getRuleInstanceMap() {
		if (_ruleInstanceMap != null) {
			return _ruleInstanceMap;
		}

		Map<String, List<RuleInstance>> ruleInstanceMap = new HashMap<>();

		List<RuleInstance> ruleInstances = getRuleInstances();

		for (RuleInstance ruleInstance : ruleInstances) {
			Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

			String ruleCategoryKey = rule.getRuleCategoryKey();

			List<RuleInstance> ruleInstanceList = new ArrayList<>();

			if (ruleInstanceMap.containsKey(ruleCategoryKey)) {
				ruleInstanceList = ruleInstanceMap.get(ruleCategoryKey);
			}

			ruleInstanceList.add(ruleInstance);

			ruleInstanceMap.put(ruleCategoryKey, ruleInstanceList);
		}

		_ruleInstanceMap = ruleInstanceMap;

		return _ruleInstanceMap;
	}

	private final AnonymousUserUserSegmentLocalService
		_anonymousUserUserSegmentLocalService;
	private Long _classPK;
	private String _description;
	private String _reportsURL;
	private List<RuleCategory> _ruleCategories;
	private final RuleCategoriesRegistry _ruleCategoriesRegistry;
	private Map<String, List<RuleInstance>> _ruleInstanceMap;
	private List<RuleInstance> _ruleInstances;
	private final RuleInstanceService _ruleInstanceService;
	private final RulesRegistry _rulesRegistry;
	private Boolean _showSearch;
	private String _summaryURL;
	private String _tabs1;
	private Long _userSegmentId;
	private Integer _usersNumber;

}