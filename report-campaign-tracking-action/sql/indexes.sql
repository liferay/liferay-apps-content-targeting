create index IX_EB2A2A9 on ContentTargeting_CampaignTrackingAction (campaignId);
create index IX_B2FB6134 on ContentTargeting_CampaignTrackingAction (campaignId, modifiedDate);
create index IX_9E01F972 on ContentTargeting_CampaignTrackingAction (campaignId, userSegmentId, plid, elementId, eventType);