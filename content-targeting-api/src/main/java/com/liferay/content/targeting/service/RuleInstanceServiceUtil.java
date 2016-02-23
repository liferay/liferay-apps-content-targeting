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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for RuleInstance. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.RuleInstanceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstanceService
 * @see com.liferay.content.targeting.service.base.RuleInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.RuleInstanceServiceImpl
 * @generated
 */
@ProviderType
public class RuleInstanceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.RuleInstanceServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.content.targeting.model.RuleInstance addRuleInstance(
		long userId, java.lang.String ruleKey, long userSegmentId,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addRuleInstance(userId, ruleKey, userSegmentId,
			typeSettings, serviceContext);
	}

	public static com.liferay.content.targeting.model.RuleInstance deleteRuleInstance(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRuleInstance(ruleInstanceId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances(
		long userSegmentId) {
		return getService().getRuleInstances(userSegmentId);
	}

	public static long getRuleInstancesCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRuleInstancesCount(userSegmentId);
	}

	public static com.liferay.content.targeting.model.RuleInstance updateRuleInstance(
		long ruleInstanceId, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateRuleInstance(ruleInstanceId, typeSettings,
			serviceContext);
	}

	public static RuleInstanceService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RuleInstanceService, RuleInstanceService> _serviceTracker =
		ServiceTrackerFactory.open(RuleInstanceService.class);
}