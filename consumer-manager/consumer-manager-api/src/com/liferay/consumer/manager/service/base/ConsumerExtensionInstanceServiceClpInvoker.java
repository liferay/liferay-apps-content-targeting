package com.liferay.consumer.manager.service.base;

import com.liferay.consumer.manager.service.ConsumerExtensionInstanceServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConsumerExtensionInstanceServiceClpInvoker {
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName34;
    private String[] _methodParameterTypes34;

    public ConsumerExtensionInstanceServiceClpInvoker() {
        _methodName24 = "getBeanIdentifier";

        _methodParameterTypes24 = new String[] {  };

        _methodName25 = "setBeanIdentifier";

        _methodParameterTypes25 = new String[] { "java.lang.String" };

        _methodName30 = "addConsumerExtensionInstance";

        _methodParameterTypes30 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName31 = "deleteConsumerExtensionInstance";

        _methodParameterTypes31 = new String[] { "long" };

        _methodName32 = "getConsumerExtensionInstance";

        _methodParameterTypes32 = new String[] { "long", "java.lang.String" };

        _methodName33 = "getConsumerExtensionInstances";

        _methodParameterTypes33 = new String[] { "long" };

        _methodName34 = "updateConsumerExtensionInstance";

        _methodParameterTypes34 = new String[] {
                "long", "java.lang.String", "long", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return ConsumerExtensionInstanceServiceUtil.getBeanIdentifier();
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            ConsumerExtensionInstanceServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return ConsumerExtensionInstanceServiceUtil.addConsumerExtensionInstance((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            return ConsumerExtensionInstanceServiceUtil.deleteConsumerExtensionInstance(((Long) arguments[0]).longValue());
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            return ConsumerExtensionInstanceServiceUtil.getConsumerExtensionInstance(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            return ConsumerExtensionInstanceServiceUtil.getConsumerExtensionInstances(((Long) arguments[0]).longValue());
        }

        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
            return ConsumerExtensionInstanceServiceUtil.updateConsumerExtensionInstance(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3],
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        throw new UnsupportedOperationException();
    }
}
