create index IX_6E99A450 on CT_CNReport_Newsletter (campaignId);
create unique index IX_EB1CD9F0 on CT_CNReport_Newsletter (campaignId, alias_, elementId, eventType);

create index IX_78CE91ED on ContentTargeting_CampaignNewsletter_Newsletter (campaignId);
create unique index IX_7677D6CD on ContentTargeting_CampaignNewsletter_Newsletter (campaignId, alias_, elementId, eventType);