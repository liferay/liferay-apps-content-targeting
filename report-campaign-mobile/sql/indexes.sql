create index IX_4DFFD0FC on CT_CMR_CampaignMobile (campaignId);
create unique index IX_884F65E on CT_CMR_CampaignMobile (campaignId, consumerId, placeholderId, userSegmentId, className, classPK, eventType);
create index IX_36C38247 on CT_CMR_CampaignMobile (campaignId, modifiedDate);
create index IX_C87C0107 on CT_CMR_CampaignMobile (eventType);

create index IX_B51DCDFF on CT_CMR_CampaignMobile_CampaignMobile (campaignId);
create unique index IX_AF8E84BB on CT_CMR_CampaignMobile_CampaignMobile (campaignId, consumerId, placeholderId, userSegmentId, className, classPK, eventType);
create index IX_4CB4FE0A on CT_CMR_CampaignMobile_CampaignMobile (campaignId, modifiedDate);

create index IX_D6C1FDCA on CT_CMR_Campaign_Mobile_CampaignMobile (campaignId);
create index IX_48D82E95 on CT_CMR_Campaign_Mobile_CampaignMobile (campaignId, modifiedDate);

create index IX_327CD8AA on CT_CMR_ConsumerData (campaignId);
create unique index IX_AED738B5 on CT_CMR_ConsumerData (campaignId, consumerId, eventType);
create index IX_F8A8175 on CT_CMR_ConsumerData (campaignId, modifiedDate);
create index IX_85884B99 on CT_CMR_ConsumerData (eventType);