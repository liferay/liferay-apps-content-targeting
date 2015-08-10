package com.liferay.consumer.manager.service.messaging;

import com.liferay.consumer.manager.service.ClpSerializer;
import com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalServiceUtil;
import com.liferay.consumer.manager.service.ConsumerExtensionInstanceServiceUtil;
import com.liferay.consumer.manager.service.ConsumerLocalServiceUtil;
import com.liferay.consumer.manager.service.ConsumerServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ConsumerLocalServiceUtil.clearService();

            ConsumerServiceUtil.clearService();
            ConsumerExtensionInstanceLocalServiceUtil.clearService();

            ConsumerExtensionInstanceServiceUtil.clearService();
        }
    }
}
