create index IX_EBDBB5F0 on CampaignTrackingActionReport_CampaignTrackingAction (campaignId);
create index IX_921AC3B on CampaignTrackingActionReport_CampaignTrackingAction (campaignId, modifiedDate);
create index IX_1C9C3FCB on CampaignTrackingActionReport_CampaignTrackingAction (campaignId, userSegmentId, plid, elementId, eventType);