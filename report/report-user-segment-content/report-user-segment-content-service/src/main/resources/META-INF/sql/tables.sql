create table CT_USCR_UserSegmentContent (
	userSegmentContentId LONG not null primary key,
	companyId LONG,
	userSegmentId LONG,
	classNameId LONG,
	classPK LONG,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);