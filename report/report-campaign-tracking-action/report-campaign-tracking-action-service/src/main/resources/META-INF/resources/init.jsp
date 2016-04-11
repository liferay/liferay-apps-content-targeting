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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.content.targeting.api.model.TrackingAction" %><%@
page import="com.liferay.content.targeting.report.campaign.tracking.action.display.context.CampaignTrackingActionReportDisplayContext" %><%@
page import="com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction" %><%@
page import="com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal" %><%@
page import="com.liferay.content.targeting.report.campaign.tracking.action.util.TrackingActionTemplate" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="java.util.List" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
CampaignTrackingActionReportDisplayContext campaignTrackingActionReportDisplayContext = new CampaignTrackingActionReportDisplayContext(liferayPortletRequest, liferayPortletResponse, request);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(campaignTrackingActionReportDisplayContext.getBackURL());
%>