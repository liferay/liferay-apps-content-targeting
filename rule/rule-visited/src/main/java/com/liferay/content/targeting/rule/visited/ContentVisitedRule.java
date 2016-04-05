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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseJSPRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.exception.InvalidRuleException;
import com.liferay.content.targeting.lar.AssetEntryReferencedStagedModel;
import com.liferay.content.targeting.lar.ContentTargetingPortletDataHandler;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.categories.BehaviorRuleCategory;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Element;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class ContentVisitedRule extends BaseJSPRule {

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

		AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(
			assetEntryId);

		if (assetEntry == null) {
			return false;
		}

		int count = _analyticsEventLocalService.getAnalyticsEventsCount(
			anonymousUser.getAnonymousUserId(), assetEntry.getClassName(),
			assetEntry.getClassPK(), "view");

		if (count > 0) {
			return true;
		}

		return false;
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment, Element ruleInstanceElement,
			RuleInstance ruleInstance)
		throws Exception {

		long assetEntryId = GetterUtil.getLong(ruleInstance.getTypeSettings());

		AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(
			assetEntryId);

		if (assetEntry == null) {
			throw new PortletDataException(
				getExportImportErrorMessage(
					userSegment, ruleInstance, AssetEntry.class.getName(),
					String.valueOf(assetEntryId), Constants.EXPORT));
		}

		ruleInstance.setTypeSettings(assetEntry.getClassUuid());

		AssetEntryReferencedStagedModel assetEntryReferencedStagedModel =
			new AssetEntryReferencedStagedModel(assetEntry);

		if (portletDataContext.getBooleanParameter(
				ContentTargetingPortletDataHandler.NAMESPACE,
				"user-segment-referenced-content")) {

			try {
				StagedModelDataHandlerUtil.exportReferenceStagedModel(
					portletDataContext, ruleInstance, ruleInstanceElement,
					assetEntryReferencedStagedModel,
					AssetEntryReferencedStagedModel.class,
					PortletDataContext.REFERENCE_TYPE_WEAK);

				return;
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Cannot export referenced content for rule " +
							"instance with id " +
								ruleInstance.getRuleInstanceId());
				}
			}
		}

		portletDataContext.addReferenceElement(
			ruleInstance, ruleInstanceElement, assetEntryReferencedStagedModel,
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
			assetEntry = _assetEntryLocalService.fetchEntry(assetEntryId);
		}
		catch (SystemException se) {
		}

		if (assetEntry != null) {
			return assetEntry.getTitle(locale);
		}

		return StringPool.BLANK;
	}

	@Override
	public void importData(
			PortletDataContext portletDataContext, UserSegment userSegment,
			RuleInstance ruleInstance)
		throws Exception {

		if (portletDataContext.getBooleanParameter(
				ContentTargetingPortletDataHandler.NAMESPACE,
				"user-segment-referenced-content")) {

			StagedModelDataHandlerUtil.importReferenceStagedModels(
				portletDataContext, ruleInstance,
				AssetEntryReferencedStagedModel.class);
		}

		String classUuid = ruleInstance.getTypeSettings();

		AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(
			portletDataContext.getScopeGroupId(), classUuid);

		if (assetEntry != null) {
			ruleInstance.setTypeSettings(
				String.valueOf(assetEntry.getEntryId()));

			return;
		}

		throw new PortletDataException(
			getExportImportErrorMessage(
				userSegment, ruleInstance, AssetEntry.class.getName(),
				classUuid, Constants.IMPORT));
	}

	@Override
	public String processRule(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidRuleException {

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
				throw new InvalidRuleException(
					"the-selected-content-can-not-be-found");
			}

			return String.valueOf(assetEntryId);
		}
		else {
			throw new InvalidRuleException("please-select-some-content");
		}
	}

	@Reference(unbind = "-")
	public void setAnalyticsEventLocalService(
		AnalyticsEventLocalService analyticsEventLocalService) {

		_analyticsEventLocalService = analyticsEventLocalService;
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.rule.visited)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH_CONTENT;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		long assetEntryId = 0;

		if (!values.isEmpty()) {
			assetEntryId = GetterUtil.getLong(values.get("assetEntryId"));
		}
		else if (ruleInstance != null) {
			assetEntryId = GetterUtil.getLong(ruleInstance.getTypeSettings());
		}

		context.put("assetEntryId", assetEntryId);
	}

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}

	private static final String _FORM_TEMPLATE_PATH_CONTENT =
		"/view_content.jsp";

	private static final Log _log = LogFactoryUtil.getLog(
		ContentVisitedRule.class);

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private AssetEntryLocalService _assetEntryLocalService;

}