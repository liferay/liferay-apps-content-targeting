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

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The extended model implementation for the CTActionTotal service. Represents a row in the &quot;CT_CTAReport_CTActionTotal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class CTActionTotalImpl extends CTActionTotalBaseImpl {

	public CTActionTotalImpl() {
		_initServices();
	}

	@Override
	public List<CTAction> getViewsByUserSegment()
		throws PortalException, SystemException {

		List<CTAction> ctActions = null;

		if (getReferrerClassPK() == 0) {
			ctActions = _ctActionLocalService.getCTActions(
				getCampaignId(), getElementId());
		}
		else {
			ctActions = _ctActionLocalService.getCTActions(
				getCampaignId(), getReferrerClassName(), getReferrerClassPK());
		}

		return filterUserSegment(ctActions);
	}

	protected List<CTAction> filterUserSegment(List<CTAction> ctActions)
		throws PortalException, SystemException {

		List<CTAction> filterCTAction = new ArrayList<CTAction>();

		for (CTAction ctAction : ctActions) {
			UserSegment userSegment = _userSegmentLocalService.fetchUserSegment(
				ctAction.getUserSegmentId());

			if (userSegment == null) {
				continue;
			}

			filterCTAction.add(ctAction);
		}

		return filterCTAction;
	}

	private void _initServices() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_ctActionLocalService = ServiceTrackerUtil.getService(
			CTActionLocalService.class, bundle.getBundleContext());
		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, bundle.getBundleContext());
	}

	private CTActionLocalService _ctActionLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}