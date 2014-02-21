/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class CampaignFinderUtil {
	public static com.liferay.contenttargeting.model.Campaign fetchByG_D_U(
		long groupId, java.util.Date date, long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().fetchByG_D_U(groupId, date, userSegmentIds);
	}

	public static com.liferay.contenttargeting.model.Campaign filterFetchByG_D_U(
		long groupId, java.util.Date date, long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().filterFetchByG_D_U(groupId, date, userSegmentIds);
	}

	public static CampaignFinder getFinder() {
		if (_finder == null) {
			_finder = (CampaignFinder)PortletBeanLocatorUtil.locate(com.liferay.contenttargeting.service.ClpSerializer.getServletContextName(),
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