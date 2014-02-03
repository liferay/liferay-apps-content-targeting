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

package com.liferay.contenttargeting.util;

import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Eudaldo Alonso
 */
public class ContentTargetingUtil {

	public static long[] getAssetCategoryIds(long[] userSegmentIds)
		throws SystemException {

		if (userSegmentIds == null) {
			return new long[0];
		}

		long[] assetCategoryIds = new long[userSegmentIds.length];

		for (int i = 0; i < userSegmentIds.length; i++) {
			UserSegment userSegment =
				UserSegmentLocalServiceUtil.fetchUserSegment(
					userSegmentIds[i]);

			assetCategoryIds[i] = userSegment.getAssetCategoryId();
		}

		return assetCategoryIds;
	}

}
