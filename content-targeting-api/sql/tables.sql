create table CT_Campaign (
	uuid_ VARCHAR(75) null,
	campaignId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	startDate DATE null,
	endDate DATE null,
	priority INTEGER,
	active_ BOOLEAN
);

create table CT_Campaigns_UserSegments (
	campaignId LONG not null,
	userSegmentId LONG not null,
	primary key (campaignId, userSegmentId)
);

create table CT_ReportInstance (
	reportInstanceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	modifiedDate DATE null,
	reportKey VARCHAR(75) null,
	className VARCHAR(75) null,
	classPK LONG,
	typeSettings TEXT null
);

create table CT_RuleInstance (
	uuid_ VARCHAR(75) null,
	ruleInstanceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ruleKey VARCHAR(75) null,
	userSegmentId LONG,
	typeSettings TEXT null
);

create table CT_TrackingActionInstance (
	uuid_ VARCHAR(75) null,
	trackingActionInstanceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	trackingActionKey VARCHAR(75) null,
	campaignId LONG,
	alias_ VARCHAR(75) null,
	referrerClassName VARCHAR(75) null,
	referrerClassPK LONG,
	elementId VARCHAR(75) null,
	eventType VARCHAR(75) null,
	typeSettings TEXT null
);

create table CT_UserSegment (
	uuid_ VARCHAR(75) null,
	userSegmentId LONG not null primary key,
	groupId LONG,
	assetCategoryId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null
);