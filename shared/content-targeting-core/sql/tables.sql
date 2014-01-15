create table CT_CTUser (
	uuid_ VARCHAR(75) null,
	CTUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastIp VARCHAR(75) null,
	typeSettings TEXT null
);

create table CT_Rule (
	uuid_ VARCHAR(75) null,
	ruleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	segmentId LONG,
	type_ VARCHAR(75) null,
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
	typeSettings VARCHAR(75) null
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