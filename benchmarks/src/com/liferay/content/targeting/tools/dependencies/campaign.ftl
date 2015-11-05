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

<#assign campaignModels = dataFactory.newCampaignModels(groupId) />

<#list campaignModels as campaignModel>
	insert into CT_Campaign values ('${campaignModel.uuid}', ${campaignModel.campaignId}, ${campaignModel.groupId},  ${campaignModel.companyId}, ${campaignModel.userId}, '${campaignModel.userName}', '${dataFactory.getDateString(campaignModel.createDate)}', '${dataFactory.getDateString(campaignModel.modifiedDate)}', '${campaignModel.name}', '${campaignModel.description}', '${dataFactory.getDateString(campaignModel.startDate)}', '${dataFactory.getDateString(campaignModel.endDate)}', ${campaignModel.priority}, ${campaignModel.active?string});

	<@insertResourcePermissions
		_entry = campaignModel
	/>

	insert into CT_Campaigns_UserSegments values (${campaignModel.campaignId}, ${dataFactory.getCampaignUserSegmentId(campaignModel_index)});
</#list>