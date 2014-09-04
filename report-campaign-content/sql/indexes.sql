create index IX_D124AEC5 on ContentTargeting_CampaignContentReport_CampaignContent (campaignId);
create unique index IX_3EDB7C0F on ContentTargeting_CampaignContentReport_CampaignContent (campaignId, className, classPK, eventType);
create index IX_62E80C50 on ContentTargeting_CampaignContentReport_CampaignContent (campaignId, modifiedDate);