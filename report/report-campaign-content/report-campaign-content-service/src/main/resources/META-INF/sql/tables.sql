create table CT_CCR_CampaignContent (
	campaignContentId LONG not null primary key,
	companyId LONG,
	campaignId LONG,
	classNameId LONG,
	classPK LONG,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);