package com.liferay.consumer.manager.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ConsumerExtensionInstance service. Represents a row in the &quot;CM_ConsumerExtensionInstance&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstanceModel
 * @see com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceImpl
 * @see com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl
 * @generated
 */
public interface ConsumerExtensionInstance
    extends ConsumerExtensionInstanceModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public java.lang.String getConsumerExtensionGuid();

    public java.util.Map<java.lang.String, java.lang.String> getValues();

    public void setConsumerExtensionGuid(java.lang.String consumerExtensionGuid);

    public void setValues(
        java.util.Map<java.lang.String, java.lang.String> values);
}
