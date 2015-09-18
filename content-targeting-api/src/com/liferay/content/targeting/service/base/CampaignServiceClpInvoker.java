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
		_methodName72 = "getBeanIdentifier";

		_methodParameterTypes72 = new String[] {  };

		_methodName73 = "setBeanIdentifier";

		_methodParameterTypes73 = new String[] { "java.lang.String" };

		_methodName78 = "addCampaign";

		_methodParameterTypes78 = new String[] {
				"long", "java.util.Map", "java.util.Map", "java.util.Date",
				"java.util.Date", "int", "boolean", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName79 = "addCampaign";

		_methodParameterTypes79 = new String[] {
				"long", "java.util.Map", "java.util.Map", "java.util.Date",
				"java.util.Date", "java.lang.String", "int", "boolean",
				"long[][]", "com.liferay.portal.service.ServiceContext"
			};

		_methodName80 = "deleteCampaign";

		_methodParameterTypes80 = new String[] { "long" };

		_methodName81 = "fetchCurrentMaxPriorityCampaign";

		_methodParameterTypes81 = new String[] { "long[][]", "long[][]" };

		_methodName82 = "getCampaigns";

		_methodParameterTypes82 = new String[] { "long" };

		_methodName83 = "getCampaignsCount";

		_methodParameterTypes83 = new String[] { "long" };

		_methodName84 = "updateCampaign";

		_methodParameterTypes84 = new String[] {
				"long", "java.util.Map", "java.util.Map", "java.util.Date",
				"java.util.Date", "int", "boolean", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName85 = "updateCampaign";

		_methodParameterTypes85 = new String[] {
				"long", "java.util.Map", "java.util.Map", "java.util.Date",
				"java.util.Date", "java.lang.String", "int", "boolean",
				"long[][]", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return CampaignServiceUtil.getBeanIdentifier();
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			CampaignServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return CampaignServiceUtil.addCampaign(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Boolean)arguments[6]).booleanValue(), (long[])arguments[7],
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return CampaignServiceUtil.addCampaign(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				(java.lang.String)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Boolean)arguments[7]).booleanValue(), (long[])arguments[8],
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return CampaignServiceUtil.deleteCampaign(((Long)arguments[0]).longValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return CampaignServiceUtil.fetchCurrentMaxPriorityCampaign((long[])arguments[0],
				(long[])arguments[1]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return CampaignServiceUtil.getCampaigns(((Long)arguments[0]).longValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return CampaignServiceUtil.getCampaignsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return CampaignServiceUtil.updateCampaign(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Boolean)arguments[6]).booleanValue(), (long[])arguments[7],
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return CampaignServiceUtil.updateCampaign(((Long)arguments[0]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[1],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				(java.lang.String)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Boolean)arguments[7]).booleanValue(), (long[])arguments[8],
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
}