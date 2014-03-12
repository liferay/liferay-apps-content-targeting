create table AU_AnonymousUser (
	uuid_ VARCHAR(75) null,
	AnonymousUserId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastIp VARCHAR(75) null,
	typeSettings TEXT null
);