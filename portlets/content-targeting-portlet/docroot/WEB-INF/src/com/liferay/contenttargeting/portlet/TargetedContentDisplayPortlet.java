/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.portlet;

import com.liferay.contenttargeting.portlet.util.QueryRule;
import com.liferay.contenttargeting.portlet.util.QueryRuleUtil;
import com.liferay.contenttargeting.portlet.util.UnavailableServiceException;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.util.UserSegmentUtil;
import com.liferay.contenttargeting.util.WebKeys;
import com.liferay.osgi.util.OsgiServiceUnavailableException;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.TemplateResourceLoaderUtil;
import com.liferay.portal.kernel.template.TemplateTaglibSupportProvider;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.util.bridges.freemarker.FreeMarkerPortlet;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.servlet.HttpRequestHashModel;

import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateHashModel;

import java.io.IOException;
import java.io.Writer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.UnavailableException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;

import org.osgi.framework.Bundle;

/**
 * @author Eudaldo Alonso
 */
public class TargetedContentDisplayPortlet extends FreeMarkerPortlet {

	@Override
	public void init() throws PortletException {
		super.init();

		PortletContext portletContext = getPortletContext();

		Bundle bundle = (Bundle)portletContext.getAttribute("OSGI_BUNDLE");

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		try {
			_userSegmentLocalService = ServiceTrackerUtil.getService(
				UserSegmentLocalService.class, bundle.getBundleContext());
		}
		catch (OsgiServiceUnavailableException osue) {
			throw new UnavailableServiceException(
				osue.getUnavailableServiceClass());
		}
	}

	public void updatePreferences(
			ActionRequest request, ActionResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		int[] queryRulesIndexes = StringUtil.split(
			ParamUtil.getString(request, "queryLogicIndexes"), 0);

		if (ArrayUtil.isEmpty(queryRulesIndexes)) {
			return;
		}

		PortletPreferences portletPreferences = request.getPreferences();

		portletPreferences.setValue("showAssetTitle", String.valueOf(false));

		portletPreferences.setValues(
			"queryLogicIndexes", ArrayUtil.toStringArray(queryRulesIndexes));

		for (int queryRulesIndex : queryRulesIndexes) {
			QueryRule queryRule = QueryRuleUtil.getQueryRule(
				request, queryRulesIndex, themeDisplay.getLocale());

			if (!queryRule.isValid()) {
				break;
			}

			portletPreferences.setValue(
				"queryContains" + queryRulesIndex,
				String.valueOf(queryRule.isContains()));
			portletPreferences.setValue(
				"queryAndOperator" + queryRulesIndex,
				String.valueOf(queryRule.isAndOperator()));
			portletPreferences.setValues(
				"userSegmentAssetCategoryIds" + queryRulesIndex,
				ArrayUtil.toStringArray(
					queryRule.getUserSegmentAssetCategoryIds()));
			portletPreferences.setValue(
				"assetEntryId" + queryRulesIndex,
				String.valueOf(queryRule.getAssetEntryId()));
		}

		portletPreferences.store();
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
	protected void include(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, String lifecycle)
		throws IOException, PortletException {

		PortletContext portletContext = getPortletContext();

		String servletContextName = portletContext.getPortletContextName();

		String resourcePath = servletContextName.concat(
			TemplateConstants.SERVLET_SEPARATOR).concat(path);

		boolean resourceExists = false;

		try {
			resourceExists = TemplateResourceLoaderUtil.hasTemplateResource(
				TemplateConstants.LANG_TYPE_FTL, resourcePath);
		}
		catch (TemplateException te) {
			throw new IOException(te.getMessage());
		}

		if (!resourceExists) {
			_log.error(path + " is not a valid include");
		}
		else {
			try {
				TemplateResource templateResource =
					TemplateResourceLoaderUtil.getTemplateResource(
						TemplateConstants.LANG_TYPE_FTL, resourcePath);

				Template template = TemplateManagerUtil.getTemplate(
					TemplateConstants.LANG_TYPE_FTL, templateResource, false);

				TemplateTaglibSupportProvider templateTaglibSupportProvider =
					getTaglibSupportProvider();

				if (templateTaglibSupportProvider != null) {
					templateTaglibSupportProvider.addTaglibSupport(
						template, servletContextName, portletRequest,
						portletResponse);
				}

				// LPS-43725

				HttpServletRequestWrapper httpServletRequestWrapper =
					new HttpServletRequestWrapper(
						PortalUtil.getHttpServletRequest(portletRequest));

				HttpServletResponseWrapper httpServletResponseWrapper =
					new HttpServletResponseWrapper(
						PortalUtil.getHttpServletResponse(portletResponse));

				HttpRequestHashModel httpRequestHashModel =
					new HttpRequestHashModel(
						httpServletRequestWrapper, httpServletResponseWrapper,
						ObjectWrapper.DEFAULT_WRAPPER);

				template.put("Request", httpRequestHashModel);

				populateContext(
					path, portletRequest, portletResponse, template);

				Writer writer = null;

				if (portletResponse instanceof MimeResponse) {
					MimeResponse mimeResponse = (MimeResponse)portletResponse;

					writer = UnsyncPrintWriterPool.borrow(
						mimeResponse.getWriter());
				}
				else {
					writer = new UnsyncStringWriter();
				}

				template.processTemplate(writer);
			}
			catch (Exception e) {
				throw new PortletException(e);
			}
		}

		if (clearRequestParameters) {
			if (lifecycle.equals(PortletRequest.RENDER_PHASE)) {
				portletResponse.setProperty("clear-request-parameters", "true");
			}
		}
	}

	protected void populateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		template.put(
			"liferayWindowStateExclusive", LiferayWindowState.EXCLUSIVE);
		template.put(
			"redirect", ParamUtil.getString(portletRequest, "redirect"));
		template.put(
			"targetedContentDisplayPath",
			staticModels.get(
				"com.liferay.contenttargeting.portlet." +
					"TargetedContentDisplayPath"));

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

		if (Validator.isNull(path) ||
			path.equals(TargetedContentDisplayPath.VIEW)) {

			long[] userSegmentIds = (long[])portletRequest.getAttribute(
				WebKeys.USER_SEGMENT_IDS);

			template.put("userSegmentIds", userSegmentIds);

			QueryRule queryRule = QueryRuleUtil.match(
				userSegmentIds, portletPreferences, themeDisplay.getLocale());

			boolean isMatchingRule = false;

			if (queryRule != null) {
				isMatchingRule = true;

				AssetEntry assetEntry =
					AssetEntryLocalServiceUtil.fetchAssetEntry(
						queryRule.getAssetEntryId());

				AssetRendererFactory assetRendererFactory =
					AssetRendererFactoryRegistryUtil.
						getAssetRendererFactoryByClassName(
							assetEntry.getClassName());

				AssetRenderer assetRenderer =
					assetRendererFactory.getAssetRenderer(
						assetEntry.getClassPK());

				portletRequest.setAttribute(
					"view.jsp-results", new ArrayList());
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
				portletRequest.setAttribute(
					"view.jsp-show", new Boolean(false));
				portletRequest.setAttribute(
					"view.jsp-print", new Boolean(false));
			}

			template.put("isMatchingRule", isMatchingRule);
		}
		else if (path.equals(TargetedContentDisplayPath.EDIT_RULE) ||
				 path.equals(TargetedContentDisplayPath.CONFIGURATION)) {

			template.put("portletPreferences", portletPreferences);

			int[] queryRulesIndexes = GetterUtil.getIntegerValues(
				portletPreferences.getValues("queryLogicIndexes", null));

			if (ArrayUtil.isEmpty(queryRulesIndexes)) {
				queryRulesIndexes = new int[] {0};
			}

			template.put("queryLogicIndexes", queryRulesIndexes);

			StringBundler vocabularyGroupIds = new StringBundler(3);

			vocabularyGroupIds.append(themeDisplay.getSiteGroupId());

			if (themeDisplay.getScopeGroupId() !=
					themeDisplay.getCompanyGroupId()) {

				vocabularyGroupIds.append(StringPool.COMMA);
				vocabularyGroupIds.append(themeDisplay.getCompanyGroupId());
			}

			template.put("vocabularyGroupIds", vocabularyGroupIds.toString());

			HttpServletRequest request = PortalUtil.getHttpServletRequest(
				portletRequest);

			template.put(
				"randomNamespace",
				PortalUtil.generateRandomKey(request, "user_segment_selector") +
					StringPool.UNDERLINE);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

			template.put(
				"vocabularyId",
				UserSegmentUtil.getAssetVocabularyId(
					themeDisplay.getUserId(), serviceContext));

			template.put(
				"targetedContentDisplayUtilClass",
				staticModels.get(
					"com.liferay.contenttargeting.portlet.util." +
							"TargetedContentDisplayUtil"));
			template.put(
				"queryRuleUtilClass",
				staticModels.get(
					"com.liferay.contenttargeting.portlet.util.QueryRuleUtil"));

			template.put(
				"assetRendererFactories",
				getSelectableAssetRendererFactories(
					themeDisplay.getCompanyId()));
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		TargetedContentDisplayPortlet.class);

	private UserSegmentLocalService _userSegmentLocalService;

}