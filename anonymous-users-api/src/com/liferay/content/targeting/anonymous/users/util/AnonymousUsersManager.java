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

package com.liferay.content.targeting.anonymous.users.util;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eduardo Garcia
 */
public interface AnonymousUsersManager {

	public AnonymousUser getAnonymousUser(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException;

	public AnonymousUser getAnonymousUser(
			HttpServletRequest request, long userId)
		throws PortalException;

	public AnonymousUser getAnonymousUser(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortalException;

}