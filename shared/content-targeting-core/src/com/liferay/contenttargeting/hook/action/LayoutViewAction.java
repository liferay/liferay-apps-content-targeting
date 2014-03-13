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

package com.liferay.contenttargeting.hook.action;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.anonymoususers.util.AnonymousUsersManager;
import com.liferay.contenttargeting.util.WebKeys;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eudaldo
 */
public class LayoutViewAction extends BaseStrutsAction {

	@Override
	public String execute(
			StrutsAction originalStrutsAction, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String actionForward = originalStrutsAction.execute(request, response);

		Layout layout = themeDisplay.getLayout();

		if (layout == null) {
			return actionForward;
		}

		if (_anonymousUsersManager == null) {
			_intiAnonymousUserManager();
		}

		AnonymousUser anonymousUser = _anonymousUsersManager.getAnonymousUser(
			request, response);

		Message message = new Message();

		message.put("className", Layout.class.getName());
		message.put("classPK", layout.getPrimaryKey());
		message.put("anonymousUserId", anonymousUser.getAnonymousUserId());
		message.put("groupId", layout.getGroupId());

		MessageBusUtil.sendMessage("liferay/analytics", message);

		return actionForward;
	}

	private void _intiAnonymousUserManager() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_anonymousUsersManager = ServiceTrackerUtil.getService(
			AnonymousUsersManager.class, bundle.getBundleContext());
	}

	private AnonymousUsersManager _anonymousUsersManager;

}