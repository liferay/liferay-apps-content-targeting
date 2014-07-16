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

package com.liferay.contenttargeting.reports.campaigntrackingaction.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class CampaignTrackingActionFinderUtil {
	public static java.util.List<java.lang.Object[]> findByAnalytics(
		java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByAnalytics(modifiedDate);
	}

	public static CampaignTrackingActionFinder getFinder() {
		if (_finder == null) {
			_finder = (CampaignTrackingActionFinder)PortletBeanLocatorUtil.locate(com.liferay.contenttargeting.reports.campaigntrackingaction.service.ClpSerializer.getServletContextName(),
					CampaignTrackingActionFinder.class.getName());

			ReferenceRegistry.registerReference(CampaignTrackingActionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CampaignTrackingActionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CampaignTrackingActionFinderUtil.class,
			"_finder");
	}

	private static CampaignTrackingActionFinder _finder;
}