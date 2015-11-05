<#--
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
-->

<#setting number_format = "computer">

<#include "macro.ftl">

<#list dataFactory.groupModels as groupModel>
	<#assign groupId = groupModel.groupId>

	<#include "user_segment.ftl">

	<#include "user_segment_content_display.ftl">

	<#include "user_segment_content_list.ftl">

	<#include "campaign.ftl">

	<#include "campaign_content_display.ftl">
</#list>

<#include "counters.ftl">

COMMIT_TRANSACTION