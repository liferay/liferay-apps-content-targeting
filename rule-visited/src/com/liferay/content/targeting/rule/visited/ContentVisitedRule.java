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

package com.liferay.content.targeting.rule.visited;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.BehaviorRuleCategory;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
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
import org.osgi.service.component.annotations.Reference;

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

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
			assetEntryId);

		if (assetEntry == null) {
			return false;
		}

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		int count = _analyticsEventLocalService.getAnalyticsEventsCount(
			anonymousUser.getAnonymousUserId(), assetEntry.getClassName(),
			assetEntry.getClassPK(), "view");

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

	@Reference
	public void setAnalyticsEventLocalService(
		AnalyticsEventLocalService analyticsEventLocalService) {

		_analyticsEventLocalService = analyticsEventLocalService;
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

		long groupId = (Long)context.get("scopeGroupId");

		boolean trackingContentEnabled =
			AnalyticsUtil.isAnalyticsContentEnabled(groupId);

		context.put("trackingContentEnabled", trackingContentEnabled);

		if (!trackingContentEnabled) {
			ContentTargetingContextUtil.populateContextAnalyticsSettingsURLs(
				context);
		}

		context.put("contentTargetingUtilClass", new ContentTargetingUtil());
	}

	protected static final String _FORM_TEMPLATE_PATH_CONTENT =
		"templates/ct_fields_content.ftl";

	private AnalyticsEventLocalService _analyticsEventLocalService;

}