create table CT_CCR_CampaignContent (
	campaignContentId LONG not null primary key,
	companyId LONG,
	campaignId LONG,
	className VARCHAR(75) null,
	classPK LONG,
	eventType VARCHAR(75) null,
	count INTEGER,
	modifiedDate DATE null
);