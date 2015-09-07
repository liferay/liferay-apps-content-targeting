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

import com.liferay.content.targeting.service.AnonymousUserUserSegmentServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AnonymousUserUserSegmentServiceClpInvoker {
	public AnonymousUserUserSegmentServiceClpInvoker() {
		_methodName66 = "getBeanIdentifier";

		_methodParameterTypes66 = new String[] {  };

		_methodName67 = "setBeanIdentifier";

		_methodParameterTypes67 = new String[] { "java.lang.String" };

		_methodName72 = "addAnonymousUserUserSegment";

		_methodParameterTypes72 = new String[] {
				"long", "long", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName73 = "getAnonymousUsersByUserSegmentId";

		_methodParameterTypes73 = new String[] {
				"long", "boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName74 = "getAnonymousUsersByUserSegmentIdCount";

		_methodParameterTypes74 = new String[] {
				"long", "boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName75 = "getAnonymousUsersByUserSegmentIds";

		_methodParameterTypes75 = new String[] {
				"long[][]", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName76 = "getAnonymousUsersByUserSegmentIdsCount";

		_methodParameterTypes76 = new String[] {
				"long[][]", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName77 = "getUserSegmentsByAnonymousUserId";

		_methodParameterTypes77 = new String[] {
				"long", "boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName78 = "getUserSegmentsByAnonymousUserIdCount";

		_methodParameterTypes78 = new String[] {
				"long", "boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName79 = "updateAnonymousUserUserSegment";

		_methodParameterTypes79 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return AnonymousUserUserSegmentServiceUtil.getBeanIdentifier();
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			AnonymousUserUserSegmentServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return AnonymousUserUserSegmentServiceUtil.addAnonymousUserUserSegment(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Boolean)arguments[3]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return AnonymousUserUserSegmentServiceUtil.getAnonymousUsersByUserSegmentId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return AnonymousUserUserSegmentServiceUtil.getAnonymousUsersByUserSegmentIdCount(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return AnonymousUserUserSegmentServiceUtil.getAnonymousUsersByUserSegmentIds((long[])arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return AnonymousUserUserSegmentServiceUtil.getAnonymousUsersByUserSegmentIdsCount((long[])arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return AnonymousUserUserSegmentServiceUtil.getUserSegmentsByAnonymousUserId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return AnonymousUserUserSegmentServiceUtil.getUserSegmentsByAnonymousUserIdCount(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return AnonymousUserUserSegmentServiceUtil.updateAnonymousUserUserSegment(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
}