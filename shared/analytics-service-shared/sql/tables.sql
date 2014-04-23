create table Analytics_AnalyticsEvent (
	analyticsEventId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	anonymousUserId LONG,
	eventType VARCHAR(75) null,
	className VARCHAR(75) null,
	classPK LONG,
	referrerClassName VARCHAR(75) null,
	referrerClassPK LONG,
	clientIP VARCHAR(75) null,
	userAgent VARCHAR(75) null,
	languageId VARCHAR(75) null,
	URL VARCHAR(75) null,
	additionalInfo VARCHAR(75) null
);