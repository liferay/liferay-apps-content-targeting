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
public class ConsumerDataFinderUtil {
	public static java.util.List<java.lang.Object[]> findBy(long companyId,
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findBy(companyId, date);
	}

	public static java.util.List<java.lang.Object[]> sumTimeOnScreen(
		java.lang.String eventType, long companyId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().sumTimeOnScreen(eventType, companyId, date);
	}

	public static ConsumerDataFinder getFinder() {
		if (_finder == null) {
			_finder = (ConsumerDataFinder)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.report.campaign.mobile.service.ClpSerializer.getServletContextName(),
					ConsumerDataFinder.class.getName());

			ReferenceRegistry.registerReference(ConsumerDataFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ConsumerDataFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ConsumerDataFinderUtil.class,
			"_finder");
	}

	private static ConsumerDataFinder _finder;
}