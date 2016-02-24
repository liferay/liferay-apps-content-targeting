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
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component
public class DefaultAnonymousUsersManagerImpl implements AnonymousUsersManager {

	@Override
	public AnonymousUser getAnonymousUser(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException {

		long companyId = PortalUtil.getCompanyId(request);
		long userId = PortalUtil.getUserId(request);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(companyId);

		AnonymousUser anonymousUser = null;

		if (userId > 0) {
			anonymousUser = getAnonymousUser(request, userId);
		}
		else {
			anonymousUser = getAnonymousUserFromCookie(request);
		}

		String userIp = getAddressFromRequest(request);

		if (anonymousUser == null) {
			anonymousUser = _anonymousUserLocalService.addAnonymousUser(
				0, userIp, null, serviceContext);

			_anonymousUsersCookieManager.addCookie(
				request, response, anonymousUser.getAnonymousUserId());
		}
		else if (!anonymousUser.getLastIp().equals(userIp)) {
			_anonymousUserLocalService.updateLastIp(
				anonymousUser.getAnonymousUserId(), userIp);
		}

		return anonymousUser;
	}

	@Override
	public AnonymousUser getAnonymousUser(
			HttpServletRequest request, long userId)
		throws PortalException {

		long companyId = PortalUtil.getCompanyId(request);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(companyId);

		String userIp = getAddressFromRequest(request);

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.fetchAnonymousUserByUserId(userId);

		if (anonymousUser == null) {
			anonymousUser = getAnonymousUserFromCookie(request);

			if ((anonymousUser == null) ||
				((anonymousUser.getUserId() != 0) &&
				 (anonymousUser.getUserId() != userId))) {

				anonymousUser = _anonymousUserLocalService.addAnonymousUser(
					userId, userIp, null, serviceContext);
			}
			else {
				anonymousUser = _anonymousUserLocalService.updateAnonymousUser(
					anonymousUser.getAnonymousUserId(), userId, userIp,
					anonymousUser.getTypeSettings(), serviceContext);
			}
		}

		return anonymousUser;
	}

	@Override
	public AnonymousUser getAnonymousUser(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortalException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(
			renderResponse);

		return getAnonymousUser(request, response);
	}

	public AnonymousUsersCookieManager getAnonymousUsersCookieManager() {
		return _anonymousUsersCookieManager;
	}

	@Reference(unbind = "-")
	public void setAnonymousUserLocalService(
		AnonymousUserLocalService anonymousUserLocalService) {

		_anonymousUserLocalService = anonymousUserLocalService;
	}

	@Reference(unbind = "-")
	public void setAnonymousUsersCookieManager(
		AnonymousUsersCookieManager anonymousUsersCookieManager) {

		_anonymousUsersCookieManager = anonymousUsersCookieManager;
	}

	protected String getAddressFromRequest(HttpServletRequest request) {
		if (request == null) {
			return StringPool.BLANK;
		}

		// See http://tools.ietf.org/html/rfc7239

		String ips = request.getHeader(_X_FORWARDED_FOR);

		if (Validator.isNotNull(ips)) {
			return StringUtil.split(ips)[0];
		}

		Enumeration<String> values = request.getHeaders(_FORWARDED);

		if (values.hasMoreElements()) {
			String value = values.nextElement();

			Matcher matcher = _pattern.matcher(value);

			if (matcher.find()) {
				return matcher.group(1);
			}
		}

		return request.getRemoteAddr();
	}

	protected AnonymousUser getAnonymousUserFromCookie(
		HttpServletRequest request) {

		AnonymousUser anonymousUser = null;

		long anonymousUserId = _anonymousUsersCookieManager.getAnonymousUserId(
			request);

		if (anonymousUserId > 0) {
			anonymousUser = _anonymousUserLocalService.fetchAnonymousUser(
				anonymousUserId);
		}

		return anonymousUser;
	}

	private static final String _FORWARDED = "Forwarded";

	private static final String _X_FORWARDED_FOR = "X-Forwarded-For";

	private AnonymousUserLocalService _anonymousUserLocalService;
	private AnonymousUsersCookieManager _anonymousUsersCookieManager;
	private final Pattern _pattern = Pattern.compile(
		"for=[\"\\[]*([^\\]\\,]+)[\"\\]]*");

}