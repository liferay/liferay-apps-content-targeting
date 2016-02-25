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
taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %><%@
page import="com.liferay.asset.kernel.model.AssetRenderer" %><%@
page import="com.liferay.asset.kernel.model.AssetRendererFactory" %><%@
page import="com.liferay.content.targeting.api.model.Channel" %><%@
page import="com.liferay.content.targeting.api.model.Report" %><%@
page import="com.liferay.content.targeting.api.model.ReportsRegistry" %><%@
page import="com.liferay.content.targeting.api.model.Rule" %><%@
page import="com.liferay.content.targeting.api.model.RuleCategoriesRegistry" %><%@
page import="com.liferay.content.targeting.api.model.RuleCategory" %><%@
page import="com.liferay.content.targeting.exception.InvalidNameException" %><%@
page import="com.liferay.content.targeting.exception.UsedUserSegmentException" %><%@
page import="com.liferay.content.targeting.model.Campaign" %><%@
page import="com.liferay.content.targeting.model.ReportInstance" %><%@
page import="com.liferay.content.targeting.model.Tactic" %><%@
page import="com.liferay.content.targeting.model.UserSegment" %><%@
page import="com.liferay.content.targeting.portlet.CampaignContentDisplayPath" %><%@
page import="com.liferay.content.targeting.portlet.ContentTargetingMVCCommand" %><%@
page import="com.liferay.content.targeting.portlet.ContentTargetingPath" %><%@
page import="com.liferay.content.targeting.portlet.UserSegmentContentDisplayPath" %><%@
page import="com.liferay.content.targeting.portlet.util.AssetQueryRule" %><%@
page import="com.liferay.content.targeting.portlet.util.CampaignQueryRule" %><%@
page import="com.liferay.content.targeting.portlet.util.ChannelTemplate" %><%@
page import="com.liferay.content.targeting.portlet.util.QueryRule" %><%@
page import="com.liferay.content.targeting.portlet.util.RuleTemplate" %><%@
page import="com.liferay.content.targeting.portlet.util.UserSegmentQueryRule" %><%@
page import="com.liferay.content.targeting.service.CampaignLocalServiceUtil" %><%@
page import="com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil" %><%@
page import="com.liferay.content.targeting.service.TacticLocalServiceUtil" %><%@
page import="com.liferay.content.targeting.service.UserSegmentLocalServiceUtil" %><%@
page import="com.liferay.content.targeting.service.permission.CampaignPermission" %><%@
page import="com.liferay.content.targeting.service.permission.ContentTargetingPermission" %><%@
page import="com.liferay.content.targeting.service.permission.UserSegmentPermission" %><%@
page import="com.liferay.content.targeting.util.ActionKeys" %><%@
page import="com.liferay.content.targeting.util.CampaignConstants" %><%@
page import="com.liferay.content.targeting.util.CampaignSearchContainerIterator" %><%@
page import="com.liferay.content.targeting.util.PortletKeys" %><%@
page import="com.liferay.content.targeting.util.ReportSearchContainerIterator" %><%@
page import="com.liferay.content.targeting.util.SearchContainerIterator" %><%@
page import="com.liferay.content.targeting.util.TacticSearchContainerIterator" %><%@
page import="com.liferay.content.targeting.util.UserSegmentSearchContainerIterator" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.dao.search.RowChecker" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.model.Group" %><%@
page import="com.liferay.portal.kernel.model.Portlet" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.portlet.PortletProvider" %><%@
page import="com.liferay.portal.kernel.portlet.PortletProviderUtil" %><%@
page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.service.PortletLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.servlet.PortalWebResourceConstants" %><%@
page import="com.liferay.portal.kernel.servlet.PortalWebResourcesUtil" %><%@
page import="com.liferay.portal.kernel.servlet.SessionMessages" %><%@
page import="com.liferay.portal.kernel.template.TemplateHandler" %><%@
page import="com.liferay.portal.kernel.util.ArrayUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.KeyValuePair" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.TimeZoneUtil" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="java.util.Calendar" %><%@
page import="java.util.Collection" %><%@
page import="java.util.List" %><%@
page import="java.util.Map" %>

<%@ page import="javax.portlet.PortletURL" %>

<%@ page import="javax.servlet.ServletContext" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />