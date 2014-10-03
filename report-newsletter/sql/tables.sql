create table ContentTargeting_CampaignNewsletter_Newsletter (
	newsletterId LONG not null primary key,
	campaignId LONG,
	alias_ VARCHAR(75) null,
	elementId VARCHAR(75) null,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);