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

<%@ include file="/html/portlet/wiki/init.jsp" %>

<liferay-util:include page="/html/portlet/wiki/view.portal.jsp" />

<%
WikiPage wikiPage = (WikiPage)request.getAttribute(WebKeys.WIKI_PAGE);
%>

<c:if test="<%= wikiPage != null %>">
	<liferay-util:include page="/html/common/analytics/track_content.jsp">
		<liferay-util:param name="analyticsClassName" value="<%= WikiPage.class.getName() %>" />
		<liferay-util:param name="analyticsClassPK" value="<%= String.valueOf(wikiPage.getPrimaryKey()) %>" />
	</liferay-util:include>
</c:if>