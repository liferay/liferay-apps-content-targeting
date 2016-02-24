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

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.portlet.util.CampaignQueryRuleUtil;
import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.exportimport.kernel.lar.DataLevel;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;

import java.util.List;

import javax.portlet.PortletPreferences;

/**
 * @author Eduardo Garcia
 */
public class CampaignContentDisplayPortletDataHandler
	extends BaseContentTargetingDisplayPortletDataHandler {

	public static final String NAMESPACE = "campaign_content_display";

	public CampaignContentDisplayPortletDataHandler() {
		setDataLevel(DataLevel.PORTLET_INSTANCE);
		setExportControls(
			new PortletDataHandlerBoolean(
				NAMESPACE, "referenced-campaigns", true, false),
			new PortletDataHandlerBoolean(
				NAMESPACE, "referenced-content", true, false));
	}

	@Override
	protected List<QueryRule> getQueryRules(
			PortletPreferences portletPreferences)
		throws Exception {

		return CampaignQueryRuleUtil.getCampaignQueryRules(
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

		String key = "campaignId" + index;

		String oldValue = portletPreferences.getValue(key, null);

		if ((oldValue == null) || !Validator.isNumber(oldValue)) {
			return;
		}

		long campaignId = GetterUtil.getLong(oldValue);

		Campaign campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);

		if (campaign == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to get campaign with id " + campaignId);
			}

			return;
		}

		portletPreferences.setValue(key + "uuid", campaign.getUuid());

		if (portletDataContext.getBooleanParameter(
				NAMESPACE, "referenced-campaigns")) {

			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, portlet.getRootPortletId(), campaign);
		}
		else {
			portletDataContext.addReferenceElement(
				portlet, rootElement, campaign, Campaign.class,
				PortletDataContext.REFERENCE_TYPE_WEAK, true);

			Element campaignElement = portletDataContext.getExportDataElement(
				campaign);

			portletDataContext.addClassedModel(
				campaignElement, ExportImportPathUtil.getModelPath(campaign),
				campaign);
		}
	}

	@Override
	protected void updateImportReferrerIds(
			PortletDataContext portletDataContext,
			PortletPreferences portletPreferences, String key)
		throws Exception {

		if (!key.matches("^campaignId\\d*$")) {
			return;
		}

		if (portletDataContext.getBooleanParameter(
				NAMESPACE, "referenced-campaigns")) {

			try {
				StagedModelDataHandlerUtil.importReferenceStagedModels(
					portletDataContext, Campaign.class);
			}
			catch (PortletDataException pde) {
			}
		}

		String uuid = portletPreferences.getValue(key + "uuid", null);

		Campaign campaign =
			CampaignLocalServiceUtil.fetchCampaignByUuidAndGroupId(
				uuid, portletDataContext.getScopeGroupId());

		if (campaign == null) {
			campaign = CampaignLocalServiceUtil.fetchCampaignByUuidAndGroupId(
				uuid, portletDataContext.getCompanyGroupId());
		}

		if (campaign != null) {
			portletPreferences.setValue(
				key, String.valueOf(campaign.getCampaignId()));
		}
		else {
			portletPreferences.reset(key);

			if (_log.isWarnEnabled()) {
				StringBundler sb = new StringBundler(4);

				sb.append("Unable to get campaign with UUID ");
				sb.append(uuid);
				sb.append(" in group ");
				sb.append(portletDataContext.getScopeGroupId());

				_log.warn(sb.toString());
			}
		}

		portletPreferences.reset(key + "uuid");
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CampaignContentDisplayPortletDataHandler.class);

}