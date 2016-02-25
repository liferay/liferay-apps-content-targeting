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

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.service.permission.ContentTargetingPermission;
import com.liferay.content.targeting.service.permission.UserSegmentPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.CampaignConstants;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.permission.UserPermissionUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Pavel Savinov
 */
public abstract class BaseMVCRenderCommand implements MVCRenderCommand {

	public abstract String doRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception;

	public void populateFreemarkerContext(
			Map<String, Object> context, PortletRequest portletRequest,
			PortletResponse portletResponse)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		request.setAttribute(
			WebKeys.RESOURCE_BUNDLE_LOADER, getResourceBundleLoader(request));

		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			portletResponse);

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Group scopeGroup = themeDisplay.getScopeGroup();

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		context.put("actionKeys", staticModels.get(ActionKeys.class.getName()));
		context.put("campaignClass", Campaign.class);
		context.put(
			"campaignConstants",
			staticModels.get(CampaignConstants.class.getName()));
		context.put(
			"campaignPermission",
			staticModels.get(CampaignPermission.class.getName()));
		context.put("company", themeDisplay.getCompany());
		context.put(
			"contentTargetingMVCCommand",
			staticModels.get(ContentTargetingMVCCommand.class.getName()));
		context.put(
			"contentTargetingPath",
			staticModels.get(ContentTargetingPath.class.getName()));
		context.put(
			"contentTargetingPermission",
			staticModels.get(ContentTargetingPermission.class.getName()));
		context.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		context.put("liferayWindowStatePopUp", LiferayWindowState.POP_UP);
		context.put(
			"portletContext",
			portletRequest.getPortletSession().getPortletContext());
		context.put("reportInstanceClass", ReportInstance.class);
		context.put("request", request);
		context.put("response", response);
		context.put("scopeGroup", scopeGroup);
		context.put("scopeGroupId", scopeGroup.getGroupId());
		context.put("tacticClass", Tactic.class);
		context.put("themeDisplay", themeDisplay);
		context.put(
			"userInfo", portletRequest.getAttribute(PortletRequest.USER_INFO));
		context.put("userSegmentClass", UserSegment.class);
		context.put(
			"userSegmentPermission",
			staticModels.get(UserSegmentPermission.class.getName()));
		context.put(
			"userPermissionUtil",
			staticModels.get(UserPermissionUtil.class.getName()));
	}

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		try {
			return doRender(renderRequest, renderResponse);
		}
		catch (Exception e) {
			SessionErrors.add(renderRequest, e.getClass());

			return ContentTargetingPath.ERROR;
		}
	}

	protected Map<String, Object> cloneRequestContext(
		PortletRequest renderRequest, PortletResponse portletResponse) {

		Map<String, Object> context = new HashMap<>();

		Enumeration<String> attributeNames = renderRequest.getAttributeNames();

		while (attributeNames.hasMoreElements()) {
			String attributeName = attributeNames.nextElement();
			Object attributeValue = renderRequest.getAttribute(attributeName);

			context.put(attributeName, attributeValue);
		}

		try {
			populateFreemarkerContext(context, renderRequest, portletResponse);
		}
		catch (Exception e) {
			_log.error("Unable to populate Freemarker context", e);
		}

		return context;
	}

	protected Map<String, String> getJSONValues(
		JSONArray data, String namespace, String id) {

		Map<String, String> values = new HashMap<>(data.length());

		for (int i = 0; i < data.length(); i++) {
			JSONObject jsonObject = data.getJSONObject(i);

			String name = jsonObject.getString("name");

			name = StringUtil.replace(
				name, new String[] {namespace, id},
				new String[] {StringPool.BLANK, StringPool.BLANK});

			values.put(name, jsonObject.getString("value"));
		}

		return values;
	}

	protected ResourceBundleLoader getResourceBundleLoader(
		HttpServletRequest request) {

		ResourceBundleLoader resourceBundleLoader =
			(ResourceBundleLoader)request.getAttribute(
				WebKeys.RESOURCE_BUNDLE_LOADER);

		if (resourceBundleLoader != null) {
			return resourceBundleLoader;
		}

		return new AggregateResourceBundleLoader(
			new ClassResourceBundleLoader("content.Language", getClass()),
			ResourceBundleLoaderUtil.getPortalResourceBundleLoader());
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseMVCRenderCommand.class);

}