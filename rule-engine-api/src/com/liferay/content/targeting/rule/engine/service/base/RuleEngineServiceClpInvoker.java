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

package com.liferay.content.targeting.rule.engine.service.base;

import com.liferay.content.targeting.rule.engine.service.RuleEngineServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RuleEngineServiceClpInvoker {
	public RuleEngineServiceClpInvoker() {
		_methodName18 = "getBeanIdentifier";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "setBeanIdentifier";

		_methodParameterTypes19 = new String[] { "java.lang.String" };

		_methodName24 = "getMatchesUserSegmentIds";

		_methodParameterTypes24 = new String[] {
				"javax.servlet.http.HttpServletRequest", "long[][]", "long"
			};

		_methodName25 = "getMatchesUserSegmentIds";

		_methodParameterTypes25 = new String[] {
				"javax.servlet.http.HttpServletRequest", "long", "long"
			};

		_methodName26 = "matches";

		_methodParameterTypes26 = new String[] {
				"javax.servlet.http.HttpServletRequest", "long",
				"com.liferay.content.targeting.model.UserSegment"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return RuleEngineServiceUtil.getBeanIdentifier();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			RuleEngineServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return RuleEngineServiceUtil.getMatchesUserSegmentIds((javax.servlet.http.HttpServletRequest)arguments[0],
				(long[])arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return RuleEngineServiceUtil.getMatchesUserSegmentIds((javax.servlet.http.HttpServletRequest)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return RuleEngineServiceUtil.matches((javax.servlet.http.HttpServletRequest)arguments[0],
				((Long)arguments[1]).longValue(),
				(com.liferay.content.targeting.model.UserSegment)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
}