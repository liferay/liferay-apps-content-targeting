create table CM_Consumer (
	uuid_ VARCHAR(75) null,
	consumerId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	consumerKey VARCHAR(75) null,
	name STRING null,
	description STRING null
);

create table CM_ConsumerExtensionInstance (
	uuid_ VARCHAR(75) null,
	consumerExtensionInstanceId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	consumerExtensionKey VARCHAR(75) null,
	consumerId LONG,
	typeSettings TEXT null
);

create table CM_ConsumerReportInstance (
	uuid_ VARCHAR(75) null,
	consumerReportInstanceId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	consumerId LONG,
	reportCategoryKey VARCHAR(75) null,
	reportKey VARCHAR(75) null,
	name STRING null,
	description STRING null,
	typeSettings VARCHAR(75) null
);