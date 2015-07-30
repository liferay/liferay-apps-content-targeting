<#list dataFactory.getSequence(dataFactory.maxUserSegmentContentDisplayPageCount) as pageCount>
	<#assign portletIdPrefix = "usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P" + pageCount + "P">

	<#assign portletCounts = dataFactory.maxUserSegmentContentDisplayPortletCount>

	<#assign layoutModel = dataFactory.newLayoutModel(groupId, "user_segment_content_display_" + pageCount, "", dataFactory.getPortletLayoutColumn(portletIdPrefix, portletCounts))>

	<@insertLayout
		_layoutModel = layoutModel
	/>

	${layoutCSVWriter.write(layoutModel.friendlyURL + "\n")}

	<#list dataFactory.getSequence(portletCounts) as portletCount>
		<@insertPortletPreferences
			_portletPreferencesModel = dataFactory.newUserSegmentContentDisplayPortletPreferenceModels(groupId, layoutModel.plid, portletIdPrefix + portletCount)
		/>
	</#list>
</#list>