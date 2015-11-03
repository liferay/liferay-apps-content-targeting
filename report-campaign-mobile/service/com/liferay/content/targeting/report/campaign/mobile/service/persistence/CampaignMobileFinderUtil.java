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

package com.liferay.content.targeting.report.campaign.mobile.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class CampaignMobileFinderUtil {
	public static java.util.List<java.lang.Object[]> findBy(long companyId,
		long campaignId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findBy(companyId, campaignId, date);
	}

	public static java.util.List<java.lang.Object[]> countTimeATOnScreen(
		java.lang.String eventType, long companyId, long campaignId,
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTimeATOnScreen(eventType, companyId, campaignId, date);
	}

	public static CampaignMobileFinder getFinder() {
		if (_finder == null) {
			_finder = (CampaignMobileFinder)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.report.campaign.mobile.service.ClpSerializer.getServletContextName(),
					CampaignMobileFinder.class.getName());

			ReferenceRegistry.registerReference(CampaignMobileFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CampaignMobileFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CampaignMobileFinderUtil.class,
			"_finder");
	}

	private static CampaignMobileFinder _finder;
}