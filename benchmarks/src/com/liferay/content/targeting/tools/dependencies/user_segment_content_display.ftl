<#assign pageCounts = dataFactory.getSequence(dataFactory.maxUserSegmentContentDisplayPageCount)>

<#list pageCounts as pageCount>
	<#assign portletId = "usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_ABC" + pageCount>

	<#assign layoutModel = dataFactory.newLayoutModel(groupId, "user_segment_content_display_" + pageCount, "", portletId)>

	<@insertLayout
		_layoutModel = layoutModel
	/>

	${layoutCSVWriter.write(layoutModel.friendlyURL + "\n")}

	<#assign portletPreferencesModel = dataFactory.newUserSegmentContentDisplayPortletPreferenceModels(groupId, layoutModel.plid, portletId)>

	<@insertPortletPreferences
		_portletPreferencesModel = portletPreferencesModel
	/>
</#list>