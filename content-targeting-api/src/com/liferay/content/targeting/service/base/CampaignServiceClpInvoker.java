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

import com.liferay.content.targeting.service.CampaignServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CampaignServiceClpInvoker {
	public CampaignServiceClpInvoker() {
		_methodName48 = "getBeanIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "setBeanIdentifier";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName54 = "addCampaign";

		_methodParameterTypes54 = new String[] {
				"long", "java.util.Map", "java.util.Map", "java.util.Date",
				"java.util.Date", "int", "boolean", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName55 = "deleteCampaign";

		_methodParameterTypes55 = new String[] { "long" };

		_methodName56 = "fetchCurrentMaxPriorityCampaign";

		_methodParameterTypes56 = new String[] { "long[][]", "long[][]" };

		_methodName57 = "getCampaigns";

		_methodParameterTypes57 = new String[] { "long" };

		_methodName58 = "getCampaignsCount";

		_methodParameterTypes58 = new String[] { "long" };

		_methodName59 = "updateCampaign";

		_methodParameterTypes59 = new String[] {
				"long", "java.util.Map", "java.util.Map", "java.util.Date",
				"java.util.Date", "int", "boolean", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return CampaignServiceUtil.getBeanIdentifier();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			CampaignServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return CampaignServiceUtil.addCampaign(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Boolean)arguments[6]).booleanValue(), (long[])arguments[7],
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return CampaignServiceUtil.deleteCampaign(((Long)arguments[0]).longValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return CampaignServiceUtil.fetchCurrentMaxPriorityCampaign((long[])arguments[0],
				(long[])arguments[1]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return CampaignServiceUtil.getCampaigns(((Long)arguments[0]).longValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return CampaignServiceUtil.getCampaignsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return CampaignServiceUtil.updateCampaign(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Boolean)arguments[6]).booleanValue(), (long[])arguments[7],
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
}