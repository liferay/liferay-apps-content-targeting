package com.liferay.consumer.manager.service.persistence;

import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.service.ConsumerLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ConsumerActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ConsumerActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ConsumerLocalServiceUtil.getService());
        setClass(Consumer.class);

        setClassLoader(com.liferay.consumer.manager.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("consumerId");
    }
}
