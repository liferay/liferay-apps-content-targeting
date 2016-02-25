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

package com.liferay.content.targeting.rule.score.points;

import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.BehaviorRuleCategory;
import com.liferay.content.targeting.rule.score.points.model.ScorePoint;
import com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

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
public class ScorePointsRule extends BaseRule {

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
	public void deleteData(RuleInstance ruleInstance) throws PortalException {
		List<ScorePoint> scorePoints = _scorePointLocalService.getScorePoints(
			ruleInstance.getUserSegmentId());

		for (ScorePoint scorePoint : scorePoints) {
			_scorePointLocalService.deleteScorePoint(scorePoint);
		}
	}

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		String typeSettings = ruleInstance.getTypeSettings();

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

		long scorePoints = jsonObj.getLong("scorePoints");

		long anonymousUserScorePoints = _scorePointLocalService.getPoints(
			anonymousUser.getAnonymousUserId(),
			ruleInstance.getUserSegmentId());

		if (anonymousUserScorePoints >= scorePoints) {
			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-star";
	}

	@Override
	public String getRuleCategoryKey() {
		return BehaviorRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		String summary = StringPool.BLANK;

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			int scorePoints = jsonObj.getInt("scorePoints");

			String userSegmentName = ruleInstance.getUserSegmentName(locale);

			summary = LanguageUtil.format(
				locale, "users-with-more-than-x-score-points-of-x",
				new Object[] {scorePoints, userSegmentName});
		}
		catch (JSONException jsone) {
		}

		return summary;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		int scorePoints = GetterUtil.getInteger(values.get("scorePoints"));

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("scorePoints", scorePoints);

		return jsonObj.toString();
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		int scorePoints = 0;

		if (!values.isEmpty()) {
			scorePoints = GetterUtil.getInteger(values.get("scorePoints"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				scorePoints = jsonObj.getInt("scorePoints");
			}
			catch (JSONException jsone) {
			}
		}

		context.put("scorePoints", scorePoints);

		long groupId = (Long)context.get("scopeGroupId");

		boolean trackingContentEnabled = AnalyticsUtil.isAnalyticsPageEnabled(
			groupId);
		boolean trackingPageEnabled = AnalyticsUtil.isAnalyticsPageEnabled(
			groupId);

		context.put("trackingContentEnabled", trackingContentEnabled);
		context.put("trackingPageEnabled", trackingPageEnabled);

		if (!trackingContentEnabled || !trackingPageEnabled) {
			ContentTargetingContextUtil.populateContextAnalyticsSettingsURLs(
				context);
		}
	}

	@Reference(unbind = "-")
	protected void setScorePointLocalService(
		ScorePointLocalService scorePointLocalService) {

		_scorePointLocalService = scorePointLocalService;
	}

	private ScorePointLocalService _scorePointLocalService;

}