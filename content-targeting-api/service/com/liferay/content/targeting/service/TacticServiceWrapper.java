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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TacticService}.
 *
 * @author Brian Wing Shun Chan
 * @see TacticService
 * @generated
 */
public class TacticServiceWrapper implements TacticService,
	ServiceWrapper<TacticService> {
	public TacticServiceWrapper(TacticService tacticService) {
		_tacticService = tacticService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tacticService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tacticService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tacticService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.content.targeting.model.Tactic addTactic(long userId,
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticService.addTactic(userId, campaignId, nameMap,
			descriptionMap, userSegmentsIds, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.Tactic updateTactic(
		long tacticId, long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		long[] userSegmentsIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tacticService.updateTactic(tacticId, campaignId, nameMap,
			descriptionMap, userSegmentsIds, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TacticService getWrappedTacticService() {
		return _tacticService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTacticService(TacticService tacticService) {
		_tacticService = tacticService;
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