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

<%@ include file="/init.jsp" %>

<%
ContentTargetingViewCampaignDisplayContext contentTargetingViewCampaignDisplayContext = new ContentTargetingViewCampaignDisplayContext(liferayPortletRequest, liferayPortletResponse);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(contentTargetingViewCampaignDisplayContext.getBackURL());

renderResponse.setTitle(contentTargetingViewCampaignDisplayContext.getCampaignTitle());
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="<%= contentTargetingViewCampaignDisplayContext.getSummaryURL() %>" label="summary" selected="<%= contentTargetingViewCampaignDisplayContext.isShowSummary() %>" />

		<aui:nav-item href="<%= contentTargetingViewCampaignDisplayContext.getReportsURL() %>" label="reports" selected="<%= contentTargetingViewCampaignDisplayContext.isShowReports() %>" />
	</aui:nav>

	<c:if test="<%= contentTargetingViewCampaignDisplayContext.showSearch() %>">
		<aui:nav-bar-search>
			<aui:form action="<%= contentTargetingViewCampaignDisplayContext.getReportsURL() %>" name="searchFm">
				<liferay-ui:input-search markupView="lexicon" name="keywords" />
			</aui:form>
		</aui:nav-bar-search>
	</c:if>
</aui:nav-bar>