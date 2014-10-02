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

package com.liferay.content.targeting.analytics.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class AnalyticsEventFinderUtil {
	public static java.util.List<java.lang.Object[]> findByC_GtC_R_R(
		long companyId, java.lang.String referrerClassName,
		long referrerClassPK, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByC_GtC_R_R(companyId, referrerClassName,
			referrerClassPK, date);
	}

	public static AnalyticsEventFinder getFinder() {
		if (_finder == null) {
			_finder = (AnalyticsEventFinder)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.analytics.service.ClpSerializer.getServletContextName(),
					AnalyticsEventFinder.class.getName());

			ReferenceRegistry.registerReference(AnalyticsEventFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AnalyticsEventFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AnalyticsEventFinderUtil.class,
			"_finder");
	}

	private static AnalyticsEventFinder _finder;
}