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
	userAgent STRING null,
	languageId VARCHAR(75) null,
	URL STRING null,
	additionalInfo TEXT null
);