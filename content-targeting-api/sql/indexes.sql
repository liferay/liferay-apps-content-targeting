create index IX_C36CE59F on CT_AnonymousUserUserSegment (anonymousUserId);
create index IX_C9016C4A on CT_AnonymousUserUserSegment (anonymousUserId, active_);
create index IX_6D0EF494 on CT_AnonymousUserUserSegment (anonymousUserId, userSegmentId);
create index IX_A41860F5 on CT_AnonymousUserUserSegment (anonymousUserId, userSegmentId, active_);
create index IX_5370A08F on CT_AnonymousUserUserSegment (companyId, modifiedDate);
create index IX_BD1F5349 on CT_AnonymousUserUserSegment (companyId, modifiedDate, manual);
create index IX_5CDDC72F on CT_AnonymousUserUserSegment (userSegmentId);
create index IX_C34D4CBA on CT_AnonymousUserUserSegment (userSegmentId, active_);
create index IX_BE4320D0 on CT_AnonymousUserUserSegment (uuid_);
create index IX_1C594158 on CT_AnonymousUserUserSegment (uuid_, companyId);

create index IX_80FBFA6 on CT_Campaign (groupId);
create index IX_DB3D03B0 on CT_Campaign (uuid_);
create index IX_E92ED278 on CT_Campaign (uuid_, companyId);
create unique index IX_EAB996FA on CT_Campaign (uuid_, groupId);

create index IX_195BA1BA on CT_Campaigns_UserSegments (campaignId);
create index IX_3D78FE78 on CT_Campaigns_UserSegments (userSegmentId);

create index IX_D1C60A0F on CT_ChannelInstance (campaignId);
create index IX_8295369A on CT_ChannelInstance (groupId);
create index IX_413DB2B7 on CT_ChannelInstance (tacticId);
create unique index IX_E6281B7A on CT_ChannelInstance (tacticId, alias_);
create index IX_C2DBA7A4 on CT_ChannelInstance (uuid_);
create index IX_246DEE04 on CT_ChannelInstance (uuid_, companyId);
create unique index IX_4DE22586 on CT_ChannelInstance (uuid_, groupId);

create index IX_3E22574D on CT_ReportInstance (className, classPK);
create unique index IX_956562EE on CT_ReportInstance (reportKey, className, classPK);

create index IX_B034D565 on CT_RuleInstance (groupId);
create index IX_98186965 on CT_RuleInstance (ruleKey, userSegmentId);
create index IX_29BE548E on CT_RuleInstance (userSegmentId);
create index IX_74DA7D2F on CT_RuleInstance (uuid_);
create index IX_E3BCC399 on CT_RuleInstance (uuid_, companyId);
create unique index IX_B8A35C5B on CT_RuleInstance (uuid_, groupId);

create index IX_8AD0D32B on CT_Tactic (campaignId);
create index IX_52D862FE on CT_Tactic (groupId);
create index IX_B2069D08 on CT_Tactic (uuid_);
create index IX_FBAC7220 on CT_Tactic (uuid_, companyId);
create unique index IX_83EB00A2 on CT_Tactic (uuid_, groupId);

create index IX_80BC7ACA on CT_Tactics_UserSegments (tacticId);
create index IX_D2685D0 on CT_Tactics_UserSegments (userSegmentId);

create index IX_E9845BF5 on CT_TrackingActionInstance (campaignId);
create unique index IX_FE48A6B8 on CT_TrackingActionInstance (campaignId, alias_);
create index IX_8DDDDC52 on CT_TrackingActionInstance (campaignId, elementId, eventType);
create index IX_A96A17F on CT_TrackingActionInstance (campaignId, referrerClassName, referrerClassPK, eventType);
create index IX_8EAC9E74 on CT_TrackingActionInstance (groupId);
create index IX_E97F3DFE on CT_TrackingActionInstance (uuid_);
create index IX_5544BB6A on CT_TrackingActionInstance (uuid_, companyId);
create unique index IX_D8B9146C on CT_TrackingActionInstance (uuid_, groupId);

create index IX_E2256979 on CT_UserSegment (assetCategoryId);
create index IX_34C5416A on CT_UserSegment (groupId);
create index IX_78302674 on CT_UserSegment (uuid_);
create index IX_42550D34 on CT_UserSegment (uuid_, companyId);
create unique index IX_F86750B6 on CT_UserSegment (uuid_, groupId);