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

package com.liferay.contenttargeting.util;

import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.service.UserSegmentService;

import javax.portlet.UnavailableException;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Eduardo Garcia
 */
public class ServiceTrackerUtil {

	public UserSegmentLocalService getUserSegmentLocalService()
		throws UnavailableException {

		UserSegmentLocalService userSegmentLocalService =
			_userSegmentLocalServiceTracker.getService();

		if (userSegmentLocalService == null) {
			throw new UnavailableServiceException(
				UserSegmentLocalService.class);
		}

		return userSegmentLocalService;
	}

	public UserSegmentService getUserSegmentService()
		throws UnavailableException {

		UserSegmentService userSegmentService =
			_userSegmentServiceTracker.getService();

		if (userSegmentService == null) {
			throw new UnavailableServiceException(UserSegmentService.class);
		}

		return userSegmentService;
	}

	public void initServices(Bundle bundle) throws UnavailableException {
		final BundleContext bundleContext = bundle.getBundleContext();

		_userSegmentLocalServiceTracker =
			new ServiceTracker
				<UserSegmentLocalService, UserSegmentLocalService>(
				bundleContext, UserSegmentLocalService.class, null);

		_userSegmentLocalServiceTracker.open();

		_userSegmentServiceTracker =
			new ServiceTracker<UserSegmentService, UserSegmentService>(
				bundleContext, UserSegmentService.class, null);

		_userSegmentServiceTracker.open();

		try {
			UserSegmentLocalService userSegmentLocalService =
				_userSegmentLocalServiceTracker.waitForService(
					_SERVICE_TRACKER_TIMEOUT);

			if (userSegmentLocalService == null) {
				throw new UnavailableServiceException(
					UserSegmentLocalService.class);
			}

			UserSegmentService userSegmentService =
				_userSegmentServiceTracker.waitForService(
					_SERVICE_TRACKER_TIMEOUT);

			if (userSegmentService == null) {
				throw new UnavailableServiceException(UserSegmentService.class);
			}
		}
		catch (InterruptedException e) {
			throw new UnavailableException(e.getMessage());
		}
	}

	private static final int _SERVICE_TRACKER_TIMEOUT = 5000;

	private ServiceTracker<UserSegmentLocalService, UserSegmentLocalService>
		_userSegmentLocalServiceTracker;
	private ServiceTracker<UserSegmentService, UserSegmentService>
		_userSegmentServiceTracker;

}