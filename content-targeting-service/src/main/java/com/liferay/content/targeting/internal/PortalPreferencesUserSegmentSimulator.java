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

package com.liferay.content.targeting.internal;

import com.liferay.content.targeting.api.model.UserSegmentSimulator;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 */
@Component
public class PortalPreferencesUserSegmentSimulator
	implements UserSegmentSimulator {

	@Override
	public void addUserSegmentId(
		long userSegmentId, HttpServletRequest request,
		HttpServletResponse response) {

		long userId = PortalUtil.getUserId(request);

		String simulatorSessionId = request.getParameter(_SIMULATOR_SESSION_ID);

		if (Validator.isNull(simulatorSessionId)) {
			return;
		}

		while (true) {
			try {
				PortalPreferences portalPreferences = getPortalPreferences(
					userId);

				String[] simulatedUserSegmentIds = portalPreferences.getValues(
					"content-targeting",
					simulatorSessionId + "simulatedUserSegmentIds",
					new String[0]);

				simulatedUserSegmentIds = ArrayUtil.append(
					simulatedUserSegmentIds, String.valueOf(userSegmentId));

				portalPreferences.setValues(
					"content-targeting",
					simulatorSessionId + "simulatedUserSegmentIds",
					simulatedUserSegmentIds);
				portalPreferences.setValue(
					"content-targeting",
					simulatorSessionId + "simulation", String.valueOf(true));

				break;
			}
			catch (ConcurrentModificationException cme) {
				continue;
			}
			catch (Exception e) {
				_log.error(e, e);

				break;
			}
		}
	}

	@Override
	public long[] getUserSegmentIds(
		HttpServletRequest request, HttpServletResponse response) {

		long userId = PortalUtil.getUserId(request);

		String simulatorSessionId = request.getParameter(_SIMULATOR_SESSION_ID);

		if (Validator.isNull(simulatorSessionId)) {
			return null;
		}

		PortalPreferences portalPreferences = getPortalPreferences(userId);

		boolean simulation = GetterUtil.getBoolean(
			portalPreferences.getValue(
				"content-targeting", simulatorSessionId + "simulation"));

		if (!simulation) {
			return null;
		}

		return getLongArray(
			portalPreferences.getValues(
				"content-targeting",
				simulatorSessionId + "simulatedUserSegmentIds", new String[0]));
	}

	@Override
	public void removeAllUserSegmentIds(
		HttpServletRequest request, HttpServletResponse response) {

		long userId = PortalUtil.getUserId(request);

		String simulatorSessionId = request.getParameter(_SIMULATOR_SESSION_ID);

		if (Validator.isNull(simulatorSessionId)) {
			return;
		}

		while (true) {
			try {
				PortalPreferences portalPreferences = getPortalPreferences(
					userId);

				portalPreferences.setValues(
					"content-targeting",
					simulatorSessionId + "simulatedUserSegmentIds", null);
				portalPreferences.setValue(
					"content-targeting",
					simulatorSessionId + "simulation", null);

				break;
			}
			catch (ConcurrentModificationException cme) {
				continue;
			}
			catch (Exception e) {
				_log.error(e, e);

				break;
			}
		}
	}

	@Override
	public void removeUserSegmentId(
		long userSegmentId, HttpServletRequest request,
		HttpServletResponse response) {

		long userId = PortalUtil.getUserId(request);

		String simulatorSessionId = request.getParameter(_SIMULATOR_SESSION_ID);

		if (Validator.isNull(simulatorSessionId)) {
			return;
		}

		while (true) {
			try {
				PortalPreferences portalPreferences = getPortalPreferences(
					userId);

				String[] simulatedUserSegmentIds = portalPreferences.getValues(
					"content-targeting",
					simulatorSessionId + "simulatedUserSegmentIds",
					new String[0]);

				simulatedUserSegmentIds = ArrayUtil.remove(
					simulatedUserSegmentIds, String.valueOf(userSegmentId));

				portalPreferences.setValues(
					"content-targeting",
					simulatorSessionId + "simulatedUserSegmentIds",
					simulatedUserSegmentIds);

				if (simulatedUserSegmentIds.length == 0) {
					portalPreferences.setValue(
						"content-targeting", simulatorSessionId + "simulation",
						null);
				}

				break;
			}
			catch (ConcurrentModificationException cme) {
				continue;
			}
			catch (Exception e) {
				_log.error(e, e);

				break;
			}
		}
	}

	@Override
	public void setUserSegmentIds(
		long[] userSegmentIds, HttpServletRequest request,
		HttpServletResponse response) {

		long userId = PortalUtil.getUserId(request);

		String simulatorSessionId = request.getParameter(_SIMULATOR_SESSION_ID);

		if (Validator.isNull(simulatorSessionId)) {
			return;
		}

		while (true) {
			try {
				PortalPreferences portalPreferences = getPortalPreferences(
					userId);

				portalPreferences.setValues(
					"content-targeting",
					simulatorSessionId + "simulatedUserSegmentIds",
					ArrayUtil.toStringArray(userSegmentIds));
				portalPreferences.setValue(
					"content-targeting",
					simulatorSessionId + "simulation", String.valueOf(true));

				break;
			}
			catch (ConcurrentModificationException cme) {
				continue;
			}
			catch (Exception e) {
				_log.error(e, e);

				break;
			}
		}
	}

	protected long[] getLongArray(String[] array) {
		if (array == null) {
			return null;
		}

		List<Long> values = new ArrayList<>();

		for (String string : array) {
			long value = GetterUtil.getLong(string);

			if (value > 0) {
				values.add(value);
			}
		}

		return ArrayUtil.toLongArray(values);
	}

	protected PortalPreferences getPortalPreferences(long userId) {
		try {
			return PortletPreferencesFactoryUtil.getPortalPreferences(
				null, userId, userId > 0);
		}
		catch (SystemException se) {
			se.printStackTrace();
		}

		return null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PortalPreferencesUserSegmentSimulator.class);
	private static final String _SIMULATOR_SESSION_ID = "simulatorSessionId";
}