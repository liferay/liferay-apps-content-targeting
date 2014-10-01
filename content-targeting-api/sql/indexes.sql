create index IX_80FBFA6 on CT_Campaign (groupId);
create index IX_DB3D03B0 on CT_Campaign (uuid_);
create index IX_E92ED278 on CT_Campaign (uuid_, companyId);
create unique index IX_EAB996FA on CT_Campaign (uuid_, groupId);

create index IX_195BA1BA on CT_Campaigns_UserSegments (campaignId);
create index IX_3D78FE78 on CT_Campaigns_UserSegments (userSegmentId);

create index IX_3E22574D on CT_ReportInstance (className, classPK);
create unique index IX_956562EE on CT_ReportInstance (reportKey, className, classPK);

create index IX_B034D565 on CT_RuleInstance (groupId);
create index IX_98186965 on CT_RuleInstance (ruleKey, userSegmentId);
create index IX_29BE548E on CT_RuleInstance (userSegmentId);
create index IX_74DA7D2F on CT_RuleInstance (uuid_);
create index IX_E3BCC399 on CT_RuleInstance (uuid_, companyId);
create unique index IX_B8A35C5B on CT_RuleInstance (uuid_, groupId);

create index IX_E9845BF5 on CT_TrackingActionInstance (campaignId);
create index IX_8DDDDC52 on CT_TrackingActionInstance (campaignId, elementId, eventType);
create index IX_A96A17F on CT_TrackingActionInstance (campaignId, referrerClassName, referrerClassPK, eventType);
create index IX_8EAC9E74 on CT_TrackingActionInstance (groupId);
create index IX_E97F3DFE on CT_TrackingActionInstance (uuid_);
create index IX_5544BB6A on CT_TrackingActionInstance (uuid_, companyId);
create unique index IX_D8B9146C on CT_TrackingActionInstance (uuid_, groupId);

create index IX_34C5416A on CT_UserSegment (groupId);
create index IX_78302674 on CT_UserSegment (uuid_);
create index IX_42550D34 on CT_UserSegment (uuid_, companyId);
create unique index IX_F86750B6 on CT_UserSegment (uuid_, groupId);