<#assign campaignModels = dataFactory.newCampaignModels(groupId) />

<#list campaignModels as campaignModel>
	insert into CT_Campaign values ('${campaignModel.uuid}', ${campaignModel.campaignId}, ${campaignModel.groupId},  ${campaignModel.companyId}, ${campaignModel.userId}, '${campaignModel.userName}', '${dataFactory.getDateString(campaignModel.createDate)}', '${dataFactory.getDateString(campaignModel.modifiedDate)}', '${campaignModel.name}', '${campaignModel.description}', '${dataFactory.getDateString(campaignModel.startDate)}', '${dataFactory.getDateString(campaignModel.endDate)}', ${campaignModel.priority}, ${campaignModel.active?string});

	<@insertResourcePermissions
		_entry = campaignModel
	/>

	insert into CT_Campaigns_UserSegments values (${campaignModel.campaignId}, ${dataFactory.getCampaignUserSegmentId(campaignModel_index)});
</#list>