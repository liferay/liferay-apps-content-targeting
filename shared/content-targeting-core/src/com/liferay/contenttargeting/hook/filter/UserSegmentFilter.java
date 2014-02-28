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

package com.liferay.contenttargeting.hook.filter;

import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.service.CTUserLocalServiceUtil;
import com.liferay.contenttargeting.util.CTUserUtil;
import com.liferay.contenttargeting.util.ContentTargetingUtil;
import com.liferay.contenttargeting.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.model.LayoutSet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentFilter implements Filter {

	public void destroy() {
	}

	@Override
	public void doFilter(
			ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain)
		throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)servletRequest;

		HttpServletResponse response = (HttpServletResponse)servletResponse;

		try {
			CTUser ctUser = CTUserUtil.getCTUser(request, response);

			CTUserLocalServiceUtil.updateLastIp(
				ctUser.getCTUserId(), request.getRemoteAddr());

			long[] groupIds = getGroupIds(request);

			long[] userSegmentsIds = ctUser.getMatchesUserSegmentIds(groupIds);

			if (ArrayUtil.isNotEmpty(userSegmentsIds)) {
				request.setAttribute(WebKeys.USER_SEGMENT_IDS, userSegmentsIds);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	protected long[] getGroupIds(HttpServletRequest request)
		throws PortalException, SystemException {

		LayoutSet layoutSet = (LayoutSet)request.getAttribute(
			"VIRTUAL_HOST_LAYOUT_SET");

		if (layoutSet == null) {
			return null;
		}

		return ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
			layoutSet.getGroupId());
	}

}