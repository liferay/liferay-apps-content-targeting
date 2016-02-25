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
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PredicateFilter;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=user-segment-content-list-portlet",
		"com.liferay.portlet.display-category=category.ct",
		"com.liferay.portlet.header-portlet-css=/css/content_targeting/warning_restart.css",
		"com.liferay.portlet.header-portlet-css=/css/user_segment_content_list/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/content_targeting/thumbnails_preview.js",
		"com.liferay.portlet.icon=/icons/user_segment_content_list.png",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=1",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=User Segment Content List" + PortletKeys.CT_USERSEGMENT_LIST,
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.config-template=/user_segment_content_list/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/user_segment_content_list/view.jsp",
		"javax.portlet.name=", "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class UserSegmentContentListPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = renderRequest.getPreferences();

		long[] availableClassNameIds = getAvailableClassNameIds(
			themeDisplay.getCompanyId());

		long[] classNameIds = getClassNameIds(
			portletPreferences, availableClassNameIds);

		TemplateHandler templateHandler =
			TemplateHandlerRegistryUtil.getTemplateHandler(
				AssetEntry.class.getName());

		renderRequest.setAttribute("templateHandler", templateHandler);

		long[] userSegmentIds = (long[])renderRequest.getAttribute(
			WebKeys.USER_SEGMENT_IDS);

		List<AssetEntry> assetEntries = new ArrayList<>();

		try {
			if (ArrayUtil.isNotEmpty(userSegmentIds)) {
				AssetEntryQuery entryQuery = new AssetEntryQuery();

				entryQuery.setAnyCategoryIds(
					ContentTargetingUtil.getAssetCategoryIds(
						themeDisplay.getScopeGroupId(), userSegmentIds));
				entryQuery.setClassNameIds(classNameIds);
				entryQuery.setEnablePermissions(true);

				assetEntries = AssetEntryServiceUtil.getEntries(entryQuery);

				renderRequest.setAttribute("view.jsp-results", new ArrayList());
				renderRequest.setAttribute(
					"view.jsp-assetEntryIndex", Integer.valueOf(0));
				renderRequest.setAttribute(
					"view.jsp-show", Boolean.valueOf(true));
				renderRequest.setAttribute(
					"view.jsp-print", Boolean.valueOf(false));
			}

			renderRequest.setAttribute("assetEntries", assetEntries);

			if (assetEntries.isEmpty()) {
				renderRequest.setAttribute(
					WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
			}

			long assetEntryId = ParamUtil.getLong(
				renderRequest, "assetEntryId");

			if (assetEntryId > 0) {
				AssetEntry assetEntry =
					AssetEntryLocalServiceUtil.fetchAssetEntry(assetEntryId);

				AssetRendererFactory assetRendererFactory =
					AssetRendererFactoryRegistryUtil.
						getAssetRendererFactoryByClassName(
							assetEntry.getClassName());

				AssetRenderer assetRenderer =
					assetRendererFactory.getAssetRenderer(
						assetEntry.getClassPK());

				renderRequest.setAttribute("view.jsp-results", new ArrayList());
				renderRequest.setAttribute(
					"view.jsp-assetEntryIndex", Integer.valueOf(0));
				renderRequest.setAttribute("view.jsp-assetEntry", assetEntry);
				renderRequest.setAttribute(
					"view.jsp-assetRendererFactory", assetRendererFactory);
				renderRequest.setAttribute(
					"view.jsp-assetRenderer", assetRenderer);
				renderRequest.setAttribute(
					"view.jsp-title",
					assetEntry.getTitle(themeDisplay.getLocale()));
				renderRequest.setAttribute(
					"view.jsp-show", Boolean.valueOf(false));
				renderRequest.setAttribute(
					"view.jsp-print", Boolean.valueOf(false));
			}
		}
		catch (Exception e) {
		}

		super.render(renderRequest, renderResponse);
	}

	protected long[] getAvailableClassNameIds(long companyId) {
		long[] availableClassNameIds =
			AssetRendererFactoryRegistryUtil.getClassNameIds(companyId);

		availableClassNameIds = ArrayUtil.filter(
			availableClassNameIds,
			new PredicateFilter<Long>() {

				public boolean filter(Long classNameId) {
					AssetRendererFactory assetRendererFactory =
						AssetRendererFactoryRegistryUtil.
							getAssetRendererFactoryByClassName(
								PortalUtil.getClassName(classNameId));

					return assetRendererFactory.isSelectable();
				}

			});

		return availableClassNameIds;
	}

	protected long[] getClassNameIds(
		PortletPreferences portletPreferences, long[] availableClassNameIds) {

		boolean anyAssetType = GetterUtil.getBoolean(
			portletPreferences.getValue(
				"anyAssetType", Boolean.TRUE.toString()));

		if (anyAssetType) {
			return availableClassNameIds;
		}

		long defaultClassNameId = GetterUtil.getLong(
			portletPreferences.getValue("anyAssetType", null));

		if (defaultClassNameId > 0) {
			return new long[] {defaultClassNameId};
		}

		long[] classNameIds = GetterUtil.getLongValues(
			portletPreferences.getValues("classNameIds", null));

		if (ArrayUtil.isNotEmpty(classNameIds)) {
			return classNameIds;
		}
		else {
			return availableClassNameIds;
		}
	}

	@Override
	protected String getPath(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		String strutsPath = ParamUtil.getString(
			portletRequest, "struts_action");

		if (strutsPath.equals("/asset_publisher/view_content")) {
			return UserSegmentContentListPath.VIEW_CONTENT;
		}

		return super.getPath(portletRequest, portletResponse);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserSegmentContentListPortlet.class);

}