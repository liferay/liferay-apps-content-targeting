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
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.portlet.util.CampaignQueryRule;
import com.liferay.content.targeting.portlet.util.CampaignQueryRuleUtil;
import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.CampaignService;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
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
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=" + PortletKeys.CT_CAMPAIGN_DISPLAY},
	service = ConfigurationAction.class
)
public class CampaignDisplayConfigurationAction
	extends DefaultConfigurationAction {

	@Override
	public String getJspPath(HttpServletRequest request) {
		return "/campaign_content_display/configuration.jsp";
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

		List<QueryRule> campaignQueryRules =
			CampaignQueryRuleUtil.getCampaignQueryRules(
				portletPreferences, themeDisplay.getLocale(), addEmptyRule);

		request.setAttribute("campaignQueryRules", campaignQueryRules);

		CampaignQueryRule campaignQueryRule =
			(CampaignQueryRule)portletRequest.getAttribute(
				"configuration.queryRule");

		if (campaignQueryRule == null) {
			campaignQueryRule = new CampaignQueryRule();
		}

		request.setAttribute("queryRule", campaignQueryRule);

		request.setAttribute(
			"assetRendererFactories",
			getSelectableAssetRendererFactories(themeDisplay.getCompanyId()));

		long[] groupIds = ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
			themeDisplay.getScopeGroupId());

		List<Campaign> campaigns = _campaignLocalService.getCampaigns(groupIds);

		request.setAttribute("campaigns", campaigns);

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

		List<CampaignQueryRule> queryRules = new ArrayList<>();

		for (int queryRulesIndex : queryRulesIndexes) {
			QueryRule queryRule = CampaignQueryRuleUtil.getQueryRule(
				actionRequest, queryRulesIndex, themeDisplay.getLocale());

			if (!queryRule.isValid()) {
				continue;
			}

			queryRules.add((CampaignQueryRule)queryRule);
		}

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		int[] oldQueryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null));

		for (int queryRulesIndex : oldQueryRulesIndexes) {
			portletPreferences.setValue(
				"campaignId" + queryRulesIndex, StringPool.BLANK);
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

		for (CampaignQueryRule queryRule : queryRules) {
			portletPreferences.setValue(
				"campaignId" + queryRule.getIndex(),
				String.valueOf(queryRule.getCampaignId()));
			portletPreferences.setValue(
				"assetEntryId" + queryRule.getIndex(),
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

	@Reference(unbind = "unsetCampaignLocalService")
	protected void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {

		_campaignLocalService = campaignLocalService;
	}

	@Reference(unbind = "unsetCampaignService")
	protected void setCampaignService(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	protected void unsetCampaignLocalService() {
		_campaignLocalService = null;
	}

	protected void unsetCampaignService() {
		_campaignService = null;
	}

	@Override
	protected void updateMultiValuedKeys(ActionRequest actionRequest) {
	}

	private CampaignLocalService _campaignLocalService;
	private CampaignService _campaignService;

}