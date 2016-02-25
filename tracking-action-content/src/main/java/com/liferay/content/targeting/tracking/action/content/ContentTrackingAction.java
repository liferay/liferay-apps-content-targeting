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

package com.liferay.content.targeting.tracking.action.content;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.content.targeting.api.model.BaseTrackingAction;
import com.liferay.content.targeting.api.model.TrackingAction;
import com.liferay.content.targeting.exception.InvalidTrackingActionException;
import com.liferay.content.targeting.lar.AssetEntryReferencedStagedModel;
import com.liferay.content.targeting.lar.ContentTargetingPortletDataHandler;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;

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
import org.osgi.service.component.annotations.Reference;

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
	public void exportData(
			PortletDataContext portletDataContext, Element campaignElement,
			Campaign campaign, Element trackingActionInstanceElement,
			TrackingActionInstance trackingActionInstance)
		throws Exception {

		String typeSettings = trackingActionInstance.getTypeSettings();

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

		long assetEntryId = jsonObj.getLong("assetEntryId");

		AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(
			assetEntryId);

		if (assetEntry == null) {
			throw new PortletDataException(
				getExportImportErrorMessage(
					campaign, trackingActionInstance,
					AssetEntry.class.getName(), String.valueOf(assetEntryId),
					Constants.EXPORT));
		}

		trackingActionInstance.setTypeSettings(assetEntry.getClassUuid());

		AssetEntryReferencedStagedModel assetEntryReferencedStagedModel =
			new AssetEntryReferencedStagedModel(assetEntry);

		if (portletDataContext.getBooleanParameter(
				ContentTargetingPortletDataHandler.NAMESPACE,
				"campaign-referenced-content")) {

			try {
				StagedModelDataHandlerUtil.exportReferenceStagedModel(
					portletDataContext, trackingActionInstance,
					trackingActionInstanceElement,
					assetEntryReferencedStagedModel,
					AssetEntryReferencedStagedModel.class,
					PortletDataContext.REFERENCE_TYPE_WEAK);

				return;
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Cannot export referenced content for tracking " +
							"action instance with id " +
								trackingActionInstance.
									getTrackingActionInstanceId());
				}
			}
		}

		portletDataContext.addReferenceElement(
			trackingActionInstance, trackingActionInstanceElement,
			assetEntryReferencedStagedModel,
			AssetEntryReferencedStagedModel.class,
			PortletDataContext.REFERENCE_TYPE_WEAK, true);

		Element assetEntryReferencedStagedModelElement =
			portletDataContext.getExportDataElement(
				assetEntryReferencedStagedModel);

		portletDataContext.addClassedModel(
			assetEntryReferencedStagedModelElement,
			ExportImportPathUtil.getModelPath(assetEntryReferencedStagedModel),
			assetEntryReferencedStagedModel);
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
			new Object[] {trackingActionInstance.getAlias()});

		return summary;
	}

	@Override
	public void importData(
			PortletDataContext portletDataContext, Campaign campaign,
			TrackingActionInstance trackingActionInstance)
		throws Exception {

		if (portletDataContext.getBooleanParameter(
				ContentTargetingPortletDataHandler.NAMESPACE,
				"campaign-referenced-content")) {

			StagedModelDataHandlerUtil.importReferenceStagedModels(
				portletDataContext, trackingActionInstance,
				AssetEntryReferencedStagedModel.class);
		}

		String classUuid = trackingActionInstance.getTypeSettings();

		AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(
			portletDataContext.getScopeGroupId(), classUuid);

		if (assetEntry != null) {
			trackingActionInstance.setReferrerClassPK(assetEntry.getClassPK());

			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

			jsonObj.put("assetEntryId", assetEntry.getEntryId());

			trackingActionInstance.setTypeSettings(jsonObj.toString());

			return;
		}

		trackingActionInstance.setReferrerClassPK(0);

		throw new PortletDataException(
			getExportImportErrorMessage(
				campaign, trackingActionInstance, AssetEntry.class.getName(),
				classUuid, Constants.IMPORT));
	}

	@Override
	public String processTrackingAction(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidTrackingActionException {

		long assetEntryId = GetterUtil.getLong(values.get("assetEntryId"));

		if (assetEntryId > 0) {
			AssetEntry assetEntry = null;

			try {
				assetEntry = _assetEntryLocalService.fetchAssetEntry(
					assetEntryId);
			}
			catch (SystemException se) {
				_log.error(se);
			}

			if (assetEntry == null) {
				throw new InvalidTrackingActionException(
					"the-selected-content-can-not-be-found");
			}

			values.put("referrerClassName", assetEntry.getClassName());
			values.put(
				"referrerClassPK", String.valueOf(assetEntry.getClassPK()));

			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

			jsonObj.put("assetEntryId", assetEntryId);

			return jsonObj.toString();
		}
		else {
			throw new InvalidTrackingActionException(
				"please-select-some-content");
		}
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

	@Override
	protected void populateContext(
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context, Map<String, String> values) {

		String alias = StringPool.BLANK;
		long assetEntryId = 0;
		AssetEntry assetEntry = null;
		String assetImagePreview = StringPool.BLANK;
		String assetTitlePreview = StringPool.BLANK;
		String assetTypePreview = StringPool.BLANK;
		String eventType = StringPool.BLANK;

		if (!values.isEmpty()) {
			alias = values.get("alias");
			assetEntryId = GetterUtil.getLong(values.get("assetEntryId"));
			eventType = values.get("eventType");

			if (assetEntryId > 0) {
				try {
					assetEntry = _assetEntryLocalService.fetchEntry(
						assetEntryId);
				}
				catch (SystemException se) {
					_log.error(se);
				}
			}
		}
		else if (trackingActionInstance != null) {
			alias = trackingActionInstance.getAlias();
			eventType = trackingActionInstance.getEventType();

			if (Validator.isNotNull(
					trackingActionInstance.getReferrerClassName()) &&
				(trackingActionInstance.getReferrerClassPK() > 0)) {

				try {
					assetEntry = _assetEntryLocalService.getEntry(
						trackingActionInstance.getReferrerClassName(),
						trackingActionInstance.getReferrerClassPK());

					assetEntryId = assetEntry.getEntryId();
				}
				catch (Exception e) {
					_log.error(e);
				}
			}
		}

		if (assetEntry != null) {
			AssetRendererFactory assetRendererFactory =
				AssetRendererFactoryRegistryUtil.
					getAssetRendererFactoryByClassName(
						assetEntry.getClassName());

			AssetRenderer assetRenderer = null;

			try {
				assetRenderer = assetRendererFactory.getAssetRenderer(
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
				_log.error(e);
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

		context.put("contentTargetingUtilClass", new ContentTargetingUtil());

		long groupId = (Long)context.get("scopeGroupId");

		boolean trackingContentEnabled =
			AnalyticsUtil.isAnalyticsContentEnabled(groupId);

		context.put("trackingContentEnabled", trackingContentEnabled);

		if (!trackingContentEnabled) {
			ContentTargetingContextUtil.populateContextAnalyticsSettingsURLs(
				context);
		}
	}

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}

	private static final String[] _EVENT_TYPES = {"view"};

	private static final Log _log = LogFactoryUtil.getLog(
		ContentTrackingAction.class);

	private AssetEntryLocalService _assetEntryLocalService;

}