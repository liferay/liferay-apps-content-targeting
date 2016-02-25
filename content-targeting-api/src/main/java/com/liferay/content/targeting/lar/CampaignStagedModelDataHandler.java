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
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.TacticLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.xml.Element;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = StagedModelDataHandler.class)
public class CampaignStagedModelDataHandler
	extends BaseStagedModelDataHandler<Campaign> {

	public static final String[] CLASS_NAMES = {Campaign.class.getName()};

	@Override
	public void deleteStagedModel(Campaign campaign) throws PortalException {
		_campaignLocalService.deleteCampaign(campaign);
	}

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException {

		Campaign campaign = _campaignLocalService.fetchCampaignByUuidAndGroupId(
			uuid, groupId);

		if (campaign != null) {
			_campaignLocalService.deleteCampaign(campaign);
		}
	}

	@Override
	public List<Campaign>
		fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {

		throw new UnsupportedOperationException();
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
	public void importCompanyStagedModel(
			PortletDataContext portletDataContext, String uuid, long campaignId)
		throws PortletDataException {

		Campaign existingCampaign =
			_campaignLocalService.fetchCampaignByUuidAndGroupId(
				uuid, portletDataContext.getCompanyGroupId());

		Map<Long, Long> campaignIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				Campaign.class);

		campaignIds.put(campaignId, existingCampaign.getCampaignId());
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
				_campaignLocalService.fetchCampaignByUuidAndGroupId(
					campaign.getUuid(), portletDataContext.getScopeGroupId());

			if (existingCampaign == null) {
				serviceContext.setUuid(campaign.getUuid());

				importedCampaign = _campaignLocalService.addCampaign(
					userId, campaign.getNameMap(), campaign.getDescriptionMap(),
					campaign.getStartDate(), campaign.getEndDate(),
					campaign.getTimeZoneId(), campaign.getPriority(),
					campaign.getActive(), userSegmentIds, serviceContext);
			}
			else {
				importedCampaign = _campaignLocalService.updateCampaign(
					existingCampaign.getCampaignId(), campaign.getNameMap(),
					campaign.getDescriptionMap(), campaign.getStartDate(),
					campaign.getEndDate(), campaign.getTimeZoneId(),
					campaign.getPriority(), campaign.getActive(),
					userSegmentIds, serviceContext);
			}
		}
		else {
			importedCampaign = _campaignLocalService.addCampaign(
				userId, campaign.getNameMap(), campaign.getDescriptionMap(),
				campaign.getStartDate(), campaign.getEndDate(),
				campaign.getTimeZoneId(), campaign.getPriority(),
				campaign.getActive(), userSegmentIds, serviceContext);
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

		List<Tactic> campaignTactics = _tacticLocalService.getTactics(
			campaign.getCampaignId());

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
			_trackingActionInstanceLocalService.getTrackingActionInstances(
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
			_userSegmentLocalService.getCampaignUserSegments(
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

	@Reference(unbind = "-")
	protected void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {

		_campaignLocalService = campaignLocalService;
	}

	@Reference(unbind = "-")
	protected void setTacticLocalService(
		TacticLocalService tacticLocalService) {

		_tacticLocalService = tacticLocalService;
	}

	@Reference(unbind = "-")
	protected void setTrackingActionInstanceLocalService(
		TrackingActionInstanceLocalService trackingActionInstanceLocalService) {

		_trackingActionInstanceLocalService =
			trackingActionInstanceLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	@Override
	protected boolean validateMissingReference(String uuid, long groupId) {
		Campaign campaign = _campaignLocalService.fetchCampaignByUuidAndGroupId(
			uuid, groupId);

		if (campaign == null) {
			return false;
		}

		return true;
	}

	private CampaignLocalService _campaignLocalService;
	private TacticLocalService _tacticLocalService;
	private TrackingActionInstanceLocalService
		_trackingActionInstanceLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}