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

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.content.targeting.portlet.util.UserSegmentQueryRule;
import com.liferay.content.targeting.portlet.util.UserSegmentQueryRuleUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=" + PortletKeys.CT_USERSEGMENT_DISPLAY},
	service = ConfigurationAction.class
)
public class UserSegmentDisplayConfigurationAction
	extends DefaultConfigurationAction {

	@Override
	public String getJspPath(HttpServletRequest request) {
		return "/user_segment_content_display/configuration.jsp";
	}

	@Override
	public void include(
			PortletConfig portletConfig, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletRequest portletRequest = (PortletRequest)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_REQUEST);

		PortletPreferences portletPreferences = portletRequest.getPreferences();

		TemplateHandler templateHandler =
			TemplateHandlerRegistryUtil.getTemplateHandler(
				AssetEntry.class.getName());

		request.setAttribute("templateHandler", templateHandler);

		String displayStyle = GetterUtil.getString(
			portletPreferences.getValue("displayStyle", "full-content"));
		long displayStyleGroupId = GetterUtil.getLong(
			portletPreferences.getValue("displayStyleGroupId", null),
			themeDisplay.getScopeGroupId());

		request.setAttribute("displayStyle", displayStyle);
		request.setAttribute("displayStyleGroupId", displayStyleGroupId);
		request.setAttribute(
			"displayStyles", ListUtil.fromString("full-content"));

		int[] queryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null),
			new int[0]);

		boolean addEmptyRule = (queryRulesIndexes.length == 0);

		List<QueryRule> userSegmentQueryRules =
			UserSegmentQueryRuleUtil.getUserSegmentQueryRules(
				portletPreferences, themeDisplay.getLocale(), addEmptyRule);

		request.setAttribute("userSegmentQueryRules", userSegmentQueryRules);

		request.setAttribute(
			"assetRendererFactories",
			getSelectableAssetRendererFactories(themeDisplay.getCompanyId()));

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

		request.setAttribute(
			"vocabularyGroupIds", StringUtil.merge(vocabularyGroupIds));
		request.setAttribute("vocabularyIds", StringUtil.merge(vocabularyIds));

		super.include(portletConfig, request, response);
	}

	@Override
	public void processAction(
		PortletConfig portletConfig, ActionRequest actionRequest,
		ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long assetEntryIdDefault = ParamUtil.getLong(
			actionRequest, "assetEntryIdDefault");
		boolean contentDefaultValue = ParamUtil.getBoolean(
			actionRequest, "contentDefaultValue");

		if (!contentDefaultValue) {
			assetEntryIdDefault = 0;
		}

		int[] queryRulesIndexes = StringUtil.split(
			ParamUtil.getString(actionRequest, "queryLogicIndexes"), 0);

		if (ArrayUtil.isEmpty(queryRulesIndexes)) {
			return;
		}

		List<UserSegmentQueryRule> queryRules = new ArrayList<>();

		for (int queryRulesIndex : queryRulesIndexes) {
			QueryRule queryRule = UserSegmentQueryRuleUtil.getQueryRule(
				actionRequest, queryRulesIndex, themeDisplay.getLocale());

			if (!queryRule.isValid()) {
				continue;
			}

			queryRules.add((UserSegmentQueryRule)queryRule);
		}

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		int[] oldQueryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null));

		for (int queryRulesIndex : oldQueryRulesIndexes) {
			setPreference(
				actionRequest, "queryContains" + queryRulesIndex,
				StringPool.BLANK);
			setPreference(
				actionRequest, "queryAndOperator" + queryRulesIndex,
				StringPool.BLANK);
			setPreference(
				actionRequest, "userSegmentAssetCategoryIds" + queryRulesIndex,
				new String[0]);
			setPreference(
				actionRequest, "assetEntryId" + queryRulesIndex,
				StringPool.BLANK);
		}

		setPreference(
			actionRequest, "enableSocialBookmarks", String.valueOf(false));
		portletPreferences.setValue("showAssetTitle", String.valueOf(false));

		setPreference(
			actionRequest, "assetEntryIdDefault",
			String.valueOf(assetEntryIdDefault));
		setPreference(
			actionRequest, "contentDefaultValue",
			String.valueOf(contentDefaultValue));
		setPreference(
			actionRequest, "queryLogicIndexes",
			ArrayUtil.toStringArray(queryRulesIndexes));

		for (UserSegmentQueryRule queryRule : queryRules) {
			setPreference(
				actionRequest, "queryContains" + queryRule.getIndex(),
				String.valueOf(queryRule.isContains()));
			setPreference(
				actionRequest, "queryAndOperator" + queryRule.getIndex(),
				String.valueOf(queryRule.isAndOperator()));
			setPreference(
				actionRequest,
				"userSegmentAssetCategoryIds" + queryRule.getIndex(),
				ArrayUtil.toStringArray(
					queryRule.getUserSegmentAssetCategoryIds()));
			setPreference(
				actionRequest, "assetEntryId" + queryRule.getIndex(),
				String.valueOf(queryRule.getAssetEntryId()));
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	protected List<AssetRendererFactory> getSelectableAssetRendererFactories(
		long companyId) {

		List<AssetRendererFactory> selectableAssetRendererFactories =
			new ArrayList<>();

		List<AssetRendererFactory<?>> assetRendererFactories =
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
	protected void updateMultiValuedKeys(ActionRequest actionRequest) {
	}

}