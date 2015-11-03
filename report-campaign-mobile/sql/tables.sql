create table CT_CMR_CampaignMobile (
	campaignMobileId LONG not null primary key,
	campaignId LONG,
	count INTEGER,
	modifiedDate DATE null,
	eventType VARCHAR(75) null,
	className VARCHAR(75) null,
	classPK LONG,
	elementId VARCHAR(75) null,
	consumerId LONG,
	placeholderId LONG,
	userSegmentId LONG
);

create table CT_CMR_ConsumerData (
	consumerDataId LONG not null primary key,
	campaignId LONG,
	count INTEGER,
	modifiedDate DATE null,
	eventType VARCHAR(75) null,
	elementId VARCHAR(75) null,
	consumerId LONG
);