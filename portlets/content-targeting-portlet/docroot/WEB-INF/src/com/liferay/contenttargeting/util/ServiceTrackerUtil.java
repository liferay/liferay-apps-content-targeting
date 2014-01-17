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

import javax.portlet.UnavailableException;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Eduardo Garcia
 */
public class ServiceTrackerUtil {

	public static <T>ServiceTracker<T, T> getServiceTracker(
			final Class<T> clazz, BundleContext bundleContext)
		throws UnavailableException {

		ServiceTracker<T, T> serviceTracker = new ServiceTracker<T, T>(
			bundleContext, clazz, null) {

			@Override
			public T getService() {
				T service = super.getService();

				if (service == null) {
					throw new RuntimeException(
						new UnavailableServiceException(clazz));
				}

				return service;
			}
		};

		serviceTracker.open();

		try {
			serviceTracker.waitForService(_SERVICE_TRACKER_TIMEOUT);
		}
		catch (InterruptedException e) {
			throw new UnavailableServiceException(clazz);
		}

		return serviceTracker;
	}

	private static final int _SERVICE_TRACKER_TIMEOUT = 5000;

}