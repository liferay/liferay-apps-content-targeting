create table CT_CTA_CTAction (
	CTActionId LONG not null primary key,
	companyId LONG,
	campaignId LONG,
	reportInstanceId LONG,
	userSegmentId LONG,
	alias_ VARCHAR(75) null,
	referrerClassName VARCHAR(75) null,
	referrerClassPK LONG,
	elementId VARCHAR(75) null,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);

create table CT_CTA_CTActionTotal (
	CTActionTotalId LONG not null primary key,
	companyId LONG,
	campaignId LONG,
	reportInstanceId LONG,
	alias_ VARCHAR(75) null,
	referrerClassName VARCHAR(75) null,
	referrerClassPK LONG,
	elementId VARCHAR(75) null,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);