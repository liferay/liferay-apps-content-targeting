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

package com.liferay.osgi.util;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Carlos Sierra Andrés
 */
public class ServiceTrackerUtil {

	public static <T> T getService(
			final Class<T> clazz, BundleContext bundleContext)
		throws OsgiServiceUnavailableException {

		final ServiceTracker<T, T> serviceTracker = new ServiceTracker<T, T>(
			bundleContext, clazz, null);

		serviceTracker.open();

		try {
			T service = serviceTracker.waitForService(_SERVICE_TRACKER_TIMEOUT);

			if (service == null) {
				throw new OsgiServiceUnavailableException(clazz);
			}
		}
		catch (InterruptedException e) {
			throw new OsgiServiceUnavailableException(clazz);
		}

		ClassLoader classLoader = clazz.getClassLoader();

		Object o = Proxy.newProxyInstance(
			classLoader, new Class[]{clazz},
			new InvocationHandler() {

				@Override
				public Object invoke(Object o, Method method, Object[] parameters)
					throws Throwable {

					T service = serviceTracker.getService();

					if (service == null) {
						throw new OsgiServiceUnavailableException(clazz);
					}

					return method.invoke(service, parameters);
				}
			});

		return (T) o;

	}

	private static final int _SERVICE_TRACKER_TIMEOUT = 5000;

}