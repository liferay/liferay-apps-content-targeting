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

import com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AnonymousUserUserSegmentLocalServiceClpInvoker {
	public AnonymousUserUserSegmentLocalServiceClpInvoker() {
		_methodName0 = "addAnonymousUserUserSegment";

		_methodParameterTypes0 = new String[] {
				"com.liferay.content.targeting.model.AnonymousUserUserSegment"
			};

		_methodName1 = "createAnonymousUserUserSegment";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteAnonymousUserUserSegment";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteAnonymousUserUserSegment";

		_methodParameterTypes3 = new String[] {
				"com.liferay.content.targeting.model.AnonymousUserUserSegment"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchAnonymousUserUserSegment";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getAnonymousUserUserSegment";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getAnonymousUserUserSegments";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getAnonymousUserUserSegmentsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateAnonymousUserUserSegment";

		_methodParameterTypes15 = new String[] {
				"com.liferay.content.targeting.model.AnonymousUserUserSegment"
			};

		_methodName82 = "getBeanIdentifier";

		_methodParameterTypes82 = new String[] {  };

		_methodName83 = "setBeanIdentifier";

		_methodParameterTypes83 = new String[] { "java.lang.String" };

		_methodName88 = "addAnonymousUserUserSegment";

		_methodParameterTypes88 = new String[] {
				"long", "long", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName89 = "checkAnonymousUserUserSegments";

		_methodParameterTypes89 = new String[] {  };

		_methodName90 = "getAnonymousUsersByUserSegmentId";

		_methodParameterTypes90 = new String[] { "long", "boolean" };

		_methodName91 = "getAnonymousUsersByUserSegmentIdCount";

		_methodParameterTypes91 = new String[] { "long", "boolean" };

		_methodName92 = "getAnonymousUsersByUserSegmentIds";

		_methodParameterTypes92 = new String[] { "long[][]", "boolean" };

		_methodName93 = "getAnonymousUsersByUserSegmentIdsCount";

		_methodParameterTypes93 = new String[] { "long[][]", "boolean" };

		_methodName94 = "getAnonymousUserUserSegments";

		_methodParameterTypes94 = new String[] { "long", "long" };

		_methodName95 = "getMaxAge";

		_methodParameterTypes95 = new String[] {  };

		_methodName96 = "getUserSegmentsByAnonymousUserId";

		_methodParameterTypes96 = new String[] { "long", "boolean" };

		_methodName97 = "getUserSegmentsByAnonymousUserIdCount";

		_methodParameterTypes97 = new String[] { "long", "boolean" };

		_methodName98 = "updateAnonymousUserUserSegment";

		_methodParameterTypes98 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName99 = "updateAnonymousUserUserSegments";

		_methodParameterTypes99 = new String[] { "long", "java.util.Date" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.addAnonymousUserUserSegment((com.liferay.content.targeting.model.AnonymousUserUserSegment)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.createAnonymousUserUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.deleteAnonymousUserUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.deleteAnonymousUserUserSegment((com.liferay.content.targeting.model.AnonymousUserUserSegment)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.fetchAnonymousUserUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getAnonymousUserUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getAnonymousUserUserSegments(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getAnonymousUserUserSegmentsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.updateAnonymousUserUserSegment((com.liferay.content.targeting.model.AnonymousUserUserSegment)arguments[0]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			AnonymousUserUserSegmentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.addAnonymousUserUserSegment(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Boolean)arguments[3]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			AnonymousUserUserSegmentLocalServiceUtil.checkAnonymousUserUserSegments();

			return null;
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getAnonymousUsersByUserSegmentId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getAnonymousUsersByUserSegmentIdCount(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getAnonymousUsersByUserSegmentIds((long[])arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getAnonymousUsersByUserSegmentIdsCount((long[])arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getAnonymousUserUserSegments(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getMaxAge();
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getUserSegmentsByAnonymousUserId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.getUserSegmentsByAnonymousUserIdCount(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return AnonymousUserUserSegmentLocalServiceUtil.updateAnonymousUserUserSegment(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			AnonymousUserUserSegmentLocalServiceUtil.updateAnonymousUserUserSegments(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
}