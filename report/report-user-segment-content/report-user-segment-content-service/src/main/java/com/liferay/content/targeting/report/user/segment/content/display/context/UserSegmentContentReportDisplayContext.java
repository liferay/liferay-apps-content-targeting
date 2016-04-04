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

package com.liferay.content.targeting.report.user.segment.content.display.context;

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.display.context.BaseReportDisplayContext;
import com.liferay.content.targeting.report.user.segment.content.service.UserSegmentContentLocalServiceUtil;
import com.liferay.content.targeting.report.user.segment.content.util.comparator.UserSegmentContentCountComparator;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public class UserSegmentContentReportDisplayContext
	extends BaseReportDisplayContext {

	public UserSegmentContentReportDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request) {

		super(request);

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
	}

	public SearchContainer getSearchContainer() throws PortalException {
		if (_searchContainer != null) {
			return _searchContainer;
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay)_liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig =
			(PortletConfig) _liferayPortletRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

		String emptyResultsMessage = LanguageUtil.format(
			portletConfig.getResourceBundle(themeDisplay.getLocale()),
			"there-is-not-enough-data-to-generate-a-content-views-report-for-" +
				"the-user-segment-x",
			getName());

		SearchContainer searchContainer = new SearchContainer(
			_liferayPortletRequest, getPortletURL(), null, emptyResultsMessage);

		int total =
			UserSegmentContentLocalServiceUtil.getUserSegmentContentsCount(
				getClassPK());

		searchContainer.setTotal(total);

		List results =
			UserSegmentContentLocalServiceUtil.getUserSegmentContents(
				getClassPK(), searchContainer.getStart(),
				searchContainer.getEnd(),
				new UserSegmentContentCountComparator());

		searchContainer.setResults(results);

		_searchContainer = searchContainer;

		return _searchContainer;
	}

	protected PortletURL getPortletURL() {
		Report report = getReport();

		PortletURL portletURL = _liferayPortletResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "viewReport");
		portletURL.setParameter("redirect", getRedirect());
		portletURL.setParameter("reportKey", report.getReportKey());
		portletURL.setParameter("className", getClassName());
		portletURL.setParameter("classPK", String.valueOf(getClassPK()));

		return portletURL;
	}

	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private SearchContainer _searchContainer;

}