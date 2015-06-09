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

package com.liferay.content.targeting.deploy.hot.extender.internal.activator;

import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.deploy.hot.HotDeployEvent;
import com.liferay.portal.kernel.deploy.hot.HotDeployUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.BaseService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

/**
 * @author Carlos Sierra
 * @author Norbert Kocsis
 * @author Tibor Lipusz
 */
@Component(immediate = true)
public class HotDeployTrackerComponent {

	@Reference
	public void setPortalServletContext(MessageBus messageBus) {
		_messageBus = messageBus;
	}

	public static class OsgiDeployContext {

		private BundleContext _bundleContext;
		private ClassLoader _classLoader;

		public BundleContext getBundleContext() {
			return _bundleContext;
		}

		public ClassLoader getClassLoader() {
			return _classLoader;
		}

		public OsgiDeployContext(
			BundleContext bundleContext, ClassLoader classLoader) {

			_bundleContext = bundleContext;
			_classLoader = classLoader;
		}

	}

	public class ServiceRegistratorMessageListener implements MessageListener {

		@Override
		public void receive(Message message) {
			String servletContextName = (String)message.get(
				"servletContextName");
			String command = message.getString("command");

			if (Validator.isNull(command) || !command.equals("deploy")) {
				return;
			}

			OsgiDeployContext osgiDeployContext = _osgiDeployContexts.get(
				servletContextName);

			if (osgiDeployContext == null) {
				return;
			}

			BundleContext bundleContext = osgiDeployContext.getBundleContext();

			BeanLocator beanLocator = PortletBeanLocatorUtil.getBeanLocator(
				servletContextName);

			Map<String, BaseService> servicesMap = beanLocator.locate(
				BaseService.class);

			for (Map.Entry<String, BaseService> serviceEntry :
					servicesMap.entrySet()) {

				BaseService value = serviceEntry.getValue();
				Class<? extends BaseService> valueClass = value.getClass();
				Class serviceInterface = (Class)valueClass.getInterfaces()[0];

				bundleContext.registerService(
					serviceInterface, serviceEntry.getValue(), null);
			}

			Map<String, BaseLocalService> localServicesMap = beanLocator.locate(
				BaseLocalService.class);

			for (Map.Entry<String, BaseLocalService> localServiceEntry :
					localServicesMap.entrySet()) {

				BaseLocalService value = localServiceEntry.getValue();
				Class<? extends BaseLocalService> valueClass = value.getClass();
				Class<?> serviceInterface = valueClass.getInterfaces()[0];

				bundleContext.registerService(
					(Class<Object>)serviceInterface,
					localServiceEntry.getValue(), null);
			}
		}

	}

	@Activate
	protected void activate(final BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_serviceTracker = new ServiceTracker<ServletContext, ServletContext>(
			_bundleContext, ServletContext.class,
			new ServletContextTrackerCustomizer());

		_serviceTracker.open();

		_messageBus.registerMessageListener(
			DestinationNames.HOT_DEPLOY, _serviceRegistratorMessageListener);
	}

	@Deactivate
	protected void deactivate(final BundleContext bundleContext) {
		_serviceTracker.close();

		_serviceTracker = null;

		_messageBus.unregisterMessageListener(
			DestinationNames.HOT_DEPLOY, _serviceRegistratorMessageListener);

		_bundleContext = null;
	}

	private ClassLoader _getClassLoader(Bundle bundle) {
		BundleWiring bundleWiring = bundle.adapt(BundleWiring.class);

		return bundleWiring.getClassLoader();
	}

	private BundleContext _bundleContext;
	private MessageBus _messageBus;
	private ConcurrentHashMap<String, OsgiDeployContext> _osgiDeployContexts =
		new ConcurrentHashMap<String, OsgiDeployContext>();
	private MessageListener _serviceRegistratorMessageListener =
		new ServiceRegistratorMessageListener();
	private ServiceTracker<ServletContext, ServletContext> _serviceTracker;

	private class ServletContextTrackerCustomizer
		implements ServiceTrackerCustomizer<ServletContext, ServletContext> {

		@Override
		public ServletContext addingService(
			ServiceReference<ServletContext> serviceReference) {

			Bundle bundle = serviceReference.getBundle();

			if (bundle.getBundleId() == 0) {
				return null;
			}

			BundleContext bundleContext = bundle.getBundleContext();

			ServletContext servletContext = _bundleContext.getService(
				serviceReference);

			ClassLoader classLoader = _getClassLoader(bundle);

			_osgiDeployContexts.putIfAbsent(
				servletContext.getServletContextName(),
				new OsgiDeployContext(bundleContext, classLoader));

			HotDeployUtil.fireDeployEvent(
				new HotDeployEvent(servletContext, classLoader));

			return servletContext;
		}

		@Override
		public void modifiedService(
			ServiceReference<ServletContext> serviceReference,
			ServletContext servletContext) {
		}

		@Override
		public void removedService(
			ServiceReference<ServletContext> serviceReference,
			ServletContext servletContext) {

			OsgiDeployContext osgiDeployContext = _osgiDeployContexts.remove(
				servletContext.getServletContextName());

			if (osgiDeployContext != null) {
				HotDeployUtil.fireUndeployEvent(
					new HotDeployEvent(
						servletContext, osgiDeployContext.getClassLoader())
				);
			}

			_bundleContext.ungetService(serviceReference);
		}

	}

}