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

import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.ChannelInstanceLocalService;
import com.liferay.content.targeting.service.TacticLocalService;
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
 * @author Pavel Savinov
 */
@Component(immediate = true, service = StagedModelDataHandler.class)
public class TacticStagedModelDataHandler
	extends BaseStagedModelDataHandler<Tactic> {

	public static final String[] CLASS_NAMES = {Tactic.class.getName()};

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException {

		Tactic tactic = _tacticLocalService.fetchTacticByUuidAndGroupId(
			uuid, groupId);

		if (tactic != null) {
			_tacticLocalService.deleteTactic(tactic);
		}
	}

	@Override
	public void deleteStagedModel(Tactic stagedTactic) throws PortalException {
		_tacticLocalService.deleteTactic(stagedTactic);
	}

	@Override
	public List<Tactic>
		fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {

		throw new UnsupportedOperationException();
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getDisplayName(Tactic tactic) {
		return tactic.getName(LocaleUtil.getDefault());
	}

	@Override
	public void importCompanyStagedModel(
			PortletDataContext portletDataContext, String uuid, long tacticId)
		throws PortletDataException {

		Tactic existingTactic = _tacticLocalService.fetchTacticByUuidAndGroupId(
			uuid, portletDataContext.getCompanyGroupId());

		Map<Long, Long> tacticIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				Tactic.class);

		tacticIds.put(tacticId, existingTactic.getTacticId());
	}

	@Reference(unbind = "-")
	public void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext, Tactic tactic)
		throws Exception {

		Element tacticElement = portletDataContext.getExportDataElement(tactic);

		exportUserSegments(portletDataContext, tacticElement, tactic);

		portletDataContext.addClassedModel(
			tacticElement, ExportImportPathUtil.getModelPath(tactic), tactic);

		exportChannelInstances(portletDataContext, tactic);
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext, Tactic tactic)
		throws Exception {

		long userId = portletDataContext.getUserId(tactic.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			tactic);

		serviceContext.setUserId(userId);

		long[] userSegmentIds = importUserSegments(portletDataContext, tactic);

		Tactic importedTactic = null;

		if (portletDataContext.isDataStrategyMirror()) {
			Tactic existingTactic =
				_tacticLocalService.fetchTacticByUuidAndGroupId(
					tactic.getUuid(), portletDataContext.getScopeGroupId());

			if (existingTactic == null) {
				serviceContext.setUuid(tactic.getUuid());

				importedTactic = _tacticLocalService.addTactic(
					userId, tactic.getCampaignId(), tactic.getNameMap(),
					tactic.getDescriptionMap(), userSegmentIds, serviceContext);
			}
			else {
				importedTactic = _tacticLocalService.updateTactic(
					existingTactic.getTacticId(), tactic.getCampaignId(),
					tactic.getNameMap(), tactic.getDescriptionMap(),
					userSegmentIds, serviceContext);
			}
		}
		else {
			importedTactic = _tacticLocalService.addTactic(
				userId, tactic.getCampaignId(), tactic.getNameMap(),
				tactic.getDescriptionMap(), userSegmentIds, serviceContext);
		}

		importChannelInstances(portletDataContext, tactic, importedTactic);

		portletDataContext.importClassedModel(tactic, importedTactic);
	}

	protected void exportChannelInstances(
			PortletDataContext portletDataContext, Tactic tactic)
		throws Exception {

		List<ChannelInstance> channelInstances =
			_channelInstanceLocalService.getChannelInstances(
				tactic.getTacticId());

		for (ChannelInstance channelInstance : channelInstances) {
			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, tactic, channelInstance,
				PortletDataContext.REFERENCE_TYPE_EMBEDDED);
		}
	}

	protected void exportUserSegments(
			PortletDataContext portletDataContext, Element tacticElement,
			Tactic tactic)
		throws Exception {

		List<UserSegment> tacticUserSegments =
			_userSegmentLocalService.getTacticUserSegments(
				tactic.getTacticId());

		for (UserSegment userSegment : tacticUserSegments) {
			if (portletDataContext.getBooleanParameter(
					ContentTargetingPortletDataHandler.NAMESPACE,
					"user-segments")) {

				StagedModelDataHandlerUtil.exportReferenceStagedModel(
					portletDataContext, tactic, userSegment,
					PortletDataContext.REFERENCE_TYPE_DEPENDENCY);
			}
			else {
				portletDataContext.addReferenceElement(
					tactic, tacticElement, userSegment,
					PortletDataContext.REFERENCE_TYPE_DEPENDENCY, true);
			}
		}
	}

	protected void importChannelInstances(
			PortletDataContext portletDataContext, Tactic tactic,
			Tactic importedTactic)
		throws Exception {

		List<Element> channelInstanceElements =
			portletDataContext.getReferenceDataElements(
				tactic, ChannelInstance.class);

		for (Element channelInstanceElement : channelInstanceElements) {
			String channelInstancePath = channelInstanceElement.attributeValue(
				"path");

			ChannelInstance channelInstance =
				(ChannelInstance)portletDataContext.getZipEntryAsObject(
					channelInstancePath);

			channelInstance.setTacticId(importedTactic.getTacticId());

			StagedModelDataHandlerUtil.importStagedModel(
				portletDataContext, channelInstance);
		}
	}

	protected long[] importUserSegments(
			PortletDataContext portletDataContext, Tactic tactic)
		throws Exception {

		StagedModelDataHandlerUtil.importReferenceStagedModels(
			portletDataContext, tactic, UserSegment.class);

		List<Element> userSegmentReferenceElements =
			portletDataContext.getReferenceElements(tactic, UserSegment.class);

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
	protected void setChannelInstanceLocalService(
		ChannelInstanceLocalService channelInstanceLocalService) {

		_channelInstanceLocalService = channelInstanceLocalService;
	}

	@Reference(unbind = "-")
	protected void setTacticLocalService(
		TacticLocalService tacticLocalService) {

		_tacticLocalService = tacticLocalService;
	}

	@Override
	protected boolean validateMissingReference(String uuid, long groupId) {
		Tactic tactic = _tacticLocalService.fetchTacticByUuidAndGroupId(
			uuid, groupId);

		if (tactic == null) {
			return false;
		}

		return true;
	}

	private ChannelInstanceLocalService _channelInstanceLocalService;
	private TacticLocalService _tacticLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}