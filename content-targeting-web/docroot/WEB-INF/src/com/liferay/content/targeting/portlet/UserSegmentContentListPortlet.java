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
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.KeyValuePairComparator;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PredicateFilter;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.service.ClassNameLocalServiceUtil;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

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
		"javax.portlet.init-param.config-template=/html/user_segment_content_list/configuration.ftl",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/user_segment_content_list/view.ftl",
		"javax.portlet.name=", "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = {UserSegmentContentListPortlet.class, Portlet.class}
)
public class UserSegmentContentListPortlet extends CTFreeMarkerDisplayPortlet {

	public void updatePreferences(
			ActionRequest request, ActionResponse response)
		throws Exception {

		String anyAssetType = ParamUtil.getString(request, "anyAssetType");
		String[] classNameIds = StringUtil.split(
			ParamUtil.getString(request, "classNameIds"));

		PortletPreferences portletPreferences = request.getPreferences();

		portletPreferences.setValue(
			"anyAssetType", String.valueOf(anyAssetType));

		if (!ArrayUtil.isEmpty(classNameIds)) {
			portletPreferences.setValues("classNameIds", classNameIds);
		}

		super.updatePreferences(request, response, portletPreferences);
	}

	@Override
	protected void doPopulateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		template.put(
			"redirect", ParamUtil.getString(portletRequest, "redirect"));

		populateViewContext(
			path, portletRequest, portletResponse, template, staticModels);
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

	protected void populateViewContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template,
			TemplateHashModel staticModels)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = portletRequest.getPreferences();

		long[] availableClassNameIds = getAvailableClassNameIds(
			themeDisplay.getCompanyId());

		long[] classNameIds = getClassNameIds(
			portletPreferences, availableClassNameIds);

		populatePortletDisplayTemplateContext(
			template, portletPreferences, themeDisplay.getScopeGroupId(),
			"abstracts");

		if (Validator.isNull(path) ||
			path.equals(UserSegmentContentListPath.VIEW)) {

			template.put("liferayWindowStatePopUp", LiferayWindowState.POP_UP);

			long[] userSegmentIds = (long[])portletRequest.getAttribute(
				WebKeys.USER_SEGMENT_IDS);

			List<AssetEntry> assetEntries = new ArrayList<>();

			if (ArrayUtil.isNotEmpty(userSegmentIds)) {
				AssetEntryQuery entryQuery = new AssetEntryQuery();

				entryQuery.setAnyCategoryIds(
					ContentTargetingUtil.getAssetCategoryIds(
						themeDisplay.getScopeGroupId(), userSegmentIds));
				entryQuery.setClassNameIds(classNameIds);
				entryQuery.setEnablePermissions(true);

				assetEntries = AssetEntryServiceUtil.getEntries(entryQuery);

				portletRequest.setAttribute(
					"view.jsp-results", new ArrayList());
				portletRequest.setAttribute(
					"view.jsp-assetEntryIndex", Integer.valueOf(0));
				portletRequest.setAttribute(
					"view.jsp-show", Boolean.valueOf(true));
				portletRequest.setAttribute(
					"view.jsp-print", Boolean.valueOf(false));
			}

			template.put("assetEntries", assetEntries);
			template.put(
				"assetRendererFactoryRegistryUtilClass",
				staticModels.get(
					AssetRendererFactoryRegistryUtil.class.getName()));

			if (assetEntries.isEmpty()) {
				portletRequest.setAttribute(
					WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
			}

			populatePortletDisplayTemplateViewContext(
				template, portletRequest, themeDisplay, assetEntries, null);
		}
		else if (path.equals(UserSegmentContentListPath.VIEW_CONTENT)) {
			long assetEntryId = ParamUtil.getLong(
				portletRequest, "assetEntryId");

			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchAssetEntry(
				assetEntryId);

			AssetRendererFactory assetRendererFactory =
				AssetRendererFactoryRegistryUtil.
					getAssetRendererFactoryByClassName(
						assetEntry.getClassName());

			AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(
				assetEntry.getClassPK());

			portletRequest.setAttribute("view.jsp-results", new ArrayList());
			portletRequest.setAttribute(
				"view.jsp-assetEntryIndex", Integer.valueOf(0));
			portletRequest.setAttribute("view.jsp-assetEntry", assetEntry);
			portletRequest.setAttribute(
				"view.jsp-assetRendererFactory", assetRendererFactory);
			portletRequest.setAttribute(
				"view.jsp-assetRenderer", assetRenderer);
			portletRequest.setAttribute(
				"view.jsp-title",
				assetEntry.getTitle(themeDisplay.getLocale()));
			portletRequest.setAttribute(
				"view.jsp-show", Boolean.valueOf(false));
			portletRequest.setAttribute(
				"view.jsp-print", Boolean.valueOf(false));
		}
		else if (path.equals(UserSegmentContentListPath.CONFIGURATION)) {
			List<KeyValuePair> typesLeftList = new ArrayList<>();

			for (long classNameId : classNameIds) {
				String className = PortalUtil.getClassName(classNameId);

				typesLeftList.add(
					new KeyValuePair(
						String.valueOf(classNameId),
						ResourceActionsUtil.getModelResource(
							themeDisplay.getLocale(), className)));
			}

			List<KeyValuePair> typesRightList = new ArrayList<>();

			Arrays.sort(classNameIds);

			List<String> modelResources = new ArrayList<>();

			for (long classNameId : availableClassNameIds) {
				ClassName className = ClassNameLocalServiceUtil.getClassName(
					classNameId);

				if (Arrays.binarySearch(classNameIds, classNameId) < 0) {
					typesRightList.add(
						new KeyValuePair(
							String.valueOf(classNameId),
							ResourceActionsUtil.getModelResource(
								themeDisplay.getLocale(),
								className.getValue())));
				}

				modelResources.add(
					ResourceActionsUtil.getModelResource(
						themeDisplay.getLocale(), className.getValue()));
			}

			typesRightList = ListUtil.sort(
				typesRightList, new KeyValuePairComparator(false, true));

			boolean anyAssetType = GetterUtil.getBoolean(
				portletPreferences.getValue("anyAssetType", null), true);

			template.put("anyAssetType", anyAssetType);
			template.put("availableClassNameIds", availableClassNameIds);
			template.put("classNameIds", classNameIds);
			template.put("modelResources", modelResources);
			template.put("typesLeftList", typesLeftList);
			template.put("typesRightList", typesRightList);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserSegmentContentListPortlet.class);

}