package com.liferay.consumer.manager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConsumerExtensionInstanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstanceService
 * @generated
 */
public class ConsumerExtensionInstanceServiceWrapper
    implements ConsumerExtensionInstanceService,
        ServiceWrapper<ConsumerExtensionInstanceService> {
    private ConsumerExtensionInstanceService _consumerExtensionInstanceService;

    public ConsumerExtensionInstanceServiceWrapper(
        ConsumerExtensionInstanceService consumerExtensionInstanceService) {
        _consumerExtensionInstanceService = consumerExtensionInstanceService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _consumerExtensionInstanceService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _consumerExtensionInstanceService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _consumerExtensionInstanceService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.liferay.consumer.manager.model.ConsumerExtensionInstance addConsumerExtensionInstance(
        java.lang.String consumerExtensionKey, long consumerId,
        java.lang.String typeSettings,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _consumerExtensionInstanceService.addConsumerExtensionInstance(consumerExtensionKey,
            consumerId, typeSettings, serviceContext);
    }

    @Override
    public com.liferay.consumer.manager.model.ConsumerExtensionInstance deleteConsumerExtensionInstance(
        long consumerExtensionInstanceId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _consumerExtensionInstanceService.deleteConsumerExtensionInstance(consumerExtensionInstanceId);
    }

    @Override
    public com.liferay.consumer.manager.model.ConsumerExtensionInstance getConsumerExtensionInstance(
        long consumerId, java.lang.String consumerExtensionKey)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _consumerExtensionInstanceService.getConsumerExtensionInstance(consumerId,
            consumerExtensionKey);
    }

    @Override
    public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> getConsumerExtensionInstances(
        long consumerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _consumerExtensionInstanceService.getConsumerExtensionInstances(consumerId);
    }

    @Override
    public com.liferay.consumer.manager.model.ConsumerExtensionInstance updateConsumerExtensionInstance(
        long consumerExtensionInstanceId,
        java.lang.String consumerExtensionKey, long consumerId,
        java.lang.String typeSettings,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _consumerExtensionInstanceService.updateConsumerExtensionInstance(consumerExtensionInstanceId,
            consumerExtensionKey, consumerId, typeSettings, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ConsumerExtensionInstanceService getWrappedConsumerExtensionInstanceService() {
        return _consumerExtensionInstanceService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedConsumerExtensionInstanceService(
        ConsumerExtensionInstanceService consumerExtensionInstanceService) {
        _consumerExtensionInstanceService = consumerExtensionInstanceService;
    }

    @Override
    public ConsumerExtensionInstanceService getWrappedService() {
        return _consumerExtensionInstanceService;
    }

    @Override
    public void setWrappedService(
        ConsumerExtensionInstanceService consumerExtensionInstanceService) {
        _consumerExtensionInstanceService = consumerExtensionInstanceService;
    }
}
