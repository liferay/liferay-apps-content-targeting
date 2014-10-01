create index IX_A40E9C71 on CT_CCReport_CampaignContent (campaignId);
create unique index IX_7A5ED8E3 on CT_CCReport_CampaignContent (campaignId, className, classPK, eventType);
create index IX_EADA9CFC on CT_CCReport_CampaignContent (campaignId, modifiedDate);