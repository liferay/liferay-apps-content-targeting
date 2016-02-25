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
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.KeyValuePairComparator;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PredicateFilter;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
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
	property = {"javax.portlet.name=" + PortletKeys.CT_USERSEGMENT_LIST},
	service = ConfigurationAction.class
)
public class UserSegmentContentListConfigurationAction
	extends DefaultConfigurationAction {

	@Override
	public String getJspPath(HttpServletRequest request) {
		return "/user_segment_content_list/configuration.jsp";
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

		TemplateHandler templateHandler =
			TemplateHandlerRegistryUtil.getTemplateHandler(
				AssetEntry.class.getName());

		request.setAttribute("templateHandler", templateHandler);

		PortletPreferences portletPreferences = portletRequest.getPreferences();

		String displayStyle = GetterUtil.getString(
			portletPreferences.getValue("displayStyle", "abstracts"));
		long displayStyleGroupId = GetterUtil.getLong(
			portletPreferences.getValue("displayStyleGroupId", null),
			themeDisplay.getScopeGroupId());

		request.setAttribute("displayStyle", displayStyle);
		request.setAttribute("displayStyleGroupId", displayStyleGroupId);
		request.setAttribute(
			"displayStyles", ListUtil.fromString("full-content"));

		long[] availableClassNameIds = getAvailableClassNameIds(
			themeDisplay.getCompanyId());

		long[] classNameIds = getClassNameIds(
			portletPreferences, availableClassNameIds);

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
							themeDisplay.getLocale(), className.getValue())));
			}

			modelResources.add(
				ResourceActionsUtil.getModelResource(
					themeDisplay.getLocale(), className.getValue()));
		}

		typesRightList = ListUtil.sort(
			typesRightList, new KeyValuePairComparator(false, true));

		boolean anyAssetType = GetterUtil.getBoolean(
			portletPreferences.getValue("anyAssetType", null), true);

		request.setAttribute("anyAssetType", anyAssetType);
		request.setAttribute("availableClassNameIds", availableClassNameIds);
		request.setAttribute("classNameIds", classNameIds);
		request.setAttribute("modelResources", modelResources);
		request.setAttribute("typesLeftList", typesLeftList);
		request.setAttribute("typesRightList", typesRightList);

		super.include(portletConfig, request, response);
	}

	@Override
	public void processAction(
		PortletConfig portletConfig, ActionRequest actionRequest,
		ActionResponse actionResponse) throws Exception {

		String anyAssetType = ParamUtil.getString(
			actionRequest, "anyAssetType");
		String[] classNameIds = StringUtil.split(
			ParamUtil.getString(actionRequest, "classNameIds"));

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		portletPreferences.setValue(
			"anyAssetType", String.valueOf(anyAssetType));

		if (!ArrayUtil.isEmpty(classNameIds)) {
			portletPreferences.setValues("classNameIds", classNameIds);
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
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
	protected void updateMultiValuedKeys(ActionRequest actionRequest) {
	}

}