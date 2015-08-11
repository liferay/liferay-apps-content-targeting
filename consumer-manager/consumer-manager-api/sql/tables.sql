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
	typeSettings VARCHAR(75) null
);