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

import com.liferay.content.targeting.api.model.TrackingAction;
import com.liferay.content.targeting.api.model.TrackingActionsRegistry;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.portal.kernel.lar.ExportImportPathUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.service.ServiceContext;

import javax.portlet.UnavailableException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 */
public class TrackingActionInstanceStagedModelDataHandler
	extends BaseStagedModelDataHandler<TrackingActionInstance> {

	public static final String[] CLASS_NAMES = {
		TrackingActionInstance.class.getName()};

	public TrackingActionInstanceStagedModelDataHandler()
		throws UnavailableException {

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		_trackingActionsRegistry = ServiceTrackerUtil.getService(
			TrackingActionsRegistry.class, bundle.getBundleContext());
	}

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException, SystemException {

		TrackingActionInstance trackingActionInstance =
			TrackingActionInstanceLocalServiceUtil.
				fetchTrackingActionInstanceByUuidAndGroupId(uuid, groupId);

		if (trackingActionInstance != null) {
			TrackingAction trackingAction =
				_trackingActionsRegistry.getTrackingAction(
					trackingActionInstance.getTrackingActionKey());

			if (trackingAction != null) {
				trackingAction.deleteData(trackingActionInstance);
			}

			TrackingActionInstanceLocalServiceUtil.deleteTrackingActionInstance(
				trackingActionInstance);
		}
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext,
			TrackingActionInstance trackingActionInstance)
		throws Exception {

		Element trackingActionInstanceElement =
			portletDataContext.getExportDataElement(trackingActionInstance);

		TrackingAction trackingAction =
			_trackingActionsRegistry.getTrackingAction(
				trackingActionInstance.getTrackingActionKey());

		if (trackingAction != null) {
			Campaign campaign = CampaignLocalServiceUtil.getCampaign(
				trackingActionInstance.getCampaignId());

			Element campaignElement = portletDataContext.getExportDataElement(
				campaign);

			trackingAction.exportData(
				portletDataContext, campaignElement, campaign,
				trackingActionInstanceElement, trackingActionInstance);
		}

		portletDataContext.addClassedModel(
			trackingActionInstanceElement,
			ExportImportPathUtil.getModelPath(trackingActionInstance),
			trackingActionInstance);
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext,
			TrackingActionInstance trackingActionInstance)
		throws Exception {

		TrackingAction trackingAction =
			_trackingActionsRegistry.getTrackingAction(
				trackingActionInstance.getTrackingActionKey());

		if (trackingAction != null) {
			Campaign campaign = CampaignLocalServiceUtil.getCampaign(
				trackingActionInstance.getCampaignId());

			trackingAction.importData(
				portletDataContext, campaign, trackingActionInstance);
		}

		long userId = portletDataContext.getUserId(
			trackingActionInstance.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			trackingActionInstance);

		serviceContext.setUuid(trackingActionInstance.getUuid());

		TrackingActionInstance importedTrackingActionInstance =
			TrackingActionInstanceLocalServiceUtil.addTrackingActionInstance(
				userId, trackingActionInstance.getTrackingActionKey(),
				trackingActionInstance.getCampaignId(),
				trackingActionInstance.getAlias(),
				trackingActionInstance.getReferrerClassName(),
				trackingActionInstance.getReferrerClassPK(),
				trackingActionInstance.getElementId(),
				trackingActionInstance.getEventType(),
				trackingActionInstance.getTypeSettings(), serviceContext);

		portletDataContext.importClassedModel(
			trackingActionInstance, importedTrackingActionInstance);
	}

	@Override
	protected boolean validateMissingReference(
			String uuid, long companyId, long groupId)
		throws Exception {

		TrackingActionInstance trackingActionInstance =
			TrackingActionInstanceLocalServiceUtil.
				fetchTrackingActionInstanceByUuidAndGroupId(uuid, groupId);

		if (trackingActionInstance == null) {
			return false;
		}

		return true;
	}

	private TrackingActionsRegistry _trackingActionsRegistry;

}