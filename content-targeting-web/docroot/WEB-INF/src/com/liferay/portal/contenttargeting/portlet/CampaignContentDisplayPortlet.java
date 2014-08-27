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

package com.liferay.portal.contenttargeting.portlet;

import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.contenttargeting.model.Campaign;
import com.liferay.portal.contenttargeting.portlet.util.AssetQueryRule;
import com.liferay.portal.contenttargeting.portlet.util.CampaignQueryRule;
import com.liferay.portal.contenttargeting.portlet.util.CampaignQueryRuleUtil;
import com.liferay.portal.contenttargeting.portlet.util.UserSegmentContentDisplayUtil;
import com.liferay.portal.contenttargeting.service.CampaignLocalService;
import com.liferay.portal.contenttargeting.service.CampaignService;
import com.liferay.portal.contenttargeting.util.ContentTargetingUtil;
import com.liferay.portal.contenttargeting.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.UnavailableException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 */
public class CampaignContentDisplayPortlet extends FreeMarkerDisplayPortlet {

	@Override
	public void init() throws PortletException {
		super.init();

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, bundle.getBundleContext());
		_campaignService = ServiceTrackerUtil.getService(
			CampaignService.class, bundle.getBundleContext());
	}

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

		List<CampaignQueryRule> queryRules = new ArrayList<CampaignQueryRule>();

		for (int queryRulesIndex : queryRulesIndexes) {
			CampaignQueryRule queryRule = CampaignQueryRuleUtil.getQueryRule(
				request, queryRulesIndex, themeDisplay.getLocale());

			if (!queryRule.isValid()) {
				break;
			}

			queryRules.add(queryRule);
		}

		PortletPreferences portletPreferences = request.getPreferences();

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

		super.updatePreferences(request, response, portletPreferences);
	}

	protected List<AssetQueryRule> getCampaignQueryRules(
			PortletPreferences portletPreferences, long assetEntryIdDefault,
			Locale locale)
		throws PortalException, SystemException {

		List<AssetQueryRule> campaignQueryRules =
			new ArrayList<AssetQueryRule>();

		int[] queryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null),
			new int[0]);

		for (int queryRulesIndex : queryRulesIndexes) {
			CampaignQueryRule campaignQueryRule =
				CampaignQueryRuleUtil.getQueryRule(
					portletPreferences, queryRulesIndex, locale);

			if (campaignQueryRule.getAssetEntry() != null) {
				campaignQueryRules.add(campaignQueryRule);
			}
		}

		CampaignQueryRule campaignQueryRule = new CampaignQueryRule(
			assetEntryIdDefault, 0, -1, locale);

		campaignQueryRules.add(campaignQueryRule);

		return campaignQueryRules;
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
			"campaignContentDisplayPath",
			staticModels.get(CampaignContentDisplayPath.class.getName()));

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

		long assetEntryIdDefault = GetterUtil.getLong(
			portletPreferences.getValue("assetEntryIdDefault", null));
		boolean contentDefaultValue = GetterUtil.getBoolean(
			portletPreferences.getValue("contentDefaultValue", null));

		populatePortletDisplayTemplateContext(
			template, portletPreferences, themeDisplay.getScopeGroupId(),
			"full-content");

		if (Validator.isNull(path) ||
			path.equals(CampaignContentDisplayPath.VIEW)) {

			template.put("contentDefaultValue", contentDefaultValue);

			CampaignQueryRule queryRule = null;

			long[] userSegmentIds = (long[])portletRequest.getAttribute(
				WebKeys.USER_SEGMENT_IDS);

			long groupId = themeDisplay.getScopeGroupId();
			long campaignClassPK = 0;

			if (userSegmentIds != null) {
				long[] groupIds =
					ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
						themeDisplay.getSiteGroupId());

				Campaign campaign =
					_campaignLocalService.fetchCurrentMaxPriorityCampaign(
						groupIds, userSegmentIds);

				if (campaign != null) {
					queryRule = CampaignQueryRuleUtil.match(
						campaign.getCampaignId(), portletPreferences,
						themeDisplay.getLocale());

					campaignClassPK = campaign.getCampaignId();
					groupId = campaign.getGroupId();
				}
			}

			template.put("campaignClassName", Campaign.class.getName());
			template.put("campaignClassPK", campaignClassPK);
			template.put("groupId", groupId);

			boolean isMatchingRule = false;

			List<AssetEntry> results = new ArrayList<AssetEntry>();

			if ((queryRule != null) ||
				(contentDefaultValue && (assetEntryIdDefault > 0))) {

				isMatchingRule = true;

				long assetEntryId = assetEntryIdDefault;

				if (queryRule != null) {
					assetEntryId = queryRule.getAssetEntryId();
				}

				AssetEntry assetEntry =
					AssetEntryLocalServiceUtil.fetchAssetEntry(assetEntryId);

				queryRule.setAssetAttributes(portletRequest);

				template.put("assetEntryClassName", assetEntry.getClassName());
				template.put("assetEntryClassPK", assetEntry.getClassPK());

				results.add(assetEntry);
			}
			else {
				portletRequest.setAttribute(
					WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
			}

			template.put("isMatchingRule", isMatchingRule);
			template.put("liferayWindowStatePopUp", LiferayWindowState.POP_UP);

			List<AssetQueryRule> campaignQueryRules =
				getCampaignQueryRules(
					portletPreferences, assetEntryIdDefault,
					themeDisplay.getLocale());

			populatePortletDisplayTemplateViewContext(
				template, portletRequest, themeDisplay, results,
				campaignQueryRules);

			template.put("campaignQueryRules", campaignQueryRules);

			int selectedIndex = campaignQueryRules.size() - 1;

			if (queryRule != null) {
				for (int i = 0; i < campaignQueryRules.size(); i++) {
					AssetQueryRule campaignQueryRule = campaignQueryRules.get(
						i);

					if (campaignQueryRule.getIndex() ==
							queryRule.getIndex()) {

						selectedIndex = i;

						break;
					}
				}
			}

			template.put("selectedIndex", selectedIndex);
		}
		else if (path.equals(CampaignContentDisplayPath.EDIT_QUERY_RULE) ||
				 path.equals(CampaignContentDisplayPath.CONFIGURATION)) {

			template.put(
				"assetRendererFactories",
				getSelectableAssetRendererFactories(
					themeDisplay.getCompanyId()));

			String assetImageDefault = StringPool.BLANK;
			String assetTitleDefault = StringPool.BLANK;
			String assetTypeDefault = StringPool.BLANK;

			if (assetEntryIdDefault > 0) {
				AssetEntry assetEntry =
					AssetEntryLocalServiceUtil.fetchAssetEntry(
						assetEntryIdDefault);

				AssetRendererFactory assetRendererFactory =
					AssetRendererFactoryRegistryUtil.
						getAssetRendererFactoryByClassName(
							assetEntry.getClassName());

				AssetRenderer assetRenderer =
					assetRendererFactory.getAssetRenderer(
						assetEntry.getClassPK());

				assetImageDefault = assetRenderer.getThumbnailPath(
					portletRequest);
				assetTitleDefault = assetRenderer.getTitle(
					themeDisplay.getLocale());
				assetTypeDefault = assetRendererFactory.getTypeName(
					themeDisplay.getLocale(), true);
			}

			List<Campaign> campaigns = _campaignService.getCampaigns(
				themeDisplay.getScopeGroupId());

			template.put("campaigns", campaigns);

			template.put("assetEntryIdDefault", assetEntryIdDefault);
			template.put("assetImageDefault", assetImageDefault);
			template.put("assetTitleDefault", assetTitleDefault);
			template.put("assetTypeDefault", assetTypeDefault);
			template.put("contentDefaultValue", contentDefaultValue);
			template.put(
				"liferayWindowStateExclusive", LiferayWindowState.EXCLUSIVE);
			template.put("portletPreferences", portletPreferences);

			int[] queryRulesIndexes = GetterUtil.getIntegerValues(
				portletPreferences.getValues("queryLogicIndexes", null),
				new int[0]);

			template.put("queryLogicIndexes", queryRulesIndexes);
			template.put(
				"campaignQueryRuleUtilClass",
				staticModels.get(CampaignQueryRuleUtil.class.getName()));
			template.put(
				"userSegmentContentDisplayUtilClass",
				staticModels.get(
					UserSegmentContentDisplayUtil.class.getName()));
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CampaignContentDisplayPortlet.class);

	private CampaignLocalService _campaignLocalService;
	private CampaignService _campaignService;

}