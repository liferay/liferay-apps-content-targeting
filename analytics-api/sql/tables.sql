create table CT_Analytics_AnalyticsEvent (
	analyticsEventId LONG not null primary key,
	companyId LONG,
	userId LONG,
	anonymousUserId LONG,
	className VARCHAR(75) null,
	classPK LONG,
	elementId VARCHAR(75) null,
	eventType VARCHAR(75) null,
	clientIP VARCHAR(75) null,
	userAgent STRING null,
	languageId VARCHAR(75) null,
	URL STRING null,
	additionalInfo TEXT null,
	createDate DATE null
);

create table CT_Analytics_AnalyticsReferrer (
	analyticsReferrerId LONG not null primary key,
	analyticsEventId LONG,
	referrerClassName VARCHAR(75) null,
	referrerClassPK LONG
);