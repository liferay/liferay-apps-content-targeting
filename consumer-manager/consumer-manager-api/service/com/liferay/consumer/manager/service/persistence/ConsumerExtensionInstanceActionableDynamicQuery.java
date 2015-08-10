package com.liferay.consumer.manager.service.persistence;

import com.liferay.consumer.manager.model.ConsumerExtensionInstance;
import com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ConsumerExtensionInstanceActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ConsumerExtensionInstanceActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(ConsumerExtensionInstanceLocalServiceUtil.getService());
        setClass(ConsumerExtensionInstance.class);

        setClassLoader(com.liferay.consumer.manager.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("consumerExtensionInstanceId");
    }
}
