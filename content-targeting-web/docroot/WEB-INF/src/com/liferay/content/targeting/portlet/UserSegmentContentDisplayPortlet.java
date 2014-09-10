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

package com.liferay.content.targeting.portlet;

import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.content.targeting.portlet.util.UserSegmentQueryRule;
import com.liferay.content.targeting.portlet.util.UserSegmentQueryRuleUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRendererFactory;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentContentDisplayPortlet extends FreeMarkerDisplayPortlet {

	public void updatePreferences(
			ActionRequest request, ActionResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		long assetEntryIdDefault = ParamUtil.getLong(
			request, "assetEntryIdDefault");
		boolean contentDefaultValue = ParamUtil.getBoolean(
			request, "contentDefaultValue");

		if (!contentDefaultValue) {
			assetEntryIdDefault = 0;
		}

		int[] queryRulesIndexes = StringUtil.split(
			ParamUtil.getString(request, "queryLogicIndexes"), 0);

		if (ArrayUtil.isEmpty(queryRulesIndexes)) {
			return;
		}

		List<UserSegmentQueryRule> queryRules =
			new ArrayList<UserSegmentQueryRule>();

		for (int queryRulesIndex : queryRulesIndexes) {
			QueryRule queryRule =
				UserSegmentQueryRuleUtil.getQueryRule(
						request, queryRulesIndex, themeDisplay.getLocale());

			if (!queryRule.isValid()) {
				continue;
			}

			queryRules.add((UserSegmentQueryRule)queryRule);
		}

		PortletPreferences portletPreferences = request.getPreferences();

		int[] oldQueryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null));

		for (int queryRulesIndex : oldQueryRulesIndexes) {
			portletPreferences.setValue(
				"queryContains" + queryRulesIndex, StringPool.BLANK);
			portletPreferences.setValue(
				"queryAndOperator" + queryRulesIndex, StringPool.BLANK);
			portletPreferences.setValues(
				"userSegmentAssetCategoryIds" + queryRulesIndex, new String[0]);
			portletPreferences.setValue(
				"assetEntryId" + queryRulesIndex, StringPool.BLANK);
		}

		portletPreferences.setValue(
			"enableSocialBookmarks", String.valueOf(false));
		portletPreferences.setValue("showAssetTitle", String.valueOf(false));

		portletPreferences.setValue(
			"assetEntryIdDefault", String.valueOf(assetEntryIdDefault));
		portletPreferences.setValue(
			"contentDefaultValue", String.valueOf(contentDefaultValue));
		portletPreferences.setValues(
			"queryLogicIndexes", ArrayUtil.toStringArray(queryRulesIndexes));

		for (UserSegmentQueryRule queryRule : queryRules) {
			portletPreferences.setValue(
				"queryContains" + queryRule.getIndex(),
				String.valueOf(queryRule.isContains()));
			portletPreferences.setValue(
				"queryAndOperator" + queryRule.getIndex(),
				String.valueOf(queryRule.isAndOperator()));
			portletPreferences.setValues(
				"userSegmentAssetCategoryIds" + queryRule.getIndex(),
				ArrayUtil.toStringArray(
					queryRule.getUserSegmentAssetCategoryIds()));
			portletPreferences.setValue(
				"assetEntryId" + queryRule.getIndex(),
				String.valueOf(queryRule.getAssetEntryId()));
		}

		super.updatePreferences(request, response, portletPreferences);
	}

	protected List<AssetRendererFactory> getSelectableAssetRendererFactories(
		long companyId) {

		List<AssetRendererFactory> selectableAssetRendererFactories =
			new ArrayList<AssetRendererFactory>();

		List<AssetRendererFactory> assetRendererFactories =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactories(
					companyId);

		for (AssetRendererFactory rendererFactory : assetRendererFactories) {
			if (!rendererFactory.isSelectable()) {
				continue;
			}

			selectableAssetRendererFactories.add(rendererFactory);
		}

		return selectableAssetRendererFactories;
	}

	@Override
	protected void populateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		template.put(
			"redirect", ParamUtil.getString(portletRequest, "redirect"));
		template.put(
			"userSegmentContentDisplayPath",
			staticModels.get(UserSegmentContentDisplayPath.class.getName()));

		populateViewContext(
			path, portletRequest, portletResponse, template, staticModels);
	}

	protected void populateViewContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template,
			TemplateHashModel staticModels)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = portletRequest.getPreferences();

		populatePortletDisplayTemplateContext(
			template, portletPreferences, themeDisplay.getScopeGroupId(),
			"full-content");

		if (Validator.isNull(path) ||
			path.equals(UserSegmentContentDisplayPath.VIEW)) {

			template.put("showPreview", showPreview(themeDisplay));

			List<QueryRule> userSegmentQueryRules =
				UserSegmentQueryRuleUtil.getUserSegmentQueryRules(
					portletPreferences, themeDisplay.getLocale(), false);

			template.put("userSegmentQueryRules", userSegmentQueryRules);

			QueryRule queryRule = userSegmentQueryRules.get(0);

			long[] userSegmentIds = (long[])portletRequest.getAttribute(
				WebKeys.USER_SEGMENT_IDS);

			if (userSegmentIds != null) {
				long[] userSegmentAssetCategoryIds =
					ContentTargetingUtil.getAssetCategoryIds(
						themeDisplay.getSiteGroupIdOrLiveGroupId(),
						userSegmentIds);

				queryRule = UserSegmentQueryRuleUtil.match(
					userSegmentAssetCategoryIds, userSegmentQueryRules);
			}

			template.put("queryRule", queryRule);

			template.put(
				"selectedIndex", userSegmentQueryRules.indexOf(queryRule));

			List<AssetEntry> results = new ArrayList<AssetEntry>();

			if ((queryRule != null) && (queryRule.getAssetEntry() != null)) {
				results.add(queryRule.getAssetEntry());

				queryRule.setAssetAttributes(portletRequest);
			}
			else {
				portletRequest.setAttribute(
					WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
			}

			template.put("liferayWindowStatePopUp", LiferayWindowState.POP_UP);

			populatePortletDisplayTemplateViewContext(
				template, portletRequest, themeDisplay, results,
				userSegmentQueryRules);
		}
		else if (path.equals(UserSegmentContentDisplayPath.EDIT_QUERY_RULE) ||
				 path.equals(UserSegmentContentDisplayPath.CONFIGURATION)) {

			template.put(
				"assetRendererFactories",
				getSelectableAssetRendererFactories(
					themeDisplay.getCompanyId()));

			List<QueryRule> userSegmentQueryRules =
				UserSegmentQueryRuleUtil.getUserSegmentQueryRules(
					portletPreferences, themeDisplay.getLocale(), true);

			template.put("userSegmentQueryRules", userSegmentQueryRules);

			UserSegmentQueryRule userSegmentQueryRule =
				(UserSegmentQueryRule)portletRequest.getAttribute(
					"configuration.queryRule");

			if (userSegmentQueryRule == null) {
				userSegmentQueryRule =
					UserSegmentQueryRuleUtil.getNewQueryRule();
			}

			template.put("queryRule", userSegmentQueryRule);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

			long[] vocabularyGroupIds = new long[1];
			long[] vocabularyIds = new long[1];

			if (themeDisplay.getScopeGroupId() ==
					themeDisplay.getCompanyGroupId()) {

				vocabularyGroupIds[0] = themeDisplay.getCompanyGroupId();

				vocabularyIds[0] = UserSegmentUtil.getAssetVocabularyId(
					themeDisplay.getUserId(), serviceContext);
			}
			else {
				vocabularyGroupIds =
					ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
						themeDisplay.getSiteGroupId());
				vocabularyIds = UserSegmentUtil.getAssetVocabularyIds(
					vocabularyGroupIds);
			}

			template.put(
				"vocabularyGroupIds", StringUtil.merge(vocabularyGroupIds));
			template.put("vocabularyIds", StringUtil.merge(vocabularyIds));
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserSegmentContentDisplayPortlet.class);

}