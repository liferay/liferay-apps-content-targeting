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

package com.liferay.consumer.manager.service.permission;

import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.service.ConsumerLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Eduardo Garcia
 */
public class ConsumerPermission {

	public static void check(
			PermissionChecker permissionChecker, Consumer consumer,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, consumer, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long consumerId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, consumerId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, Consumer consumer,
		String actionId) {

		return permissionChecker.hasPermission(
			0, Consumer.class.getName(), consumer.getConsumerId(), actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long consumerId,
			String actionId)
		throws PortalException, SystemException {

		if (consumerId > 0) {
			Consumer consumer = ConsumerLocalServiceUtil.getConsumer(
				consumerId);

			return contains(permissionChecker, consumer, actionId);
		}
		else {
			return permissionChecker.hasPermission(
				0, Consumer.class.getName(), 0, actionId);
		}
	}

}