create table ContentTargeting_CampaignTAReport_CampaignTrackingAction (
	campaignTrackingActionId LONG not null primary key,
	campaignId LONG,
	userSegmentId LONG,
	alias_ VARCHAR(75) null,
	referrerClassName VARCHAR(75) null,
	referrerClassPK LONG,
	elementId VARCHAR(75) null,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);

create table ContentTargeting_CampaignTAReport_CampaignTrackingActionTotal (
	campaignTrackingActionTotalId LONG not null primary key,
	campaignId LONG,
	alias_ VARCHAR(75) null,
	referrerClassName VARCHAR(75) null,
	referrerClassPK LONG,
	elementId VARCHAR(75) null,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);