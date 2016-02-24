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

package com.liferay.content.targeting.util;

import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Eduardo Garcia
 */
public class CampaignConstants {

	public static final String STATUS_FINISHED = "finished";

	public static final String STATUS_INACTIVE = "inactive";

	public static final String STATUS_STARTED = "started";

	public static final String STATUS_UPCOMING = "upcoming";

	public static String getStatusCssClass(String status) {
		if (status.equals(STATUS_FINISHED)) {
			return "label-important";
		}
		else if (status.equals(STATUS_STARTED)) {
			return "label-success";
		}
		else if (status.equals(STATUS_UPCOMING)) {
			return "label-warning";
		}

		return StringPool.BLANK;
	}

}