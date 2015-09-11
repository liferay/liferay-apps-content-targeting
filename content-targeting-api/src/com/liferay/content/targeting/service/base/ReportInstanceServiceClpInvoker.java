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

package com.liferay.content.targeting.service.base;

import com.liferay.content.targeting.service.ReportInstanceServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReportInstanceServiceClpInvoker {
	public ReportInstanceServiceClpInvoker() {
		_methodName62 = "getBeanIdentifier";

		_methodParameterTypes62 = new String[] {  };

		_methodName63 = "setBeanIdentifier";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName68 = "addReportInstance";

		_methodParameterTypes68 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"java.util.Map", "java.util.Map", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName69 = "addReportInstance";

		_methodParameterTypes69 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName70 = "fetchReportInstance";

		_methodParameterTypes70 = new String[] { "long" };

		_methodName71 = "fetchReportInstance";

		_methodParameterTypes71 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName72 = "findReportInstances";

		_methodParameterTypes72 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName73 = "getReportInstances";

		_methodParameterTypes73 = new String[] { "java.lang.String", "long" };

		_methodName74 = "updateReportInstance";

		_methodParameterTypes74 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "long",
				"java.util.Map", "java.util.Map", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName75 = "updateReportInstance";

		_methodParameterTypes75 = new String[] {
				"com.liferay.content.targeting.model.ReportInstance"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return ReportInstanceServiceUtil.getBeanIdentifier();
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			ReportInstanceServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return ReportInstanceServiceUtil.addReportInstance(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[4],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(java.lang.String)arguments[6],
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return ReportInstanceServiceUtil.addReportInstance(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4],
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return ReportInstanceServiceUtil.fetchReportInstance(((Long)arguments[0]).longValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return ReportInstanceServiceUtil.fetchReportInstance((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return ReportInstanceServiceUtil.findReportInstances((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return ReportInstanceServiceUtil.getReportInstances((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return ReportInstanceServiceUtil.updateReportInstance(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[6],
				(java.lang.String)arguments[7],
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return ReportInstanceServiceUtil.updateReportInstance((com.liferay.content.targeting.model.ReportInstance)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
}