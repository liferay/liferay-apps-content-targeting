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

package com.liferay.contenttargeting.util;

import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.service.CTUserLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eudaldo Alonso
 */
public class CTUserUtil {

	public static CTUser getCTUser(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		long companyId = PortalUtil.getCompanyId(request);
		long userId = PortalUtil.getUserId(request);

		if (userId > 0) {
			CTUser ctUser = CTUserLocalServiceUtil.getCTUserByUserId(userId);

			if (ctUser == null) {
				ServiceContext serviceContext = new ServiceContext();

				serviceContext.setCompanyId(companyId);

				ctUser = CTUserLocalServiceUtil.addUser(
					userId, null, null, serviceContext);
			}

			return ctUser;
		}

		long ctUserId = CTCookieUtil.getCTUserId(request);

		if (ctUserId > 0) {
			CTUser ctUser = CTUserLocalServiceUtil.fetchCTUser(ctUserId);

			if (ctUser != null) {
				return ctUser;
			}
		}

		CTUser ctUser = CTUserLocalServiceUtil.addUser(companyId);

		CTCookieUtil.addCookie(request, response, ctUser.getCTUserId());

		return ctUser;
	}

	public static CTUser getCTUser(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortalException, SystemException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			renderResponse);

		return getCTUser(request, response);
	}

}