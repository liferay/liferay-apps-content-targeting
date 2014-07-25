create table ContentTargeting_CampaignTrackingActionReport_CampaignTrackingAction (
	campaignTrackingActionId LONG not null primary key,
	campaignId LONG,
	userSegmentId LONG,
	alias_ VARCHAR(75) null,
	plid LONG,
	elementId VARCHAR(75) null,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);