<#assign pageCounts = dataFactory.getSequence(dataFactory.maxCampaignContentDisplayPageCount)>

<#list pageCounts as pageCount>
	<#assign portletId = "campaigncontentdisplay_WAR_contenttargetingweb_INSTANCE_ABC" + pageCount>

	<#assign layoutModel = dataFactory.newLayoutModel(groupId, "campaign_content_display_" + pageCount, "", portletId)>

	<@insertLayout
		_layoutModel = layoutModel
	/>

	${layoutCSVWriter.write(layoutModel.friendlyURL + "\n")}

	<#assign portletPreferencesModel = dataFactory.newCampaignContentDisplayPortletPreferenceModels(groupId, layoutModel.plid, portletId)>

	<@insertPortletPreferences
		_portletPreferencesModel = portletPreferencesModel
	/>
</#list>