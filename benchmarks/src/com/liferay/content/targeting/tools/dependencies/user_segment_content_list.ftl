<#list dataFactory.getSequence(dataFactory.maxUserSegmentContentListPageCount) as pageCount>
	<#assign portletIdPrefix = "usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P" + pageCount + "P">

	<#assign portletCounts = dataFactory.maxUserSegmentContentListPortletCount>

	<#assign layoutModel = dataFactory.newLayoutModel(groupId, "user_segment_content_list_" + pageCount, "", dataFactory.getPortletLayoutColumn(portletIdPrefix, portletCounts))>

	<@insertLayout
		_layoutModel = layoutModel
	/>

	${layoutCSVWriter.write(layoutModel.friendlyURL + "\n")}

	<#list dataFactory.getSequence(portletCounts) as portletCount>
		<@insertPortletPreferences
			_portletPreferencesModel = dataFactory.newUserSegmentContentListPortletPreferenceModels(layoutModel.plid, portletIdPrefix + portletCount)
		/>
	</#list>
</#list>