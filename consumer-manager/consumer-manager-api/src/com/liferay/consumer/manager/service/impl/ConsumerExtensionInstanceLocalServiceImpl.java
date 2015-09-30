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
import com.liferay.consumer.manager.service.base.ConsumerExtensionInstanceLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the consumer extension instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.consumer.manager.service.base.ConsumerExtensionInstanceLocalServiceBaseImpl
 * @see com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalServiceUtil
 */
public class ConsumerExtensionInstanceLocalServiceImpl
	extends ConsumerExtensionInstanceLocalServiceBaseImpl {

	@Override
	public ConsumerExtensionInstance addConsumerExtensionInstance(
			String consumerExtensionKey, long consumerId, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		long consumerExtensionInstanceId = counterLocalService.increment();

		ConsumerExtensionInstance consumerExtensionInstance =
			consumerExtensionInstancePersistence.create(
				consumerExtensionInstanceId);

		User user = userLocalService.getUser(serviceContext.getUserId());

		Date now = new Date();

		consumerExtensionInstance.setUuid(serviceContext.getUuid());
		consumerExtensionInstance.setCompanyId(user.getCompanyId());
		consumerExtensionInstance.setUserId(user.getUserId());
		consumerExtensionInstance.setUserName(user.getFullName());
		consumerExtensionInstance.setCreateDate(
			serviceContext.getCreateDate(now));
		consumerExtensionInstance.setModifiedDate(
			serviceContext.getModifiedDate(now));
		consumerExtensionInstance.setConsumerExtensionKey(consumerExtensionKey);
		consumerExtensionInstance.setConsumerId(consumerId);
		consumerExtensionInstance.setTypeSettings(typeSettings);

		consumerExtensionInstancePersistence.update(consumerExtensionInstance);

		return consumerExtensionInstance;
	}

	@Override
	public ConsumerExtensionInstance deleteConsumerExtensionInstance(
			long consumerExtensionInstanceId)
		throws PortalException, SystemException {

		return consumerExtensionInstancePersistence.remove(
			consumerExtensionInstanceId);
	}

	@Override
	public List<ConsumerExtensionInstance> getConsumerExtensionInstances(
			long consumerId)
		throws SystemException {

		return consumerExtensionInstancePersistence.findByConsumerId(
			consumerId);
	}

	@Override
	public List<ConsumerExtensionInstance> getConsumerExtensionInstances(
			long consumerId, String consumerExtensionKey)
		throws SystemException {

		return consumerExtensionInstancePersistence.findByC_K(
			consumerId, consumerExtensionKey);
	}

	@Override
	public ConsumerExtensionInstance updateConsumerExtensionInstance(
			long consumerExtensionInstanceId, String consumerExtensionKey,
			long consumerId, String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		ConsumerExtensionInstance consumerExtensionInstance =
			consumerExtensionInstancePersistence.findByPrimaryKey(
				consumerExtensionInstanceId);

		consumerExtensionInstance.setModifiedDate(
			serviceContext.getModifiedDate(now));

		consumerExtensionInstance.setConsumerExtensionKey(consumerExtensionKey);
		consumerExtensionInstance.setConsumerId(consumerId);
		consumerExtensionInstance.setTypeSettings(typeSettings);

		consumerExtensionInstancePersistence.update(consumerExtensionInstance);

		return consumerExtensionInstance;
	}

}