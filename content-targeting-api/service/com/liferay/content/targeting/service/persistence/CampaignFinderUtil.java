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

package com.liferay.content.targeting.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class CampaignFinderUtil {
	public static java.util.List<com.liferay.content.targeting.model.Campaign> filterFindByG_D_A_U(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .filterFindByG_D_A_U(groupIds, date, active, userSegmentIds);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> findByG_D_A_U(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByG_D_A_U(groupIds, date, active, userSegmentIds);
	}

	public static com.liferay.content.targeting.model.Campaign fetchByG_D_A_U_First(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .fetchByG_D_A_U_First(groupIds, date, active, userSegmentIds);
	}

	public static com.liferay.content.targeting.model.Campaign filterFetchByG_D_A_U_First(
		long[] groupIds, java.util.Date date, boolean active,
		long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .filterFetchByG_D_A_U_First(groupIds, date, active,
			userSegmentIds);
	}

	public static CampaignFinder getFinder() {
		if (_finder == null) {
			_finder = (CampaignFinder)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.service.ClpSerializer.getServletContextName(),
					CampaignFinder.class.getName());

			ReferenceRegistry.registerReference(CampaignFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CampaignFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CampaignFinderUtil.class, "_finder");
	}

	private static CampaignFinder _finder;
}