create index IX_80FBFA6 on CT_Campaign (groupId);
create index IX_DB3D03B0 on CT_Campaign (uuid_);
create index IX_E92ED278 on CT_Campaign (uuid_, companyId);
create unique index IX_EAB996FA on CT_Campaign (uuid_, groupId);

create index IX_195BA1BA on CT_Campaigns_UserSegments (campaignId);
create index IX_3D78FE78 on CT_Campaigns_UserSegments (userSegmentId);

create index IX_B9B4D73A on CT_Rule (groupId);
create index IX_30AAF044 on CT_Rule (uuid_);
create index IX_14C90164 on CT_Rule (uuid_, companyId);
create unique index IX_4EAA90E6 on CT_Rule (uuid_, groupId);

create index IX_B034D565 on CT_RuleInstance (groupId);
create index IX_98186965 on CT_RuleInstance (ruleKey, userSegmentId);
create index IX_29BE548E on CT_RuleInstance (userSegmentId);
create index IX_74DA7D2F on CT_RuleInstance (uuid_);
create index IX_E3BCC399 on CT_RuleInstance (uuid_, companyId);
create unique index IX_B8A35C5B on CT_RuleInstance (uuid_, groupId);

create index IX_34C5416A on CT_UserSegment (groupId);
create index IX_78302674 on CT_UserSegment (uuid_);
create index IX_42550D34 on CT_UserSegment (uuid_, companyId);
create unique index IX_F86750B6 on CT_UserSegment (uuid_, groupId);