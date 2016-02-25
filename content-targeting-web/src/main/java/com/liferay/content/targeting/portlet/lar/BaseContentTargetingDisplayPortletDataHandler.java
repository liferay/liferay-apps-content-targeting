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

package com.liferay.content.targeting.portlet.lar;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.content.targeting.lar.AssetEntryReferencedStagedModel;
import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.exportimport.kernel.lar.DataLevel;
import com.liferay.exportimport.kernel.lar.DefaultConfigurationPortletDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;

import java.util.Enumeration;
import java.util.List;

import javax.portlet.PortletPreferences;

/**
 * @author Eduardo Garcia
 */
public abstract class BaseContentTargetingDisplayPortletDataHandler
	extends DefaultConfigurationPortletDataHandler {

	public BaseContentTargetingDisplayPortletDataHandler() {
		setDataLevel(DataLevel.PORTLET_INSTANCE);
		setPublishToLiveByDefault(true);
	}

	@Override
	public boolean isDisplayPortlet() {
		return true;
	}

	@Override
	protected PortletPreferences doProcessExportPortletPreferences(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		return updateExportPortletPreferences(
			portletDataContext, portletId, portletPreferences);
	}

	@Override
	protected PortletPreferences doProcessImportPortletPreferences(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		return updateImportPortletPreferences(
			portletDataContext, portletId, portletPreferences);
	}

	protected abstract List<QueryRule> getQueryRules(
			PortletPreferences portletPreferences)
		throws Exception;

	protected abstract boolean isExportReferencedContent(
		PortletDataContext portletDataContext);

	protected void updateExportAssetEntryIds(
			PortletDataContext portletDataContext, Portlet portlet,
			PortletPreferences portletPreferences, String key,
			Element rootElement)
		throws Exception {

		String oldValue = portletPreferences.getValue(key, null);

		if ((oldValue == null) || !Validator.isNumber(oldValue)) {
			return;
		}

		long assetEntryId = GetterUtil.getLong(oldValue);

		if (assetEntryId == 0) {
			return;
		}

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchAssetEntry(
			assetEntryId);

		if ((assetEntry == null) ||
			(assetEntry.getGroupId() != portletDataContext.getScopeGroupId())) {

			return;
		}

		portletPreferences.setValue(
			key + "classUuid", assetEntry.getClassUuid());
		portletPreferences.setValue(
			key + "groupId", String.valueOf(assetEntry.getGroupId()));

		AssetEntryReferencedStagedModel assetEntryReferencedStagedModel =
			new AssetEntryReferencedStagedModel(assetEntry);

		if (isExportReferencedContent(portletDataContext)) {
			try {
				StagedModelDataHandlerUtil.exportReferenceStagedModel(
					portletDataContext, portlet.getRootPortletId(),
					assetEntryReferencedStagedModel);

				return;
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Cannot export referenced content for portlet " +
							portlet.getPortletName());
				}
			}
		}

		portletDataContext.addReferenceElement(
			portlet, rootElement, assetEntryReferencedStagedModel,
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

	protected PortletPreferences updateExportPortletPreferences(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		Portlet portlet = PortletLocalServiceUtil.getPortletById(
			portletDataContext.getCompanyId(), portletId);

		List<QueryRule> queryRules = getQueryRules(portletPreferences);

		for (QueryRule queryRule : queryRules) {
			updateExportAssetEntryIds(
				portletDataContext, portlet, portletPreferences,
				"assetEntryId" + queryRule.getIndex(),
				portletDataContext.getExportDataRootElement());
			updateExportReferrerIds(
				portletDataContext, portlet, portletPreferences,
				queryRule.getIndex(),
				portletDataContext.getExportDataRootElement());
		}

		updateExportAssetEntryIds(
			portletDataContext, portlet, portletPreferences,
			"assetEntryIdDefault",
			portletDataContext.getExportDataRootElement());

		return portletPreferences;
	}

	protected abstract void updateExportReferrerIds(
			PortletDataContext portletDataContext, Portlet portlet,
			PortletPreferences portletPreferences, int index,
			Element exportDataRootElement)
		throws Exception;

	protected void updateImportAssetEntryIds(
			PortletDataContext portletDataContext,
			PortletPreferences portletPreferences, String key)
		throws Exception {

		if (!key.equals("assetEntryIdDefault") &&
			!key.matches("^assetEntryId\\d*$")) {

			return;
		}

		if (isExportReferencedContent(portletDataContext)) {
			try {
				StagedModelDataHandlerUtil.importReferenceStagedModels(
					portletDataContext, AssetEntryReferencedStagedModel.class);
			}
			catch (PortletDataException pde) {
			}
		}

		String classUuid = portletPreferences.getValue(key + "classUuid", null);

		if (Validator.isNull(classUuid)) {
			return;
		}

		long groupId = GetterUtil.getLong(
			portletPreferences.getValue(key + "groupId", null));

		if (groupId == portletDataContext.getSourceGroupId()) {
			groupId = portletDataContext.getGroupId();
		}
		else if (groupId == portletDataContext.getSourceCompanyGroupId()) {
			groupId = portletDataContext.getCompanyGroupId();
		}

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
			groupId, classUuid);

		if (assetEntry != null) {
			portletPreferences.setValue(
				key, String.valueOf(assetEntry.getEntryId()));
		}
		else {
			portletPreferences.reset(key);

			if (_log.isWarnEnabled()) {
				StringBundler sb = new StringBundler(4);

				sb.append("Unable to get asset entry for with classUUID ");
				sb.append(classUuid);
				sb.append(" in group ");
				sb.append(groupId);

				_log.warn(sb.toString());
			}
		}

		portletPreferences.reset(key + "classUuid");
		portletPreferences.reset(key + "groupId");
	}

	protected PortletPreferences updateImportPortletPreferences(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		Enumeration<String> enu = portletPreferences.getNames();

		while (enu.hasMoreElements()) {
			String key = enu.nextElement();

			updateImportAssetEntryIds(
				portletDataContext, portletPreferences, key);
			updateImportReferrerIds(
				portletDataContext, portletPreferences, key);
		}

		return portletPreferences;
	}

	protected abstract void updateImportReferrerIds(
			PortletDataContext portletDataContext,
			PortletPreferences portletPreferences, String key)
		throws Exception;

	private static final Log _log = LogFactoryUtil.getLog(
		BaseContentTargetingDisplayPortletDataHandler.class);

}