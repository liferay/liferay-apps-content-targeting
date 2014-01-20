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

package com.liferay.contenttargeting.service.http;

import com.liferay.contenttargeting.service.RuleInstanceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.contenttargeting.service.RuleInstanceServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.contenttargeting.model.RuleInstanceSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.contenttargeting.model.RuleInstance}, that is translated to a
 * {@link com.liferay.contenttargeting.model.RuleInstanceSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstanceServiceHttp
 * @see com.liferay.contenttargeting.model.RuleInstanceSoap
 * @see com.liferay.contenttargeting.service.RuleInstanceServiceUtil
 * @generated
 */
public class RuleInstanceServiceSoap {
	public static com.liferay.contenttargeting.model.RuleInstanceSoap addRuleInstance(
		long userId, java.lang.String ruleKey, long userSegmentId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.contenttargeting.model.RuleInstance returnValue = RuleInstanceServiceUtil.addRuleInstance(userId,
					ruleKey, userSegmentId, typeSettings, serviceContext);

			return com.liferay.contenttargeting.model.RuleInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contenttargeting.model.RuleInstanceSoap deleteRuleInstance(
		long ruleInstanceId) throws RemoteException {
		try {
			com.liferay.contenttargeting.model.RuleInstance returnValue = RuleInstanceServiceUtil.deleteRuleInstance(ruleInstanceId);

			return com.liferay.contenttargeting.model.RuleInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contenttargeting.model.RuleInstanceSoap[] getRuleInstances(
		long userSegmentId) throws RemoteException {
		try {
			java.util.List<com.liferay.contenttargeting.model.RuleInstance> returnValue =
				RuleInstanceServiceUtil.getRuleInstances(userSegmentId);

			return com.liferay.contenttargeting.model.RuleInstanceSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long getRuleInstancesCount(long userSegmentId)
		throws RemoteException {
		try {
			long returnValue = RuleInstanceServiceUtil.getRuleInstancesCount(userSegmentId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contenttargeting.model.RuleInstanceSoap updateRuleInstance(
		long ruleInstanceId, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.contenttargeting.model.RuleInstance returnValue = RuleInstanceServiceUtil.updateRuleInstance(ruleInstanceId,
					typeSettings, serviceContext);

			return com.liferay.contenttargeting.model.RuleInstanceSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RuleInstanceServiceSoap.class);
}