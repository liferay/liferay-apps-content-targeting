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

package com.liferay.content.targeting.anonymous.users.hook.events;

import com.liferay.content.targeting.anonymous.users.util.AnonymousUsersCookieManager;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Julio Camarero
 */
public class AnonymousUsersLoginAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
		throws ActionException {

		try {
			doRun(request, response);
		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

	protected void doRun(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		_initAnonymousUserManager();

		_anonymousUsersCookieManager.deleteCookie(request, response);

		if (_log.isDebugEnabled()) {
			_log.debug("Deleting Anonymous User Cookie");
		}
	}

	private void _initAnonymousUserManager() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_anonymousUsersCookieManager = ServiceTrackerUtil.getService(
			AnonymousUsersCookieManager.class, bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		AnonymousUsersLoginAction.class);

	private AnonymousUsersCookieManager _anonymousUsersCookieManager;

}