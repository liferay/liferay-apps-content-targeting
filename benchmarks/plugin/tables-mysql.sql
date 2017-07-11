create table CT_Campaign (
uuid_ varchar(75) null,
campaignId bigint not null primary key,
groupId bigint,
companyId bigint,
userId bigint,
userName varchar(75) null,
createDate datetime null,
modifiedDate datetime null,
name longtext null,
description longtext null,
startDate datetime null,
endDate datetime null,
priority integer,
active_ tinyint
);
create table CT_Campaigns_UserSegments (
campaignId bigint not null,
userSegmentId bigint not null,
primary key (campaignId, userSegmentId)
);
create table CT_ReportInstance (
reportInstanceId bigint not null primary key,
groupId bigint,
companyId bigint,
userId bigint,
userName varchar(75) null,
modifiedDate datetime null,
reportKey varchar(75) null,
className varchar(75) null,
classPK bigint,
typeSettings longtext null
);
create table CT_RuleInstance (
uuid_ varchar(75) null,
ruleInstanceId bigint not null primary key,
groupId bigint,
companyId bigint,
userId bigint,
userName varchar(75) null,
createDate datetime null,
modifiedDate datetime null,
ruleKey varchar(75) null,
userSegmentId bigint,
typeSettings longtext null
);
create table CT_TrackingActionInstance (
uuid_ varchar(75) null,
trackingActionInstanceId bigint not null primary key,
groupId bigint,
companyId bigint,
userId bigint,
userName varchar(75) null,
createDate datetime null,
modifiedDate datetime null,
trackingActionKey varchar(75) null,
campaignId bigint,
alias_ varchar(75) null,
referrerClassName varchar(75) null,
referrerClassPK bigint,
elementId varchar(75) null,
eventType varchar(75) null,
typeSettings longtext null
);
create table CT_UserSegment (
uuid_ varchar(75) null,
userSegmentId bigint not null primary key,
groupId bigint,
assetCategoryId bigint,
companyId bigint,
userId bigint,
userName varchar(75) null,
createDate datetime null,
modifiedDate datetime null,
name longtext null,
description longtext null
);
