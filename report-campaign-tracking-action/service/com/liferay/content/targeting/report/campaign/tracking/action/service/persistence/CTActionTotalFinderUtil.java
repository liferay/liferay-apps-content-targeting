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
public class CTActionTotalFinderUtil {
	public static java.util.List<java.lang.Object[]> findByAnalyticsWithClassName(
		java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByAnalyticsWithClassName(modifiedDate);
	}

	public static java.util.List<java.lang.Object[]> findByAnalyticsWithElementId(
		java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByAnalyticsWithElementId(modifiedDate);
	}

	public static CTActionTotalFinder getFinder() {
		if (_finder == null) {
			_finder = (CTActionTotalFinder)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.report.campaign.tracking.action.service.ClpSerializer.getServletContextName(),
					CTActionTotalFinder.class.getName());

			ReferenceRegistry.registerReference(CTActionTotalFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CTActionTotalFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CTActionTotalFinderUtil.class,
			"_finder");
	}

	private static CTActionTotalFinder _finder;
}