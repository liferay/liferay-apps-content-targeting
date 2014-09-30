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

package com.liferay.content.targeting.report.campaign.tracking.action.model.impl;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CampaignTrackingActionLocalService;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The extended model implementation for the CampaignTrackingActionTotal service. Represents a row in the &quot;ContentTargeting_CampaignTAReport_CampaignTrackingActionTotal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class CampaignTrackingActionTotalImpl
	extends CampaignTrackingActionTotalBaseImpl {

	public CampaignTrackingActionTotalImpl() {
	}

	@Override
	public List<CampaignTrackingAction> getViewsByUserSegment()
		throws PortalException, SystemException {

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		CampaignTrackingActionLocalService campaignTrackingActionLocalService =
			ServiceTrackerUtil.getService(
				CampaignTrackingActionLocalService.class,
				bundle.getBundleContext());

		List<CampaignTrackingAction> campaignTrackingActions = null;

		if (getReferrerClassPK() == 0) {
			campaignTrackingActions =
				campaignTrackingActionLocalService.getCampaignTrackingActions(
					getCampaignId(), getElementId());
		}
		else {
			campaignTrackingActions =
				campaignTrackingActionLocalService.getCampaignTrackingActions(
					getCampaignId(), getReferrerClassName(),
					getReferrerClassPK());
		}

		return campaignTrackingActions;
	}

}