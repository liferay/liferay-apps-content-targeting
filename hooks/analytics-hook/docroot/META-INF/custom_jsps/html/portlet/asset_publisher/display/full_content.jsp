<%--
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
--%>

<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<liferay-util:include page="/html/portlet/asset_publisher/display/full_content.portal.jsp" />

<%
AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");

long[] userSegmentIds = (long[])request.getAttribute("userSegmentIds");
%>

<c:if test="<%= (assetEntry != null) && Validator.isNotNull(userSegmentIds) %>">
	<aui:script position="inline">
		Liferay.Analytics.track('view', {
			className: '<%= assetEntry.getClassName() %>',
			classPK: '<%= assetEntry.getClassPK() %>',
			groupId: '<%= assetEntry.getGroupId() %>',
			referrerClassName: 'com.liferay.contenttargeting.model.UserSegment',
			referrerClassPK: '<%= StringUtil.merge(userSegmentIds) %>'
		});
	</aui:script>
</c:if>