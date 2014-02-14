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

package com.liferay.contenttargeting.service.permission;

import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.service.CampaignLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Eduardo Garcia
 */
public class CampaignPermission {

	public static void check(
			PermissionChecker permissionChecker, Campaign campaign,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, campaign, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long campaignId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, campaignId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, Campaign campaign,
		String actionId) {

		if (permissionChecker.hasOwnerPermission(
				campaign.getCompanyId(), Campaign.class.getName(),
				campaign.getCampaignId(), campaign.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			campaign.getGroupId(), Campaign.class.getName(),
			campaign.getCampaignId(), actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long campaignId,
			String actionId)
		throws PortalException, SystemException {

		Campaign campaign = CampaignLocalServiceUtil.getCampaign(campaignId);

		return contains(permissionChecker, campaign, actionId);
	}

}