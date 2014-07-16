create index IX_2BAEC2CB on CampaignTrackingActions_CampaignTrackingAction (campaignId);
create index IX_C3639DD6 on CampaignTrackingActions_CampaignTrackingAction (campaignId, modifiedDate);
create index IX_2C17D810 on CampaignTrackingActions_CampaignTrackingAction (campaignId, userSegmentId, plid, elementId, eventType);