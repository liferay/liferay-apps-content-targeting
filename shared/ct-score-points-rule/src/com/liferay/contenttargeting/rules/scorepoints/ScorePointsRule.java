/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.rules.scorepoints;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;

import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, provide = Rule.class)
public class ScorePointsRule extends BaseRule {

	@Activate
	public void activate() {
	}

	@Deactivate
	public void deActivate() {
	}

	@Override
	public boolean evaluate(RuleInstance ruleInstance, CTUser ctUser)
		throws Exception {

		if (ruleInstance == null) {
			return false;
		}

		String typeSettings = ruleInstance.getTypeSettings();

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

		int scorePoints = jsonObj.getInt("scorePoints");

		String ctUserTypeSettings = ctUser.getTypeSettings();

		JSONObject ctUserJsonObj = JSONFactoryUtil.createJSONObject(
			ctUserTypeSettings);

		int ctUserScorePoints = ctUserJsonObj.getInt("scorePoints");

		if (ctUserScorePoints >= scorePoints) {
			return true;
		}

		return false;
	}

	@Override
	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			if (ruleInstance != null) {
				String typeSettings = ruleInstance.getTypeSettings();

				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				context.put("scorePoints", jsonObj.getInt("scorePoints"));
			}
			else {
				context.put("scorePoints", 0);
			}

			content = parseTemplate(
				ScorePointsRule.class, _FORM_TEMPLATE_PATH, context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing rule form template " +
					_FORM_TEMPLATE_PATH,
				e);
		}

		return content;
	}

	@Override
	public String getIcon() {
		return "icon-star";
	}

	@Override
	public String getName(Locale locale) {
		return LanguageUtil.get(locale, "score-points");
	}

	@Override
	public String getRuleKey() {
		return "scorePoints";
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		StringBundler sb = new StringBundler(4);

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			int scorePoints = jsonObj.getInt("scorePoints");

			sb.append("Users with ");
			sb.append(scorePoints);
			sb.append(" score points of ");
			sb.append(ruleInstance.getUserSegmentName(locale));
		}
		catch (JSONException jse) {
		}

		return sb.toString();
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response) {

		int scorePoints = ParamUtil.getInteger(request, "scorePoints");

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("scorePoints", scorePoints);

		return jsonObj.toString();
	}

	private static Log _log = LogFactoryUtil.getLog(ScorePointsRule.class);

}