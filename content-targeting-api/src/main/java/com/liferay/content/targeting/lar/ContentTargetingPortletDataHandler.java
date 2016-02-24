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
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.permission.ContentTargetingPermission;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.exportimport.kernel.lar.BasePortletDataHandler;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataHandler;
import com.liferay.exportimport.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.exportimport.kernel.lar.PortletDataHandlerControl;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.xml.Element;

import java.util.List;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 * @see    com.liferay.portal.kernel.lar.PortletDataHandler
 */
@Component(
	property = {"javax.portlet.name=" + PortletKeys.CT_ADMIN},
	service = PortletDataHandler.class
)
public class ContentTargetingPortletDataHandler extends BasePortletDataHandler {

	public static final String NAMESPACE = "content_targeting";

	public ContentTargetingPortletDataHandler() {
		setDeletionSystemEventStagedModelTypes(
			new StagedModelType(Campaign.class),
			new StagedModelType(ChannelInstance.class),
			new StagedModelType(RuleInstance.class),
			new StagedModelType(UserSegment.class),
			new StagedModelType(TrackingActionInstance.class),
			new StagedModelType(Tactic.class));
		setExportControls(
			new PortletDataHandlerBoolean(
				NAMESPACE, "campaigns", true, false,
				new PortletDataHandlerControl[] {
					new PortletDataHandlerBoolean(
						NAMESPACE, "campaign-referenced-content",
						"referenced-content", true, false, null, null, null)
				},
				Campaign.class.getName()),
			new PortletDataHandlerBoolean(
				NAMESPACE, "user-segments", true, false,
				new PortletDataHandlerControl[] {
					new PortletDataHandlerBoolean(
						NAMESPACE, "user-segment-referenced-content",
						"referenced-content", true, false, null, null, null)
				},
				UserSegment.class.getName()));
		setImportControls(getExportControls());
	}

	@Override
	protected PortletPreferences doDeleteData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		if (portletDataContext.addPrimaryKey(
				ContentTargetingPortletDataHandler.class, "deleteData")) {

			return portletPreferences;
		}

		_campaignLocalService.deleteCampaigns(
			portletDataContext.getScopeGroupId());
		_userSegmentLocalService.deleteUserSegments(
			portletDataContext.getScopeGroupId());

		return portletPreferences;
	}

	@Override
	protected String doExportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		portletDataContext.addPortletPermissions(RESOURCE_NAME);

		Element rootElement = addExportDataRootElement(portletDataContext);

		if (portletDataContext.getBooleanParameter(NAMESPACE, "campaigns")) {
			ActionableDynamicQuery campaignActionableDynamicQuery =
				_campaignLocalService.getExportActionableDynamicQuery(
					portletDataContext);

			campaignActionableDynamicQuery.performActions();
		}

		if (portletDataContext.getBooleanParameter(
				NAMESPACE, "user-segments")) {

			ActionableDynamicQuery userSegmentActionableDynamicQuery =
				_userSegmentLocalService.getExportActionableDynamicQuery(
					portletDataContext);

			userSegmentActionableDynamicQuery.performActions();
		}

		return getExportDataRootElementString(rootElement);
	}

	@Override
	protected PortletPreferences doImportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences, String data)
		throws Exception {

		portletDataContext.importPortletPermissions(
			ContentTargetingPermission.RESOURCE_NAME);

		if (portletDataContext.getBooleanParameter(
				NAMESPACE, "user-segments")) {

			Element userSegmentsElement =
				portletDataContext.getImportDataGroupElement(UserSegment.class);

			List<Element> userSegmentElements = userSegmentsElement.elements();

			for (Element userSegmentElement : userSegmentElements) {
				StagedModelDataHandlerUtil.importStagedModel(
					portletDataContext, userSegmentElement);
			}
		}

		if (portletDataContext.getBooleanParameter(NAMESPACE, "campaigns")) {
			Element campaignsElement =
				portletDataContext.getImportDataGroupElement(Campaign.class);

			List<Element> campaignElements = campaignsElement.elements();

			for (Element campaignElement : campaignElements) {
				StagedModelDataHandlerUtil.importStagedModel(
					portletDataContext, campaignElement);
			}
		}

		return null;
	}

	@Override
	protected void doPrepareManifestSummary(
			PortletDataContext portletDataContext,
			PortletPreferences portletPreferences)
		throws Exception {

		ActionableDynamicQuery campaignActionableDynamicQuery =
			_campaignLocalService.getExportActionableDynamicQuery(
				portletDataContext);

		campaignActionableDynamicQuery.performCount();

		ActionableDynamicQuery userSegmentActionableDynamicQuery =
			_userSegmentLocalService.getExportActionableDynamicQuery(
				portletDataContext);

		userSegmentActionableDynamicQuery.performCount();
	}

	@Reference(unbind = "-")
	protected void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {

		_campaignLocalService = campaignLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	protected static final String RESOURCE_NAME =
		"com.liferay.content.targeting";

	private CampaignLocalService _campaignLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}