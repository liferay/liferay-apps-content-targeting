<#assign pageCounts = dataFactory.getSequence(dataFactory.maxUserSegmentContentListPageCount)>

<#list pageCounts as pageCount>
	<#assign portletId = "usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_ABC" + pageCount>

	<#assign layoutModel = dataFactory.newLayoutModel(groupId, "user_segment_content_list_" + pageCount, "", portletId)>

	<@insertLayout
		_layoutModel = layoutModel
	/>
</#list>