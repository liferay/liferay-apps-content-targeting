create table AnonymousUser (
	uuid_ VARCHAR(75) null,
	anonymousUserId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastIp VARCHAR(75) null,
	typeSettings TEXT null
);

create table CT_AU_AnonymousUser (
	uuid_ VARCHAR(75) null,
	anonymousUserId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lastIp VARCHAR(75) null,
	typeSettings TEXT null
);