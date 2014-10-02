create table CT_USCR_UserSegmentContent (
	userSegmentContentId LONG not null primary key,
	userSegmentId LONG,
	className VARCHAR(75) null,
	classPK LONG,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);