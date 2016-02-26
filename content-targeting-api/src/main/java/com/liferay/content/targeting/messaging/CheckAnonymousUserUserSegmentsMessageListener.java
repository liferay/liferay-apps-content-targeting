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

package com.liferay.content.targeting.messaging;

import aQute.bnd.annotation.metatype.Configurable;

import com.liferay.content.targeting.configuration.AnonymousUserUserSegmentServiceConfiguration;
import com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	service = CheckAnonymousUserUserSegmentsMessageListener.class
)
public class CheckAnonymousUserUserSegmentsMessageListener
	extends BaseSchedulerEntryMessageListener {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		AnonymousUserUserSegmentServiceConfiguration
			anonymousUserUserSegmentServiceConfiguration =
				Configurable.createConfigurable(
					AnonymousUserUserSegmentServiceConfiguration.class,
					properties);

		schedulerEntryImpl.setTrigger(
			TriggerFactoryUtil.createTrigger(
				getEventListenerClass(), getEventListenerClass(),
				anonymousUserUserSegmentServiceConfiguration.
					anonymousUserUserSegmentCheckInterval(),
				TimeUnit.DAY));

		_schedulerEngineHelper.register(
			this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		_anonymousUserUserSegmentLocalService.checkAnonymousUserUserSegments();
	}

	@Reference(unbind = "-")
	protected void setAnonymousUserUserSegmentLocalService(
		AnonymousUserUserSegmentLocalService
			anonymousUserUserSegmentLocalService) {

		_anonymousUserUserSegmentLocalService =
			anonymousUserUserSegmentLocalService;
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(
		SchedulerEngineHelper schedulerEngineHelper) {

		_schedulerEngineHelper = schedulerEngineHelper;
	}

	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
	}

	private AnonymousUserUserSegmentLocalService
		_anonymousUserUserSegmentLocalService;
	private SchedulerEngineHelper _schedulerEngineHelper;

}