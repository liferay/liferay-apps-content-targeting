create index IX_EF598653 on CT_CCR_CampaignContent (campaignId);
create unique index IX_6A8F32C1 on CT_CCR_CampaignContent (campaignId, className, classPK, eventType);
create index IX_B40D935E on CT_CCR_CampaignContent (campaignId, modifiedDate);