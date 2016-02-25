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

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.portlet.util.CampaignQueryRuleUtil;
import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=campaign-content-display-portlet",
		"com.liferay.portlet.display-category=category.ct",
		"com.liferay.portlet.header-portlet-css=/css/campaign_content_display/main.css",
		"com.liferay.portlet.header-portlet-css=/css/content_targeting/rules_panel.css",
		"com.liferay.portlet.header-portlet-css=/css/content_targeting/thumbnails_preview.css",
		"com.liferay.portlet.header-portlet-javascript=/js/content_targeting/thumbnails_preview.js",
		"com.liferay.portlet.icon=/icons/campaign_content_display.png",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=1",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Campaign Content Display" + PortletKeys.CT_CAMPAIGN_DISPLAY,
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.config-template=/campaign_content_display/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/campaign_content_display/view.jsp",
		"javax.portlet.name=", "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class CampaignContentDisplayPortlet extends ContentDisplayPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = renderRequest.getPreferences();

		TemplateHandler templateHandler =
			TemplateHandlerRegistryUtil.getTemplateHandler(
				AssetEntry.class.getName());

		renderRequest.setAttribute("templateHandler", templateHandler);

		renderRequest.setAttribute(
			"analyticsServletContext", _analyticsServletContext);

		try {
			renderRequest.setAttribute(
				"isNotConfigured", portletPreferences.getMap().isEmpty());

			List<QueryRule> campaignQueryRules =
				CampaignQueryRuleUtil.getCampaignQueryRules(
					portletPreferences, themeDisplay.getLocale(), false);

			long[] groupIds =
				ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
					themeDisplay.getScopeGroupId());

			List<Campaign> campaigns = _campaignLocalService.getCampaigns(
				groupIds);

			renderRequest.setAttribute("campaigns", campaigns);

			renderRequest.setAttribute(
				"showPreview", showPreview(themeDisplay));

			renderRequest.setAttribute(
				"assetRendererFactories",
				getSelectableAssetRendererFactories(
					themeDisplay.getCompanyId()));

			List<AssetEntry> results = new ArrayList<>();

			populatePortletDisplayTemplateViewContext(
				renderRequest, themeDisplay, results, campaignQueryRules);

			renderRequest.setAttribute(
				"campaignQueryRules", campaignQueryRules);

			QueryRule queryRule = CampaignQueryRuleUtil.match(
				getCampaignIds(campaigns), campaignQueryRules);

			renderRequest.setAttribute("queryRule", queryRule);

			renderRequest.setAttribute(
				"selectedIndex", campaignQueryRules.indexOf(queryRule));

			if ((queryRule != null) && (queryRule.getAssetEntry() != null)) {
				results.add(queryRule.getAssetEntry());

				queryRule.setAssetAttributes(renderRequest);
			}
			else {
				renderRequest.setAttribute(
					WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
			}
		}
		catch (Exception e) {
			_log.error("Error in rendering user segment display portlet", e);
		}

		super.render(renderRequest, renderResponse);
	}

	protected long[] getCampaignIds(List<Campaign> campaigns) {
		long[] campaignIds = new long[campaigns.size()];

		for (int i = 0; i < campaigns.size(); i++) {
			Campaign campaign = campaigns.get(i);

			campaignIds[i] = campaign.getCampaignId();
		}

		return campaignIds;
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

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.analytics.web)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		_analyticsServletContext = servletContext;
	}

	protected boolean showPreview(ThemeDisplay themeDisplay)
		throws PortalException {

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		if (portletDisplay.isShowConfigurationIcon()) {
			return true;
		}

		Group group = themeDisplay.getScopeGroup();
		Layout layout = themeDisplay.getLayout();

		if (!group.hasStagingGroup()) {
			return false;
		}

		group = group.getStagingGroup();

		layout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(
			layout.getUuid(), group.getGroupId(), layout.isPrivateLayout());

		return PortletPermissionUtil.contains(
			themeDisplay.getPermissionChecker(), layout.getPlid(),
			portletDisplay.getPortletName(), ActionKeys.CONFIGURATION);
	}

	protected void unsetCampaignLocalService() {
		_campaignLocalService = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CampaignContentDisplayPortlet.class);

	private ServletContext _analyticsServletContext;
	private CampaignLocalService _campaignLocalService;

}