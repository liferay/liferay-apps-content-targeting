<%--
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
--%>

<%@ include file="/html/portlet/blogs/init.jsp" %>

<liferay-util:include page="/html/portlet/blogs/view_entry.portal.jsp" />

<%
BlogsEntry entry = (BlogsEntry)request.getAttribute(WebKeys.BLOGS_ENTRY);

long[] userSegmentIds = (long[])request.getAttribute("userSegmentIds");

UnicodeProperties groupTypeSettingsProperties = themeDisplay.getScopeGroup().getParentLiveGroupTypeSettingsProperties();
%>

<c:if test='<%= !layout.isTypeControlPanel() && (PrefsPropsUtil.getBoolean(company.getCompanyId(), "content.targeting.analytics.content.enabled") && GetterUtil.getBoolean(groupTypeSettingsProperties.getProperty("content.targeting.analytics.content.enabled"), true)) && (entry != null) %>'>
	<aui:script position="inline">
		Liferay.Analytics.track(
			'view',
			{
				className: '<%= BlogsEntry.class.getName() %>',
				classPK: '<%= entry.getPrimaryKey() %>',
				referrerClassName: 'com.liferay.portal.contenttargeting.model.UserSegment',
				referrerClassPK: '<%= StringUtil.merge(userSegmentIds) %>'
			}
		);
	</aui:script>
</c:if>