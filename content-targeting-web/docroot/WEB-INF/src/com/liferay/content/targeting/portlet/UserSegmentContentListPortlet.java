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

import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.KeyValuePairComparator;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PredicateFilter;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentContentListPortlet extends FreeMarkerDisplayPortlet {

	public void updatePreferences(
			ActionRequest request, ActionResponse response)
		throws Exception {

		String anyAssetType = ParamUtil.getString(
			request, "anyAssetType");
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
	protected String getPath(PortletRequest portletRequest) {
		String strutsPath = ParamUtil.getString(
			portletRequest, "struts_action");

		if (strutsPath.equals("/asset_publisher/view_content")) {
			return UserSegmentContentListPath.VIEW_CONTENT;
		}

		return super.getPath(portletRequest);
	}

	protected void populateContext(
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

			List<AssetEntry> assetEntries = new ArrayList<AssetEntry>();

			if (ArrayUtil.isNotEmpty(userSegmentIds)) {
				AssetEntryQuery entryQuery = new AssetEntryQuery();

				entryQuery.setAnyCategoryIds(
					ContentTargetingUtil.getAssetCategoryIds(
						themeDisplay.getScopeGroupId(), userSegmentIds));
				entryQuery.setClassNameIds(classNameIds);

				assetEntries = AssetEntryServiceUtil.getEntries(entryQuery);

				portletRequest.setAttribute(
					"view.jsp-results", new ArrayList());
				portletRequest.setAttribute(
					"view.jsp-assetEntryIndex", new Integer(0));
				portletRequest.setAttribute("view.jsp-show", new Boolean(true));
				portletRequest.setAttribute(
					"view.jsp-print", new Boolean(false));
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
				"view.jsp-assetEntryIndex", new Integer(0));
			portletRequest.setAttribute("view.jsp-assetEntry", assetEntry);
			portletRequest.setAttribute(
				"view.jsp-assetRendererFactory", assetRendererFactory);
			portletRequest.setAttribute(
				"view.jsp-assetRenderer", assetRenderer);
			portletRequest.setAttribute(
				"view.jsp-title",
				assetEntry.getTitle(themeDisplay.getLocale()));
			portletRequest.setAttribute("view.jsp-show", new Boolean(false));
			portletRequest.setAttribute("view.jsp-print", new Boolean(false));
		}
		else if (path.equals(UserSegmentContentListPath.CONFIGURATION)) {
			List<KeyValuePair> typesLeftList = new ArrayList<KeyValuePair>();

			for (long classNameId : classNameIds) {
				String className = PortalUtil.getClassName(classNameId);

				typesLeftList.add(
					new KeyValuePair(
						String.valueOf(classNameId),
						ResourceActionsUtil.getModelResource(
							themeDisplay.getLocale(), className)));
			}

			List<KeyValuePair> typesRightList = new ArrayList<KeyValuePair>();

			Arrays.sort(classNameIds);

			List<String> modelResources = new ArrayList<String>();

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