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
import com.liferay.portal.kernel.deploy.hot.HotDeployException;
import com.liferay.portal.kernel.deploy.hot.HotDeployListener;
import com.liferay.portal.kernel.deploy.hot.HotDeployUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.PortalLifecycle;
import com.liferay.portal.kernel.util.PortalLifecycleUtil;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.BaseService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * @author Carlos Sierra
 */
@Component(immediate = true)
public class HotDeployTrackerComponent {

    private ServiceTracker<ServletContext, ServletContext> _serviceTracker;
    private MessageBus _messageBus;

    @Activate
    public void activate(final BundleContext bundleContext) {
        _serviceTracker = new ServiceTracker<ServletContext, ServletContext>(
            bundleContext, ServletContext.class,
            new ServletContextTrackerCustomizer());

        PortalLifecycleUtil.register(new PortalLifecycle() {
            @Override
            public void portalDestroy() {
                _serviceTracker.close();
            }

            @Override
            public void portalInit() {
                _serviceTracker.open();
            }
        });

        _messageBus.registerMessageListener(DestinationNames.HOT_DEPLOY,
            new MessageListener() {

                @Override
                public void receive(Message message)
                    throws MessageListenerException {

                    HotDeployUtil.registerListener(
                        new ServiceRegistratorHotDeployListener(bundleContext));

                    _messageBus.unregisterMessageListener(
                        DestinationNames.HOT_DEPLOY, this);
                }
            });
    }

    @Reference
    public void setPortalServletContext(MessageBus messageBus) {

        _messageBus = messageBus;
    }

    private ClassLoader _getClassLoader(Bundle bundle) {
        BundleWiring bundleWiring = bundle.adapt(BundleWiring.class);

        return bundleWiring.getClassLoader();
    }

    private ServletContext _portalServletContext;

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

            ServletContext servletContext = bundleContext.getService(
                serviceReference);

            HotDeployEvent hotDeployEvent = new OsgiBundleHotDeployEvent(
                servletContext, _getClassLoader(bundle));
            HotDeployUtil.fireDeployEvent(hotDeployEvent);

            bundleContext.ungetService(serviceReference);

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

            Bundle bundle = serviceReference.getBundle();

            BundleContext bundleContext = bundle.getBundleContext();

            HotDeployUtil.fireUndeployEvent(
                new OsgiBundleHotDeployEvent(
                    servletContext, _getClassLoader(bundle))
            );

            bundleContext.ungetService(serviceReference);
        }
    }

    public class ServiceRegistratorHotDeployListener
        implements HotDeployListener {

        private BundleContext _bundleContext;

        public ServiceRegistratorHotDeployListener(
            BundleContext bundleContext) {

            _bundleContext = bundleContext;
        }

        @Override
        public void invokeDeploy(HotDeployEvent event) throws HotDeployException {
            if (!(event instanceof OsgiBundleHotDeployEvent)) {
                return;
            }

            BeanLocator beanLocator = PortletBeanLocatorUtil.getBeanLocator(
                event.getServletContextName());

            Map<String,BaseService> servicesMap = beanLocator.locate(
                BaseService.class);

            for (Map.Entry<String, BaseService> serviceEntry :
                servicesMap.entrySet()) {

                BaseService value = serviceEntry.getValue();
                Class<? extends BaseService> valueClass = value.getClass();
                Class serviceInterface = (Class) valueClass.getInterfaces()[0];

                _bundleContext.registerService(
                    serviceInterface, serviceEntry.getValue(), null);
            }

            Map<String,BaseLocalService> localServicesMap = beanLocator.locate(
                BaseLocalService.class);

            for (Map.Entry<String, BaseLocalService> localServiceEntry :
                localServicesMap.entrySet()) {

                BaseLocalService value = localServiceEntry.getValue();
                Class<? extends BaseLocalService> valueClass = value.getClass();
                Class serviceInterface = (Class) valueClass.getInterfaces()[0];

                _bundleContext.registerService(
                    serviceInterface, localServiceEntry.getValue(), null);
            }

        }

        @Override
        public void invokeUndeploy(HotDeployEvent event)
            throws HotDeployException {

        }
    }

    public static class OsgiBundleHotDeployEvent extends HotDeployEvent {

        public OsgiBundleHotDeployEvent(
            ServletContext servletContext, ClassLoader contextClassLoader) {
            super(servletContext, contextClassLoader);
        }
    }
}