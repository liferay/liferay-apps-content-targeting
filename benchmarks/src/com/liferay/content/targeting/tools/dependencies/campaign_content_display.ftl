<#list dataFactory.getSequence(dataFactory.maxCampaignContentDisplayPageCount) as pageCount>
	<#assign portletIdPrefix = "campaigncontentdisplay_WAR_contenttargetingweb_INSTANCE_P" + pageCount + "P">

	<#assign portletCounts = dataFactory.maxCampaignContentDisplayPortletCount>

	<#assign layoutModel = dataFactory.newLayoutModel(groupId, "campaign_content_display_" + pageCount, "", dataFactory.getPortletLayoutColumn(portletIdPrefix, portletCounts))>

	<@insertLayout
		_layoutModel = layoutModel
	/>

	${layoutCSVWriter.write(layoutModel.friendlyURL + "\n")}

	<#list dataFactory.getSequence(portletCounts) as portletCount>
		<@insertPortletPreferences
			_portletPreferencesModel = dataFactory.newCampaignContentDisplayPortletPreferenceModels(groupId, layoutModel.plid, portletIdPrefix + portletCount)
		/>
	</#list>
</#list>