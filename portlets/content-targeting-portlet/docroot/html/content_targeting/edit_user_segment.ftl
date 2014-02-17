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

<@liferay_ui["header"]
	backURL="${redirect}"
	title='${(userSegment.getName(locale))!"new-user-segment"}'
/>

<@portlet["actionURL"] name="updateUserSegment" var="addUserSegmentURL" />

<@aui["form"] action="${addUserSegmentURL}" method="post" name="fm">
	<@aui["input"] name="redirect" type="hidden" value="${redirect}" />
	<@aui["input"] name="userSegmentId" type="hidden" value=userSegmentId />

	<@aui["model-context"] bean=userSegment model=userSegmentClass />

	<@aui["input"] name="name" required=true />

	<@aui["input"] name="description" />

	<@aui["button-row"]>
		<@aui["button"] type="submit" />
	</@>
</@>