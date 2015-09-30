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

package com.liferay.consumer.manager.service.impl;

import com.liferay.consumer.manager.model.ConsumerExtensionInstance;
import com.liferay.consumer.manager.service.base.ConsumerExtensionInstanceServiceBaseImpl;
import com.liferay.consumer.manager.service.permission.ConsumerPermission;
import com.liferay.consumer.manager.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the consumer extension instance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consumer.manager.service.ConsumerExtensionInstanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.consumer.manager.service.base.ConsumerExtensionInstanceServiceBaseImpl
 * @see com.liferay.consumer.manager.service.ConsumerExtensionInstanceServiceUtil
 */
public class ConsumerExtensionInstanceServiceImpl
	extends ConsumerExtensionInstanceServiceBaseImpl {

	@Override
	public ConsumerExtensionInstance addConsumerExtensionInstance(
			String consumerExtensionKey, long consumerId, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		ConsumerPermission.check(
			getPermissionChecker(), consumerId, ActionKeys.UPDATE);

		return
			consumerExtensionInstanceLocalService.addConsumerExtensionInstance(
				consumerExtensionKey, consumerId, typeSettings, serviceContext);
	}

	@Override
	public ConsumerExtensionInstance deleteConsumerExtensionInstance(
			long consumerExtensionInstanceId)
		throws PortalException, SystemException {

		ConsumerExtensionInstance consumerExtensionInstance =
			consumerExtensionInstanceLocalService.getConsumerExtensionInstance(
				consumerExtensionInstanceId);

		ConsumerPermission.check(
			getPermissionChecker(), consumerExtensionInstance.getConsumerId(),
			ActionKeys.UPDATE);

		return consumerExtensionInstanceLocalService.
			deleteConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	@Override
	public List<ConsumerExtensionInstance> getConsumerExtensionInstances(
			long consumerId)
		throws PortalException, SystemException {

		ConsumerPermission.check(
			getPermissionChecker(), consumerId, ActionKeys.VIEW_CONSUMERS);

		return
			consumerExtensionInstanceLocalService.getConsumerExtensionInstances(
				consumerId);
	}

	@Override
	public List<ConsumerExtensionInstance> getConsumerExtensionInstances(
			long consumerId, String consumerExtensionKey)
		throws PortalException, SystemException {

		ConsumerPermission.check(
			getPermissionChecker(), consumerId, ActionKeys.VIEW_CONSUMERS);

		return
			consumerExtensionInstanceLocalService.getConsumerExtensionInstances(
				consumerId, consumerExtensionKey);
	}

	@Override
	public ConsumerExtensionInstance updateConsumerExtensionInstance(
			long consumerExtensionInstanceId, String consumerExtensionKey,
			long consumerId, String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ConsumerPermission.check(
			getPermissionChecker(), consumerId, ActionKeys.UPDATE);

		return consumerExtensionInstanceLocalService.
			updateConsumerExtensionInstance(
				consumerExtensionInstanceId, consumerExtensionKey, consumerId,
				typeSettings, serviceContext);
	}

}