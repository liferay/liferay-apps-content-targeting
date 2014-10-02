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

package com.liferay.content.targeting.report.campaign.tracking.action.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class CTActionFinderUtil {
	public static java.util.List<java.lang.Object[]> findByAnalyticsWithClassName(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByAnalyticsWithClassName(campaignId, modifiedDate);
	}

	public static java.util.List<java.lang.Object[]> findByAnalyticsWithElementId(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByAnalyticsWithElementId(campaignId, modifiedDate);
	}

	public static CTActionFinder getFinder() {
		if (_finder == null) {
			_finder = (CTActionFinder)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.report.campaign.tracking.action.service.ClpSerializer.getServletContextName(),
					CTActionFinder.class.getName());

			ReferenceRegistry.registerReference(CTActionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CTActionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CTActionFinderUtil.class, "_finder");
	}

	private static CTActionFinder _finder;
}