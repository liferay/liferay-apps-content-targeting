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

import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserSegmentLocalServiceClpInvoker {
	public UserSegmentLocalServiceClpInvoker() {
		_methodName0 = "addUserSegment";

		_methodParameterTypes0 = new String[] {
				"com.liferay.content.targeting.model.UserSegment"
			};

		_methodName1 = "createUserSegment";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteUserSegment";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteUserSegment";

		_methodParameterTypes3 = new String[] {
				"com.liferay.content.targeting.model.UserSegment"
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
				"com.liferay.content.targeting.model.UserSegment"
			};

		_methodName20 = "addCampaignUserSegment";

		_methodParameterTypes20 = new String[] { "long", "long" };

		_methodName21 = "addCampaignUserSegment";

		_methodParameterTypes21 = new String[] {
				"long", "com.liferay.content.targeting.model.UserSegment"
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
				"long", "com.liferay.content.targeting.model.UserSegment"
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

		_methodName36 = "addTacticUserSegment";

		_methodParameterTypes36 = new String[] { "long", "long" };

		_methodName37 = "addTacticUserSegment";

		_methodParameterTypes37 = new String[] {
				"long", "com.liferay.content.targeting.model.UserSegment"
			};

		_methodName38 = "addTacticUserSegments";

		_methodParameterTypes38 = new String[] { "long", "long[][]" };

		_methodName39 = "addTacticUserSegments";

		_methodParameterTypes39 = new String[] { "long", "java.util.List" };

		_methodName40 = "clearTacticUserSegments";

		_methodParameterTypes40 = new String[] { "long" };

		_methodName41 = "deleteTacticUserSegment";

		_methodParameterTypes41 = new String[] { "long", "long" };

		_methodName42 = "deleteTacticUserSegment";

		_methodParameterTypes42 = new String[] {
				"long", "com.liferay.content.targeting.model.UserSegment"
			};

		_methodName43 = "deleteTacticUserSegments";

		_methodParameterTypes43 = new String[] { "long", "long[][]" };

		_methodName44 = "deleteTacticUserSegments";

		_methodParameterTypes44 = new String[] { "long", "java.util.List" };

		_methodName45 = "getTacticUserSegments";

		_methodParameterTypes45 = new String[] { "long" };

		_methodName46 = "getTacticUserSegments";

		_methodParameterTypes46 = new String[] { "long", "int", "int" };

		_methodName47 = "getTacticUserSegments";

		_methodParameterTypes47 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName48 = "getTacticUserSegmentsCount";

		_methodParameterTypes48 = new String[] { "long" };

		_methodName49 = "hasTacticUserSegment";

		_methodParameterTypes49 = new String[] { "long", "long" };

		_methodName50 = "hasTacticUserSegments";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "setTacticUserSegments";

		_methodParameterTypes51 = new String[] { "long", "long[][]" };

		_methodName118 = "getBeanIdentifier";

		_methodParameterTypes118 = new String[] {  };

		_methodName119 = "setBeanIdentifier";

		_methodParameterTypes119 = new String[] { "java.lang.String" };

		_methodName124 = "addUserSegment";

		_methodParameterTypes124 = new String[] {
				"long", "java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName125 = "addUserSegmentResources";

		_methodParameterTypes125 = new String[] {
				"com.liferay.content.targeting.model.UserSegment", "boolean",
				"boolean"
			};

		_methodName126 = "addUserSegmentResources";

		_methodParameterTypes126 = new String[] {
				"com.liferay.content.targeting.model.UserSegment",
				"java.lang.String[][]", "java.lang.String[][]"
			};

		_methodName127 = "deleteUserSegment";

		_methodParameterTypes127 = new String[] { "long" };

		_methodName128 = "deleteUserSegment";

		_methodParameterTypes128 = new String[] {
				"com.liferay.content.targeting.model.UserSegment"
			};

		_methodName129 = "deleteUserSegments";

		_methodParameterTypes129 = new String[] { "long" };

		_methodName130 = "fetchUserSegmentByAssetCategoryId";

		_methodParameterTypes130 = new String[] { "long" };

		_methodName131 = "getUserSegments";

		_methodParameterTypes131 = new String[] { "long" };

		_methodName132 = "getUserSegments";

		_methodParameterTypes132 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName133 = "getUserSegments";

		_methodParameterTypes133 = new String[] { "long[][]" };

		_methodName134 = "getUserSegments";

		_methodParameterTypes134 = new String[] {
				"long[][]", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName135 = "getUserSegmentsCount";

		_methodParameterTypes135 = new String[] { "long" };

		_methodName136 = "getUserSegmentsCount";

		_methodParameterTypes136 = new String[] { "long[][]" };

		_methodName137 = "search";

		_methodParameterTypes137 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName138 = "searchUserSegments";

		_methodParameterTypes138 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName139 = "updateUserSegment";

		_methodParameterTypes139 = new String[] {
				"long", "java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName140 = "updateUserSegmentResources";

		_methodParameterTypes140 = new String[] {
				"com.liferay.content.targeting.model.UserSegment",
				"java.lang.String[][]", "java.lang.String[][]"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return UserSegmentLocalServiceUtil.addUserSegment((com.liferay.content.targeting.model.UserSegment)arguments[0]);
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
			return UserSegmentLocalServiceUtil.deleteUserSegment((com.liferay.content.targeting.model.UserSegment)arguments[0]);
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
			return UserSegmentLocalServiceUtil.updateUserSegment((com.liferay.content.targeting.model.UserSegment)arguments[0]);
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
				(com.liferay.content.targeting.model.UserSegment)arguments[1]);

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
				(java.util.List<com.liferay.content.targeting.model.UserSegment>)arguments[1]);

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
				(com.liferay.content.targeting.model.UserSegment)arguments[1]);

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
				(java.util.List<com.liferay.content.targeting.model.UserSegment>)arguments[1]);

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

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			UserSegmentLocalServiceUtil.addTacticUserSegment(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			UserSegmentLocalServiceUtil.addTacticUserSegment(((Long)arguments[0]).longValue(),
				(com.liferay.content.targeting.model.UserSegment)arguments[1]);

			return null;
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			UserSegmentLocalServiceUtil.addTacticUserSegments(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			UserSegmentLocalServiceUtil.addTacticUserSegments(((Long)arguments[0]).longValue(),
				(java.util.List<com.liferay.content.targeting.model.UserSegment>)arguments[1]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			UserSegmentLocalServiceUtil.clearTacticUserSegments(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			UserSegmentLocalServiceUtil.deleteTacticUserSegment(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			UserSegmentLocalServiceUtil.deleteTacticUserSegment(((Long)arguments[0]).longValue(),
				(com.liferay.content.targeting.model.UserSegment)arguments[1]);

			return null;
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			UserSegmentLocalServiceUtil.deleteTacticUserSegments(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			UserSegmentLocalServiceUtil.deleteTacticUserSegments(((Long)arguments[0]).longValue(),
				(java.util.List<com.liferay.content.targeting.model.UserSegment>)arguments[1]);

			return null;
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getTacticUserSegments(((Long)arguments[0]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getTacticUserSegments(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getTacticUserSegments(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getTacticUserSegmentsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return UserSegmentLocalServiceUtil.hasTacticUserSegment(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return UserSegmentLocalServiceUtil.hasTacticUserSegments(((Long)arguments[0]).longValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			UserSegmentLocalServiceUtil.setTacticUserSegments(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			UserSegmentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return UserSegmentLocalServiceUtil.addUserSegment(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			UserSegmentLocalServiceUtil.addUserSegmentResources((com.liferay.content.targeting.model.UserSegment)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				((Boolean)arguments[2]).booleanValue());

			return null;
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			UserSegmentLocalServiceUtil.addUserSegmentResources((com.liferay.content.targeting.model.UserSegment)arguments[0],
				(java.lang.String[])arguments[1],
				(java.lang.String[])arguments[2]);

			return null;
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return UserSegmentLocalServiceUtil.deleteUserSegment(((Long)arguments[0]).longValue());
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return UserSegmentLocalServiceUtil.deleteUserSegment((com.liferay.content.targeting.model.UserSegment)arguments[0]);
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			UserSegmentLocalServiceUtil.deleteUserSegments(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return UserSegmentLocalServiceUtil.fetchUserSegmentByAssetCategoryId(((Long)arguments[0]).longValue());
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegments(((Long)arguments[0]).longValue());
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegments(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegments((long[])arguments[0]);
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegments((long[])arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegmentsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return UserSegmentLocalServiceUtil.getUserSegmentsCount((long[])arguments[0]);
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return UserSegmentLocalServiceUtil.search(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return UserSegmentLocalServiceUtil.searchUserSegments(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return UserSegmentLocalServiceUtil.updateUserSegment(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			UserSegmentLocalServiceUtil.updateUserSegmentResources((com.liferay.content.targeting.model.UserSegment)arguments[0],
				(java.lang.String[])arguments[1],
				(java.lang.String[])arguments[2]);

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
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
	private String _methodName128;
	private String[] _methodParameterTypes128;
	private String _methodName129;
	private String[] _methodParameterTypes129;
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
	private String _methodName134;
	private String[] _methodParameterTypes134;
	private String _methodName135;
	private String[] _methodParameterTypes135;
	private String _methodName136;
	private String[] _methodParameterTypes136;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName138;
	private String[] _methodParameterTypes138;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName140;
	private String[] _methodParameterTypes140;
}