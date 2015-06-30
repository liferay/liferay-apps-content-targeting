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

package com.liferay.content.targeting.lar;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.portal.kernel.lar.ExportImportPathUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.service.ServiceContext;

import java.util.List;
import java.util.Map;

/**
 * @author Eduardo Garcia
 */
public class CampaignStagedModelDataHandler
	extends BaseStagedModelDataHandler<Campaign> {

	public static final String[] CLASS_NAMES = {Campaign.class.getName()};

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException, SystemException {

		Campaign campaign =
			CampaignLocalServiceUtil.fetchCampaignByUuidAndGroupId(
				uuid, groupId);

		if (campaign != null) {
			CampaignLocalServiceUtil.deleteCampaign(campaign);
		}
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getDisplayName(Campaign campaign) {
		return campaign.getName(LocaleUtil.getDefault());
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext, Campaign campaign)
		throws Exception {

		Element campaignElement = portletDataContext.getExportDataElement(
			campaign);

		exportUserSegments(portletDataContext, campaignElement, campaign);

		portletDataContext.addClassedModel(
			campaignElement, ExportImportPathUtil.getModelPath(campaign),
			campaign);

		exportTrackingActionInstances(portletDataContext, campaign);

		exportTactics(portletDataContext, campaignElement, campaign);
	}

	@Override
	protected void doImportCompanyStagedModel(
			PortletDataContext portletDataContext, String uuid, long campaignId)
		throws Exception {

		Campaign existingCampaign =
			CampaignLocalServiceUtil.fetchCampaignByUuidAndGroupId(
				uuid, portletDataContext.getCompanyGroupId());

		Map<Long, Long> campaignIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				Campaign.class);

		campaignIds.put(campaignId, existingCampaign.getCampaignId());
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext, Campaign campaign)
		throws Exception {

		long userId = portletDataContext.getUserId(campaign.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			campaign);

		serviceContext.setUserId(userId);

		long[] userSegmentIds = importUserSegments(
			portletDataContext, campaign);

		Campaign importedCampaign = null;

		if (portletDataContext.isDataStrategyMirror()) {
			Campaign existingCampaign =
				CampaignLocalServiceUtil.fetchCampaignByUuidAndGroupId(
					campaign.getUuid(), portletDataContext.getScopeGroupId());

			if (existingCampaign == null) {
				serviceContext.setUuid(campaign.getUuid());

				importedCampaign = CampaignLocalServiceUtil.addCampaign(
					userId, campaign.getNameMap(), campaign.getDescriptionMap(),
					campaign.getStartDate(), campaign.getEndDate(),
					campaign.getPriority(), campaign.getActive(),
					userSegmentIds, serviceContext);
			}
			else {
				importedCampaign =
					CampaignLocalServiceUtil.updateCampaign(
						existingCampaign.getCampaignId(), campaign.getNameMap(),
						campaign.getDescriptionMap(), campaign.getStartDate(),
						campaign.getEndDate(), campaign.getPriority(),
						campaign.getActive(), userSegmentIds, serviceContext);
			}
		}
		else {
			importedCampaign = CampaignLocalServiceUtil.addCampaign(
				userId, campaign.getNameMap(), campaign.getDescriptionMap(),
				campaign.getStartDate(), campaign.getEndDate(),
				campaign.getPriority(), campaign.getActive(), userSegmentIds,
				serviceContext);
		}

		importTrackingActionInstances(
			portletDataContext, campaign, importedCampaign);

		importTactics(portletDataContext, campaign, importedCampaign);

		portletDataContext.importClassedModel(campaign, importedCampaign);
	}

	protected void exportTactics(
			PortletDataContext portletDataContext, Element campaignElement,
			Campaign campaign)
		throws Exception {

		List<Tactic> campaignTactics = TacticLocalServiceUtil.getResults(
			campaign.getCampaignId(), 0,
			TacticLocalServiceUtil.getTotal(campaign.getCampaignId()));

		for (Tactic tactic : campaignTactics) {
			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, campaign, tactic,
				PortletDataContext.REFERENCE_TYPE_EMBEDDED);
		}
	}

	protected void exportTrackingActionInstances(
			PortletDataContext portletDataContext, Campaign campaign)
		throws Exception {

		List<TrackingActionInstance> trackingActionInstances =
			TrackingActionInstanceLocalServiceUtil.getTrackingActionInstances(
					campaign.getCampaignId());

		for (TrackingActionInstance trackingActionInstance :
				trackingActionInstances) {

			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, campaign, trackingActionInstance,
				PortletDataContext.REFERENCE_TYPE_EMBEDDED);
		}
	}

	protected void exportUserSegments(
			PortletDataContext portletDataContext, Element campaignElement,
			Campaign campaign)
		throws Exception {

		List<UserSegment> campaignUserSegments =
			UserSegmentLocalServiceUtil.getCampaignUserSegments(
				campaign.getCampaignId());

		for (UserSegment userSegment : campaignUserSegments) {
			if (portletDataContext.getBooleanParameter(
					ContentTargetingPortletDataHandler.NAMESPACE,
					"user-segments")) {

				StagedModelDataHandlerUtil.exportReferenceStagedModel(
					portletDataContext, campaign, userSegment,
					PortletDataContext.REFERENCE_TYPE_DEPENDENCY);
			}
			else {
				portletDataContext.addReferenceElement(
					campaign, campaignElement, userSegment,
					PortletDataContext.REFERENCE_TYPE_DEPENDENCY, true);
			}
		}
	}

	protected void importTactics(
			PortletDataContext portletDataContext, Campaign campaign,
			Campaign importedCampaign)
		throws Exception {

		List<Element> tacticElements =
			portletDataContext.getReferenceDataElements(campaign, Tactic.class);

		for (Element tacticElement : tacticElements) {
			String tacticPath = tacticElement.attributeValue("path");

			Tactic tactic = (Tactic)portletDataContext.getZipEntryAsObject(
				tacticPath);

			tactic.setCampaignId(importedCampaign.getCampaignId());

			StagedModelDataHandlerUtil.importStagedModel(
				portletDataContext, tactic);
		}
	}

	protected void importTrackingActionInstances(
			PortletDataContext portletDataContext, Campaign campaign,
			Campaign importedCampaign)
		throws Exception {

		List<Element> trackingActionInstanceElements =
			portletDataContext.getReferenceDataElements(
					campaign, TrackingActionInstance.class);

		for (Element trackingActionInstanceElement :
				trackingActionInstanceElements) {

			String trackingActionInstancePath =
				trackingActionInstanceElement.attributeValue("path");

			TrackingActionInstance trackingActionInstance =
				(TrackingActionInstance)portletDataContext.getZipEntryAsObject(
					trackingActionInstancePath);

			trackingActionInstance.setCampaignId(
				importedCampaign.getCampaignId());

			StagedModelDataHandlerUtil.importStagedModel(
				portletDataContext, trackingActionInstance);
		}
	}

	protected long[] importUserSegments(
			PortletDataContext portletDataContext, Campaign campaign)
		throws Exception {

		StagedModelDataHandlerUtil.importReferenceStagedModels(
			portletDataContext, campaign, UserSegment.class);

		List<Element> userSegmentReferenceElements =
			portletDataContext.getReferenceElements(
				campaign, UserSegment.class);

		long[] userSegmentIdsArray =
			new long[userSegmentReferenceElements.size()];

		Map<Long, Long> userSegmentIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				UserSegment.class);

		for (int i = 0; i < userSegmentReferenceElements.size(); i++) {
			Element userSegmentReferenceElement =
				userSegmentReferenceElements.get(i);

			long userSegmentId = GetterUtil.getLong(
				userSegmentReferenceElement.attributeValue("class-pk"));

			userSegmentIdsArray[i] = MapUtil.getLong(
				userSegmentIds, userSegmentId);
		}

		return userSegmentIdsArray;
	}

	@Override
	protected boolean validateMissingReference(
			String uuid, long companyId, long groupId)
		throws Exception {

		Campaign campaign =
			CampaignLocalServiceUtil.fetchCampaignByUuidAndGroupId(
				uuid, groupId);

		if (campaign == null) {
			return false;
		}

		return true;
	}

}