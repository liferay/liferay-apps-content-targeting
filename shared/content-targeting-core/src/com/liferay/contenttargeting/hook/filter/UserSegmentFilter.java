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

import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.service.CTUserLocalService;
import com.liferay.contenttargeting.util.CTCookieUtil;
import com.liferay.contenttargeting.util.WebKeys;
import com.liferay.osgi.util.OsgiServiceUnavailableException;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;

import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

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
			CTUser ctUser = getCTUser(request, response);

			long[] groupIds = getGroupIds(request);

			long[] userSegmentsIds = ctUser.getMatchesUserSegmentIds(
				groupIds, _rulesRegistry);

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
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		try {
			_ctUserLocalService = ServiceTrackerUtil.getService(
				CTUserLocalService.class, bundle.getBundleContext());
			_rulesRegistry = ServiceTrackerUtil.getService(
				RulesRegistry.class, bundle.getBundleContext());
		}
		catch (OsgiServiceUnavailableException osue) {
			osue.printStackTrace();
		}
	}

	protected CTUser getCTUser(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		long companyId = PortalUtil.getCompanyId(request);
		long userId = PortalUtil.getUserId(request);

		if (userId > 0) {
			CTUser ctUser = _ctUserLocalService.getCTUserByUserId(userId);

			if (ctUser == null) {
				ServiceContext serviceContext = new ServiceContext();

				serviceContext.setCompanyId(companyId);

				ctUser = _ctUserLocalService.addUser(
					userId, null, null, serviceContext);
			}

			return ctUser;
		}

		long ctUserId = CTCookieUtil.getCTUserId(request);

		if (ctUserId > 0) {
			return _ctUserLocalService.fetchCTUser(ctUserId);
		}

		CTUser ctUser = _ctUserLocalService.addUser(companyId);

		CTCookieUtil.addCookie(request, response, ctUser.getCTUserId());

		return ctUser;
	}

	protected long[] getGroupIds(HttpServletRequest request)
		throws PortalException, SystemException {

		LayoutSet layoutSet = (LayoutSet)request.getAttribute(
			"VIRTUAL_HOST_LAYOUT_SET");

		if (layoutSet == null) {
			return null;
		}

		Group scopeGroup = GroupLocalServiceUtil.fetchGroup(
			layoutSet.getGroupId());

		if (scopeGroup == null) {
			return null;
		}

		List<Group> groups = scopeGroup.getAncestors();

		groups.add(scopeGroup);

		long[] groupIds = new long[groups.size()];

		for (int i = 0; i < groups.size(); i++) {
			Group group = groups.get(i);

			groupIds[i] = group.getGroupId();
		}

		return groupIds;
	}

	private CTUserLocalService _ctUserLocalService;
	private RulesRegistry _rulesRegistry;

}