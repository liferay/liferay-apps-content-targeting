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

<%@ include file="/html/portlet/journal_content/init.jsp" %>

<liferay-util:include page="/html/portlet/journal_content/view.portal.jsp" />

<%
JournalArticleDisplay articleDisplay = (JournalArticleDisplay)request.getAttribute(WebKeys.JOURNAL_ARTICLE_DISPLAY);
%>

<c:if test="<%= articleDisplay != null %>">
	<liferay-util:include page="/html/common/analytics/track_content.jsp">
		<liferay-util:param name="analyticsClassName" value="<%= JournalArticle.class.getName() %>" />
		<liferay-util:param name="analyticsClassPK" value="<%= String.valueOf(articleDisplay.getResourcePrimKey()) %>" />
	</liferay-util:include>
</c:if>