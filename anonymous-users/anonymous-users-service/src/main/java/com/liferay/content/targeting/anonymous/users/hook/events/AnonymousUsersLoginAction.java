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
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component(
	property = {"key=login.events.post"}, service = LifecycleAction.class
)
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

		_anonymousUsersCookieManager.deleteCookie(request, response);

		if (_log.isDebugEnabled()) {
			_log.debug("Deleting Anonymous User Cookie");
		}
	}

	@Reference(unbind ="unsetAnonymousUsersCookieManager")
	protected void setAnonymousUsersCookieManager(
		AnonymousUsersCookieManager anonymousUsersCookieManager) {

		_anonymousUsersCookieManager = anonymousUsersCookieManager;
	}

	protected void unsetAnonymousUsersCookieManager() {
		_anonymousUsersCookieManager = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AnonymousUsersLoginAction.class);

	private AnonymousUsersCookieManager _anonymousUsersCookieManager;

}