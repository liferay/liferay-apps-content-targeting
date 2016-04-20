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

<liferay-util:include page="/info_message.jsp" servletContext="<%= application %>" />

<aui:select inlineField="<%= true %>" inlineLabel="left" label="users-that-have" name="selector">
	<aui:option label="more" selected='<%= "more".equals(ruleFacebookDisplayContext.getSelector()) %>' />

	<aui:option label="less" selected='<%= "less".equals(ruleFacebookDisplayContext.getSelector()) %>' />
</aui:select>

<aui:input inlineField="<%= true %>" inlineLabel="left" label="than" name="numberOfFriends" suffix="friends" title="number-of-friends" type="text" value="<%= ruleFacebookDisplayContext.getNumberOfFriends() %>">
	<aui:validator name="number" />
</aui:input>