/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.model.impl;

import com.liferay.contenttargeting.api.model.RulesEngine;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.UserSegmentLocalServiceUtil;
import com.liferay.osgi.util.OsgiServiceUnavailableException;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The extended model implementation for the CTUser service. Represents a row in the &quot;CT_CTUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.model.CTUser} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class CTUserImpl extends CTUserBaseImpl {

	public CTUserImpl() {
		_intiRulesEngine();
	}

	@Override
	public long[] getMatchesUserSegmentIds(long[] groupIds) throws Exception {
		if (ArrayUtil.isEmpty(groupIds)) {
			return null;
		}

		List<Long> userSegmentIds = new ArrayList<Long>();

		List<UserSegment> userSegments =
			UserSegmentLocalServiceUtil.getUserSegments(groupIds);

		for (UserSegment userSegment : userSegments) {
			if (matches(userSegment)) {
				userSegmentIds.add(userSegment.getUserSegmentId());
			}
		}

		return ArrayUtil.toLongArray(userSegmentIds);
	}

	@Override
	public User getUser() {
		if (getUserId() > 0) {
			try {
				return UserLocalServiceUtil.getUserById(getUserId());
			}
			catch (Exception e) {
			}
		}

		return null;
	}

	public boolean matches(UserSegment userSegment) throws Exception {
		if (_rulesEngine == null) {
			_intiRulesEngine();
		}

		return _rulesEngine.matches(this, userSegment.getRuleInstances());
	}

	private void _intiRulesEngine() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		try {
			_rulesEngine = ServiceTrackerUtil.getService(
				RulesEngine.class, bundle.getBundleContext());
		}
		catch (OsgiServiceUnavailableException osue) {
			_log.error("Can't start the Rules Engine.");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CTUserImpl.class);

	private RulesEngine _rulesEngine;

}