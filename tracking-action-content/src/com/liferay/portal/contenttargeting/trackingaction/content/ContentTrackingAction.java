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

package com.liferay.portal.contenttargeting.trackingaction.content;

import com.liferay.portal.contenttargeting.analytics.util.AnalyticsUtil;
import com.liferay.portal.contenttargeting.api.model.BaseTrackingAction;
import com.liferay.portal.contenttargeting.api.model.TrackingAction;
import com.liferay.portal.contenttargeting.model.TrackingActionInstance;
import com.liferay.portal.contenttargeting.trackingaction.content.util.ContentTrackingActionUtil;
import com.liferay.portal.contenttargeting.util.WebKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
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

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = TrackingAction.class)
public class ContentTrackingAction extends BaseTrackingAction {

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
	public List<String> getEventTypes() {
		return ListUtil.fromArray(_EVENT_TYPES);
	}

	@Override
	public String getIcon() {
		return "icon-file-alt";
	}

	@Override
	public String getSummary(
		TrackingActionInstance trackingActionInstance, Locale locale) {

		String summary = LanguageUtil.format(
			locale, "tracking-content-x",
			new Object[] {
				trackingActionInstance.getAlias(),
			});

		return summary;
	}

	@Override
	public String processTrackingAction(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws Exception {

		String assetEntryId = values.get("assetEntryId");

		if (Validator.isNotNull(assetEntryId)) {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
				Long.valueOf(assetEntryId));

			values.put("referrerClassName", assetEntry.getClassName());
			values.put(
				"referrerClassPK", String.valueOf(assetEntry.getClassPK()));

			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

			jsonObj.put("assetEntryId", assetEntryId);

			return jsonObj.toString();
		}

		return StringPool.BLANK;
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
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context) {

		String alias = StringPool.BLANK;
		long assetEntryId = 0;
		String assetImagePreview = StringPool.BLANK;
		String assetTitlePreview = StringPool.BLANK;
		String assetTypePreview = StringPool.BLANK;
		String eventType = StringPool.BLANK;

		if (trackingActionInstance != null) {
			alias = trackingActionInstance.getAlias();
			eventType = trackingActionInstance.getEventType();

			try {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
					trackingActionInstance.getReferrerClassName(),
					trackingActionInstance.getReferrerClassPK());

				assetEntryId = assetEntry.getEntryId();

				AssetRendererFactory assetRendererFactory =
					AssetRendererFactoryRegistryUtil.
						getAssetRendererFactoryByClassName(
							assetEntry.getClassName());

				AssetRenderer assetRenderer =
					assetRendererFactory.getAssetRenderer(
						assetEntry.getClassPK());

				RenderRequest renderRequest = (RenderRequest)context.get(
					"renderRequest");

				assetImagePreview = assetRenderer.getThumbnailPath(
					renderRequest);

				ThemeDisplay themeDisplay =
					(ThemeDisplay)renderRequest.getAttribute(
						WebKeys.THEME_DISPLAY);

				assetTitlePreview = assetRenderer.getTitle(
					themeDisplay.getLocale());
				assetTypePreview = assetRendererFactory.getTypeName(
					themeDisplay.getLocale(), true);
			}
			catch (Exception e) {
			}
		}

		context.put("alias", alias);
		context.put("assetEntryId", assetEntryId);
		context.put("assetImagePreview", assetImagePreview);
		context.put("assetTitlePreview", assetTitlePreview);
		context.put("assetTypePreview", assetTypePreview);
		context.put("eventType", eventType);
		context.put("eventTypes", getEventTypes());

		Company company = (Company)context.get("company");

		context.put(
			"assetRendererFactories",
			getSelectableAssetRendererFactories(company.getCompanyId()));

		context.put(
			"contentTrackingActionUtilClass", new ContentTrackingActionUtil());

		long groupId = (Long)context.get("scopeGroupId");

		boolean trackingContentEnabled =
			AnalyticsUtil.isAnalyticsContentEnabled(groupId);

		context.put("trackingContentEnabled", trackingContentEnabled);

		if (!trackingContentEnabled) {
			populateContextURLs(context);
		}
	}

	private static final String[] _EVENT_TYPES = {"view"};

}