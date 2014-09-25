create index IX_BB2B560D on ContentTargeting_Campaign (groupId);
create index IX_E14907D7 on ContentTargeting_Campaign (uuid_);
create index IX_D6487FF1 on ContentTargeting_Campaign (uuid_, companyId);
create unique index IX_4F224EB3 on ContentTargeting_Campaign (uuid_, groupId);

create index IX_30D0C633 on ContentTargeting_Campaigns_UserSegments (campaignId);
create index IX_6785B5F on ContentTargeting_Campaigns_UserSegments (userSegmentId);

create index IX_55977BC6 on ContentTargeting_ReportInstance (className, classPK);
create unique index IX_5108E8D5 on ContentTargeting_ReportInstance (reportKey, className, classPK);

create index IX_A540E04C on ContentTargeting_RuleInstance (groupId);
create index IX_A6D6539E on ContentTargeting_RuleInstance (ruleKey, userSegmentId);
create index IX_DFDA5635 on ContentTargeting_RuleInstance (userSegmentId);
create index IX_CF6A15D6 on ContentTargeting_RuleInstance (uuid_);
create index IX_28E10C92 on ContentTargeting_RuleInstance (uuid_, companyId);
create unique index IX_C6078F94 on ContentTargeting_RuleInstance (uuid_, groupId);

create index IX_F9806E on ContentTargeting_TrackingActionInstance (campaignId);
create index IX_7A91700B on ContentTargeting_TrackingActionInstance (campaignId, elementId, eventType);
create index IX_DE0B7FE6 on ContentTargeting_TrackingActionInstance (campaignId, referrerClassName, referrerClassPK, eventType);
create index IX_EE11749B on ContentTargeting_TrackingActionInstance (groupId);
create index IX_88A171E5 on ContentTargeting_TrackingActionInstance (uuid_);
create index IX_A220E123 on ContentTargeting_TrackingActionInstance (uuid_, companyId);
create unique index IX_2FA55465 on ContentTargeting_TrackingActionInstance (uuid_, groupId);

create index IX_2C28BDA3 on ContentTargeting_UserSegment (groupId);
create index IX_28875CED on ContentTargeting_UserSegment (uuid_);
create index IX_E177411B on ContentTargeting_UserSegment (uuid_, companyId);
create unique index IX_AE83525D on ContentTargeting_UserSegment (uuid_, groupId);