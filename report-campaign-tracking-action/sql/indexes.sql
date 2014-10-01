create index IX_E39568CB on CT_CTAReport_CampaignTrackingAction (campaignId);
create index IX_E64A497C on CT_CTAReport_CampaignTrackingAction (campaignId, elementId);
create index IX_F7AFC3D6 on CT_CTAReport_CampaignTrackingAction (campaignId, modifiedDate);
create index IX_7CEF26DB on CT_CTAReport_CampaignTrackingAction (campaignId, referrerClassName, referrerClassPK);
create unique index IX_2E261395 on CT_CTAReport_CampaignTrackingAction (campaignId, userSegmentId, referrerClassName, referrerClassPK, elementId, eventType);

create index IX_C9C480A3 on CT_CTAReport_CampaignTrackingActionTotal (campaignId);
create index IX_674C41AE on CT_CTAReport_CampaignTrackingActionTotal (campaignId, modifiedDate);
create unique index IX_8D7DF090 on CT_CTAReport_CampaignTrackingActionTotal (campaignId, referrerClassName, referrerClassPK, elementId, eventType);