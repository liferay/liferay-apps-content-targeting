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

package com.liferay.content.targeting.service.impl;

import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.base.TacticServiceBaseImpl;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the tactic remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.TacticService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.TacticServiceBaseImpl
 * @see com.liferay.content.targeting.service.TacticServiceUtil
 */
public class TacticServiceImpl extends TacticServiceBaseImpl {

	@Override
	public Tactic addTactic(
			long userId, long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, long[] userSegmentsIds,
			ServiceContext serviceContext)
		throws PortalException {

		CampaignPermission.check(
			getPermissionChecker(), campaignId, ActionKeys.UPDATE);

		return tacticLocalService.addTactic(
			userId, campaignId, nameMap, descriptionMap, userSegmentsIds,
			serviceContext);
	}

	@Override
	public List<Tactic> getTactics(long campaignId) throws PortalException {
		return tacticLocalService.getTactics(campaignId);
	}

	@Override
	public Tactic updateTactic(
			long tacticId, long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, long[] userSegmentsIds,
			ServiceContext serviceContext)
		throws PortalException {

		CampaignPermission.check(
			getPermissionChecker(), campaignId, ActionKeys.UPDATE);

		return tacticLocalService.updateTactic(
			tacticId, campaignId, nameMap, descriptionMap, userSegmentsIds,
			serviceContext);
	}

}