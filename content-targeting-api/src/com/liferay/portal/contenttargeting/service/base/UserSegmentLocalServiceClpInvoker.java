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

package com.liferay.portal.contenttargeting.service.base;

import com.liferay.portal.contenttargeting.service.UserSegmentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserSegmentLocalServiceClpInvoker {
	public UserSegmentLocalServiceClpInvoker() {
		_methodName0 = "addUserSegment";

		_methodParameterTypes0 = new String[] {
				"com.liferay.portal.contenttargeting.model.UserSegment"
			};

		_methodName1 = "createUserSegment";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteUserSegment";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteUserSegment";

		_methodParameterTypes3 = new String[] {
				"com.liferay.portal.contenttargeting.model.UserSegment"
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

		_methodName10 = "fetchUserSegment";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchUserSegmentByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchUserSegmentByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getUserSegment";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getUserSegmentByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getUserSegmentByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getUserSegments";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getUserSegmentsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateUserSegment";

		_methodParameterTypes19 = new String[] {
				"com.liferay.portal.contenttargeting.model.UserSegment"
			};

		_methodName20 = "addCampaignUserSegment";

		_methodParameterTypes20 = new String[] { "long", "long" };

		_methodName21 = "addCampaignUserSegment";

		_methodParameterTypes21 = new String[] {
				"long", "com.liferay.portal.contenttargeting.model.UserSegment"
			};

		_methodName22 = "addCampaignUserSegments";

		_methodParameterTypes22 = new String[] { "long", "long[][]" };

		_methodName23 = "addCampaignUserSegments";

		_methodParameterTypes23 = new String[] { "long", "java.util.List" };

		_methodName24 = "clearCampaignUserSegments";

		_methodParameterTypes24 = new String[] { "long" };

		_methodName25 = "deleteCampaignUserSegment";

		_methodParameterTypes25 = new String[] { "long", "long" };

		_methodName26 = "deleteCampaignUserSegment";

		_methodParameterTypes26 = new String[] {
				"long", "com.liferay.portal.contenttargeting.model.UserSegment"
			};

		_methodName27 = "deleteCampaignUserSegments";

		_methodParameterTypes27 = new String[] { "long", "long[][]" };

		_methodName28 = "deleteCampaignUserSegments";

		_methodParameterTypes28 = new String[] { "long", "java.util.List" };

		_methodName29 = "getCampaignUserSegments";

		_methodParameterTypes29 = new String[] { "long" };

		_methodName30 = "getCampaignUserSegments";

		_methodParameterTypes30 = new String[] { "long", "int", "int" };

		_methodName31 = "getCampaignUserSegments";

		_methodParameterTypes31 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName32 = "getCampaignUserSegmentsCount";

		_methodParameterTypes32 = new String[] { "long" };

		_methodName33 = "hasCampaignUserSegment";

		_methodParameterTypes33 = new String[] { "long", "long" };

		_methodName34 = "hasCampaignUserSegments";

		_methodParameterTypes34 = new String[] { "long" };

		_methodName35 = "setCampaignUserSegments";

		_methodParameterTypes35 = new String[] { "long", "long[][]" };

		_methodName80 = "getBeanIdentifier";

		_methodParameterTypes80 = new String[] {  };

		_methodName81 = "setBeanIdentifier";

		_methodParameterTypes81 = new String[] { "java.lang.String" };

		_methodName86 = "addUserSegment";

		_methodParameterTypes86 = new String[] {
				"long", "java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName87 = "deleteUserSegment";

		_methodParameterTypes87 = new String[] { "long" };

		_methodName88 = "getUserSegments";

		_methodParameterTypes88 = new String[] { "long" };

		_methodName89 = "getUserSegments";

		_methodParameterTypes89 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName90 = "getUserSegments";

		_methodParameterTypes90 = new String[] { "long[][]" };

		_methodName91 = "getUserSegments";

		_methodParameterTypes91 = new String[] {
				"long[][]", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName92 = "getUserSegmentsCount";

		_methodParameterTypes92 = new String[] { "long" };

		_methodName93 = "getUserSegmentsCount";

		_methodParameterTypes93 = new String[] { "long[][]" };

		_methodName94 = "search";

		_methodParameterTypes94 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName95 = "searchUserSegments";

		_methodParameterTypes95 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName96 = "updateUserSegment";

		_methodParameterTypes96 = new String[] {
				"long", "java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return UserSegmentLocalServiceUtil.addUserSegment((com.liferay.portal.contenttargeting.model.UserSegment)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return UserSegmentLocalServiceUtil.createUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return UserSegmentLocalServiceUtil.deleteUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return UserSegmentLocalServiceUtil.deleteUserSegment((com.liferay.portal.contenttargeting.model.UserSegment)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return UserSegmentLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return UserSegmentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return UserSegmentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return UserSegmentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return UserSegmentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return UserSegmentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return UserSegmentLocalServiceUtil.fetchUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return UserSegmentLocalServiceUtil.fetchUserSegmentByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return UserSegmentLocalServiceUtil.fetchUserSegmentByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegmentByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegmentByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegments(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegmentsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return UserSegmentLocalServiceUtil.updateUserSegment((com.liferay.portal.contenttargeting.model.UserSegment)arguments[0]);
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			UserSegmentLocalServiceUtil.addCampaignUserSegment(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			UserSegmentLocalServiceUtil.addCampaignUserSegment(((Long)arguments[0]).longValue(),
				(com.liferay.portal.contenttargeting.model.UserSegment)arguments[1]);

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			UserSegmentLocalServiceUtil.addCampaignUserSegments(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			UserSegmentLocalServiceUtil.addCampaignUserSegments(((Long)arguments[0]).longValue(),
				(java.util.List<com.liferay.portal.contenttargeting.model.UserSegment>)arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			UserSegmentLocalServiceUtil.clearCampaignUserSegments(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			UserSegmentLocalServiceUtil.deleteCampaignUserSegment(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			UserSegmentLocalServiceUtil.deleteCampaignUserSegment(((Long)arguments[0]).longValue(),
				(com.liferay.portal.contenttargeting.model.UserSegment)arguments[1]);

			return null;
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			UserSegmentLocalServiceUtil.deleteCampaignUserSegments(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			UserSegmentLocalServiceUtil.deleteCampaignUserSegments(((Long)arguments[0]).longValue(),
				(java.util.List<com.liferay.portal.contenttargeting.model.UserSegment>)arguments[1]);

			return null;
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getCampaignUserSegments(((Long)arguments[0]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getCampaignUserSegments(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getCampaignUserSegments(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getCampaignUserSegmentsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return UserSegmentLocalServiceUtil.hasCampaignUserSegment(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return UserSegmentLocalServiceUtil.hasCampaignUserSegments(((Long)arguments[0]).longValue());
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			UserSegmentLocalServiceUtil.setCampaignUserSegments(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			UserSegmentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return UserSegmentLocalServiceUtil.addUserSegment(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return UserSegmentLocalServiceUtil.deleteUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegments(((Long)arguments[0]).longValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegments(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegments((long[])arguments[0]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegments((long[])arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegmentsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegmentsCount((long[])arguments[0]);
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return UserSegmentLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return UserSegmentLocalServiceUtil.searchUserSegments(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return UserSegmentLocalServiceUtil.updateUserSegment(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
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
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
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
}