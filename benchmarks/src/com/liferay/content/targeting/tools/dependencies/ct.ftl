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