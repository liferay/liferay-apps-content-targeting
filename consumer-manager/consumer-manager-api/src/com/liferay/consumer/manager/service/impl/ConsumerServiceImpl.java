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

import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.service.base.ConsumerServiceBaseImpl;
import com.liferay.consumer.manager.service.permission.ConsumerManagerPermission;
import com.liferay.consumer.manager.service.permission.ConsumerPermission;
import com.liferay.consumer.manager.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the consumer remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consumer.manager.service.ConsumerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.consumer.manager.service.base.ConsumerServiceBaseImpl
 * @see com.liferay.consumer.manager.service.ConsumerServiceUtil
 */
public class ConsumerServiceImpl extends ConsumerServiceBaseImpl {

	@Override
	public Consumer addConsumer(
			String consumerKey, Map<Locale, String> descriptionMap,
			Map<Locale, String> nameMap, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ConsumerManagerPermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_CONSUMER);

		return consumerLocalService.addConsumer(
			consumerKey, descriptionMap, nameMap, serviceContext);
	}

	@Override
	public Consumer deleteConsumer(long consumerId)
		throws PortalException, SystemException {

		ConsumerPermission.check(
			getPermissionChecker(), consumerId, ActionKeys.DELETE);

		return consumerLocalService.deleteConsumer(consumerId);
	}

	@Override
	public Consumer getConsumer(long companyId, String consumerKey)
		throws SystemException {

		return consumerLocalService.getConsumer(companyId, consumerKey);
	}

	@Override
	public List<Consumer> getConsumers()
		throws PortalException, SystemException {

		return consumerLocalService.getConsumers();
	}

	@Override
	public List<Consumer> getConsumers(
			long companyId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		return consumerLocalService.getConsumers(companyId);
	}

	@Override
	public List<Consumer> getConsumersByConsumerExtensionKey(
			long companyId, String consumerExtensionKey)
		throws PortalException, SystemException {

		return consumerLocalService.getConsumersByConsumerExtensionKey(
			companyId, consumerExtensionKey);
	}

	@Override
	public Consumer updateConsumer(
			long consumerId, String consumerKey,
			Map<Locale, String> descriptionMap, Map<Locale, String> nameMap,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		ConsumerPermission.check(
			getPermissionChecker(), consumerId, ActionKeys.UPDATE);

		return consumerLocalService.updateConsumer(
			consumerId, consumerKey, descriptionMap, nameMap, serviceContext);
	}

}