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

package com.liferay.content.targeting.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TacticService}.
 *
 * @author Brian Wing Shun Chan
 * @see TacticService
 * @generated
 */
@ProviderType
public class TacticServiceWrapper implements TacticService,
	ServiceWrapper<TacticService> {
	public TacticServiceWrapper(TacticService tacticService) {
		_tacticService = tacticService;
	}

	@Override
	public com.liferay.content.targeting.model.Tactic addTactic(long userId,
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticService.addTactic(userId, campaignId, nameMap,
			descriptionMap, userSegmentsIds, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tacticService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticService.getTactics(campaignId);
	}

	@Override
	public com.liferay.content.targeting.model.Tactic updateTactic(
		long tacticId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tacticService.updateTactic(tacticId, campaignId, nameMap,
			descriptionMap, userSegmentsIds, serviceContext);
	}

	@Override
	public TacticService getWrappedService() {
		return _tacticService;
	}

	@Override
	public void setWrappedService(TacticService tacticService) {
		_tacticService = tacticService;
	}

	private TacticService _tacticService;
}