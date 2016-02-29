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

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.content.targeting.portlet.util.UserSegmentQueryRuleUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.exportimport.kernel.lar.DataLevel;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;

import java.util.List;

import javax.portlet.PortletPreferences;

/**
 * @author Julio Camarero
 */
public class UserSegmentContentDisplayPortletDataHandler
	extends BaseContentTargetingDisplayPortletDataHandler {

	public static final String NAMESPACE = "user_segment_content_display";

	public UserSegmentContentDisplayPortletDataHandler() {
		setDataLevel(DataLevel.PORTLET_INSTANCE);
		setExportControls(
			new PortletDataHandlerBoolean(
				NAMESPACE, "referenced-user-segments", true, false),
			new PortletDataHandlerBoolean(
				NAMESPACE, "referenced-content", true, false));
	}

	protected List<QueryRule> getQueryRules(
			PortletPreferences portletPreferences)
		throws Exception {

		return UserSegmentQueryRuleUtil.getUserSegmentQueryRules(
			portletPreferences, LocaleUtil.getDefault(), false);
	}

	@Override
	protected boolean isExportReferencedContent(
		PortletDataContext portletDataContext) {

		return portletDataContext.getBooleanParameter(
			NAMESPACE, "referenced-content");
	}

	@Override
	protected void updateExportReferrerIds(
			PortletDataContext portletDataContext, Portlet portlet,
			PortletPreferences portletPreferences, int index,
			Element rootElement)
		throws Exception {

		String key = "userSegmentAssetCategoryIds" + index;

		String[] oldValues = portletPreferences.getValues(key, null);

		if (ArrayUtil.isEmpty(oldValues)) {
			return;
		}

		String[] newValues = new String[oldValues.length];

		for (int i = 0; i < oldValues.length; i++) {
			String oldValue = oldValues[i];

			if (!Validator.isNumber(oldValue)) {
				continue;
			}

			long categoryId = GetterUtil.getLong(oldValue);

			AssetCategory assetCategory =
				AssetCategoryLocalServiceUtil.fetchAssetCategory(categoryId);

			UserSegment userSegment =
				UserSegmentLocalServiceUtil.fetchUserSegmentByAssetCategoryId(
					categoryId);

			if ((assetCategory == null) || (userSegment == null)) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to get category with id " + categoryId);
				}

				continue;
			}

			newValues[i] = assetCategory.getUuid();

			portletPreferences.setValues(key + "uuid", newValues);

			if (portletDataContext.getBooleanParameter(
					NAMESPACE, "referenced-user-segments")) {

				StagedModelDataHandlerUtil.exportReferenceStagedModel(
					portletDataContext, portlet.getRootPortletId(),
					userSegment);
			}
			else {
				portletDataContext.addReferenceElement(
					portlet, rootElement, userSegment, UserSegment.class,
					PortletDataContext.REFERENCE_TYPE_WEAK, true);

				Element campaignElement =
					portletDataContext.getExportDataElement(userSegment);

				portletDataContext.addClassedModel(
					campaignElement,
					ExportImportPathUtil.getModelPath(userSegment),
					userSegment);
			}
		}
	}

	@Override
	protected void updateImportReferrerIds(
			PortletDataContext portletDataContext,
			PortletPreferences portletPreferences, String key)
		throws Exception {

		if (!key.matches("^userSegmentAssetCategoryIds\\d*$")) {
			return;
		}

		String[] oldValues = portletPreferences.getValues(key + "uuid", null);

		if (ArrayUtil.isEmpty(oldValues)) {
			return;
		}

		if (portletDataContext.getBooleanParameter(
				NAMESPACE, "referenced-user-segments")) {

			try {
				StagedModelDataHandlerUtil.importReferenceStagedModels(
					portletDataContext, UserSegment.class);
			}
			catch (PortletDataException pde) {
			}
		}

		String[] newValues = new String[oldValues.length];

		for (int i = 0; i < oldValues.length; i++) {
			String oldValue = oldValues[i];

			AssetCategory assetCategory =
				AssetCategoryLocalServiceUtil.
					fetchAssetCategoryByUuidAndGroupId(
						oldValue, portletDataContext.getScopeGroupId());

			if (assetCategory == null) {
				assetCategory =
					AssetCategoryLocalServiceUtil.
						fetchAssetCategoryByUuidAndGroupId(
							oldValue, portletDataContext.getCompanyGroupId());
			}

			if (assetCategory != null) {
				newValues[i] = String.valueOf(assetCategory.getCategoryId());
			}
			else {
				newValues[i] = StringPool.BLANK;

				if (_log.isWarnEnabled()) {
					StringBundler sb = new StringBundler(4);

					sb.append("Unable to get category with UUID ");
					sb.append(oldValue);
					sb.append(" in group ");
					sb.append(portletDataContext.getScopeGroupId());

					_log.warn(sb.toString());
				}
			}
		}

		portletPreferences.setValues(key, newValues);

		portletPreferences.reset(key + "uuid");
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserSegmentContentDisplayPortletDataHandler.class);

}