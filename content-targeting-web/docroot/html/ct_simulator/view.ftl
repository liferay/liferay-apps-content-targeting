<#--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
-->

<#include "../init.ftl" />

<@aui["button"] cssClass="close pull-right" name="closePanelSimulator" value="&times;" />

<h1><@liferay_ui["message"] key="simulator" /></h1>

<#assign campaignsLabel = languageUtil.get(locale, "campaigns") />

<#assign userSegmentsLabel = languageUtil.get(locale, "user-segments") />

<div class="content-targeting-simulator">
	<@liferay_ui["tabs"]
		names="${userSegmentsLabel},${campaignsLabel}"
		refresh=false
		type="pills"
		value="${tabs1}"
	>
		<@liferay_ui["section"]>
			<#include "view_user_segments.ftl" />
		</@>

		<@liferay_ui["section"]>
			<#include "view_campaigns.ftl" />
		</@>
	</@>
</div>

<@aui["script"] use="liferay-dockbar">
	A.one('#<@portlet["namespace"] />closePanelSimulator').on(
		'click',
		function(event) {
			Liferay.Dockbar._togglePanel('simulatorPanel');
		}
	);
</@>