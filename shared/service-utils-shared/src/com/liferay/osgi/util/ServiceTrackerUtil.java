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

import com.liferay.portal.kernel.util.ProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Carlos Sierra Andrés
 */
public class ServiceTrackerUtil {

	public static <T> T getService(
			final Class<T> clazz, BundleContext bundleContext) {

		final ServiceTracker<T, T> serviceTracker = new ServiceTracker<T, T>(
			bundleContext, clazz, null);

		serviceTracker.open();

		ClassLoader classLoader = clazz.getClassLoader();

		Object serviceProxy = ProxyUtil.newProxyInstance(
			classLoader, new Class[]{clazz},
			new InvocationHandler() {

				@Override
				public Object invoke(
						Object object, Method method, Object[] parameters)
					throws Throwable {

					T service = serviceTracker.getService();

					if (service == null) {
						throw new OsgiServiceUnavailableException(clazz);
					}

					try {
						return method.invoke(service, parameters);
					}
					catch (InvocationTargetException ite) {
						throw ite.getTargetException();
					}
				}
			});

		return (T)serviceProxy;
	}

}