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

package com.liferay.contenttargeting.rules.visited;

import com.liferay.analytics.service.AnalyticsEventLocalService;
import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.rulecategories.BehaviorRuleCategory;
import com.liferay.contenttargeting.rules.visited.util.VisitedRuleUtil;
import com.liferay.contenttargeting.util.WebKeys;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class ContentVisitedRule extends BaseRule {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		long assetEntryId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		AssetEntry assetEntry = null;

		try {
			assetEntry = AssetEntryLocalServiceUtil.fetchEntry(assetEntryId);
		}
		catch (SystemException e) {
		}

		if (assetEntry == null) {
			return false;
		}

		int count = 0;

		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			AnalyticsEventLocalService analyticsEventLocalService =
				ServiceTrackerUtil.getService(
					AnalyticsEventLocalService.class,
					bundle.getBundleContext());

			count = analyticsEventLocalService.getAnalyticsEventsCount(
				assetEntry.getClassName(), assetEntry.getClassPK(), "view");
		}
		catch (Exception e) {
		}

		if (count > 0) {
			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-file-text";
	}

	@Override
	public String getRuleCategoryKey() {
		return BehaviorRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		long assetEntryId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		AssetEntry assetEntry = null;

		try {
			assetEntry = AssetEntryLocalServiceUtil.fetchEntry(assetEntryId);
		}
		catch (SystemException e) {
		}

		if (assetEntry != null) {
			return assetEntry.getTitle(locale);
		}

		return StringPool.BLANK;
	}

	@Override
	public String processRule(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws Exception {

		return values.get("assetEntryId");
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_CONTENT;
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
		RuleInstance ruleInstance, Map<String, Object> context) {

		long assetEntryId = 0;

		if (ruleInstance != null) {
			assetEntryId = GetterUtil.getLong(ruleInstance.getTypeSettings());
		}

		context.put("assetEntryId", assetEntryId);

		String assetImage = StringPool.BLANK;
		String assetTitle = StringPool.BLANK;
		String assetType = StringPool.BLANK;

		if (assetEntryId > 0) {
			try {
				RenderRequest renderRequest = (RenderRequest)context.get(
					"renderRequest");

				AssetEntry assetEntry =
					AssetEntryLocalServiceUtil.fetchAssetEntry(assetEntryId);

				AssetRendererFactory assetRendererFactory =
					AssetRendererFactoryRegistryUtil.
						getAssetRendererFactoryByClassName(
							assetEntry.getClassName());

				AssetRenderer assetRenderer =
					assetRendererFactory.getAssetRenderer(
						assetEntry.getClassPK());

				assetImage = assetRenderer.getThumbnailPath(renderRequest);

				ThemeDisplay themeDisplay =
					(ThemeDisplay)renderRequest.getAttribute(
						WebKeys.THEME_DISPLAY);

				assetTitle = assetRenderer.getTitle(themeDisplay.getLocale());
				assetType = assetRendererFactory.getTypeName(
					themeDisplay.getLocale(), true);
			}
			catch (Exception e) {
			}
		}

		context.put("assetImage", assetImage);
		context.put("assetTitle", assetTitle);
		context.put("assetType", assetType);

		Company company = (Company)context.get("company");

		context.put(
			"assetRendererFactories",
			getSelectableAssetRendererFactories(company.getCompanyId()));

		boolean trackingContentEnabled = false;

		try {
			trackingContentEnabled = PrefsPropsUtil.getBoolean(
				company.getCompanyId(),
				"content.targeting.analytics.content.enabled");
		}
		catch (SystemException e) {
		}

		context.put("trackingContentEnabled", trackingContentEnabled);

		context.put("visitedRuleUtilClass", new VisitedRuleUtil());
	}

	protected static final String _FORM_TEMPLATE_PATH_CONTENT =
		"templates/ct_fields_content.ftl";

}