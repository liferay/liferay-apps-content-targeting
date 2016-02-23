create index IX_FE21B13C on AnonymousUserUserSegment (anonymousUserId, active_);
create index IX_73903C06 on AnonymousUserUserSegment (anonymousUserId, userSegmentId);
create index IX_86C6FA17 on AnonymousUserUserSegment (companyId, modifiedDate, manual);
create index IX_B13E262C on AnonymousUserUserSegment (userSegmentId, active_);

create index IX_C9016C4A on CT_AnonymousUserUserSegment (anonymousUserId, active_);
create index IX_6D0EF494 on CT_AnonymousUserUserSegment (anonymousUserId, userSegmentId);
create index IX_BD1F5349 on CT_AnonymousUserUserSegment (companyId, modifiedDate, manual);
create index IX_C34D4CBA on CT_AnonymousUserUserSegment (userSegmentId, active_);

create index IX_80FBFA6 on CT_Campaign (groupId);
create index IX_E92ED278 on CT_Campaign (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EAB996FA on CT_Campaign (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_195BA1BA on CT_Campaigns_UserSegments (campaignId);
create index IX_B74510D on CT_Campaigns_UserSegments (companyId);
create index IX_3D78FE78 on CT_Campaigns_UserSegments (userSegmentId);

create index IX_E885DD5F on CT_ChannelInstance (campaignId, channelKey[$COLUMN_LENGTH:75$]);
create index IX_C18B29E0 on CT_ChannelInstance (channelKey[$COLUMN_LENGTH:75$]);
create index IX_8295369A on CT_ChannelInstance (groupId);
create unique index IX_E6281B7A on CT_ChannelInstance (tacticId, alias_[$COLUMN_LENGTH:75$]);
create index IX_5FBDCA07 on CT_ChannelInstance (tacticId, channelKey[$COLUMN_LENGTH:75$]);
create index IX_246DEE04 on CT_ChannelInstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4DE22586 on CT_ChannelInstance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3E22574D on CT_ReportInstance (className[$COLUMN_LENGTH:75$], classPK);
create index IX_956562EE on CT_ReportInstance (reportKey[$COLUMN_LENGTH:75$], className[$COLUMN_LENGTH:75$], classPK);
create index IX_CDD8AA51 on CT_ReportInstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FF799113 on CT_ReportInstance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B034D565 on CT_RuleInstance (groupId);
create index IX_98186965 on CT_RuleInstance (ruleKey[$COLUMN_LENGTH:75$], userSegmentId);
create index IX_29BE548E on CT_RuleInstance (userSegmentId);
create index IX_E3BCC399 on CT_RuleInstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B8A35C5B on CT_RuleInstance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8AD0D32B on CT_Tactic (campaignId);
create index IX_52D862FE on CT_Tactic (groupId);
create index IX_FBAC7220 on CT_Tactic (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_83EB00A2 on CT_Tactic (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A8FB4465 on CT_Tactics_UserSegments (companyId);
create index IX_80BC7ACA on CT_Tactics_UserSegments (tacticId);
create index IX_D2685D0 on CT_Tactics_UserSegments (userSegmentId);

create unique index IX_FE48A6B8 on CT_TrackingActionInstance (campaignId, alias_[$COLUMN_LENGTH:75$]);
create index IX_8DDDDC52 on CT_TrackingActionInstance (campaignId, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);
create index IX_A96A17F on CT_TrackingActionInstance (campaignId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK, eventType[$COLUMN_LENGTH:75$]);
create index IX_8EAC9E74 on CT_TrackingActionInstance (groupId);
create unique index IX_5D0CB811 on CT_TrackingActionInstance (reportInstanceId, alias_[$COLUMN_LENGTH:75$]);
create index IX_94F81DEB on CT_TrackingActionInstance (reportInstanceId, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);
create index IX_9DBA2E06 on CT_TrackingActionInstance (reportInstanceId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK, eventType[$COLUMN_LENGTH:75$]);
create index IX_5544BB6A on CT_TrackingActionInstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D8B9146C on CT_TrackingActionInstance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E2256979 on CT_UserSegment (assetCategoryId);
create index IX_34C5416A on CT_UserSegment (groupId);
create index IX_42550D34 on CT_UserSegment (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F86750B6 on CT_UserSegment (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_BBD0CC74 on Campaign (groupId);
create index IX_E2F44D6A on Campaign (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D125266C on Campaign (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_43B80AAC on Campaigns_UserSegments (campaignId);
create index IX_FC4E01DB on Campaigns_UserSegments (companyId);
create index IX_D5519846 on Campaigns_UserSegments (userSegmentId);

create index IX_EC9F3BAD on ChannelInstance (campaignId, channelKey[$COLUMN_LENGTH:75$]);
create index IX_750D2E on ChannelInstance (channelKey[$COLUMN_LENGTH:75$]);
create index IX_6900C60C on ChannelInstance (groupId);
create unique index IX_D701CC48 on ChannelInstance (tacticId, alias_[$COLUMN_LENGTH:75$]);
create index IX_F79663D5 on ChannelInstance (tacticId, channelKey[$COLUMN_LENGTH:75$]);
create index IX_15479ED2 on ChannelInstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_736DB1D4 on ChannelInstance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_687EC03F on ReportInstance (className[$COLUMN_LENGTH:75$], classPK);
create index IX_AA64EBC on ReportInstance (reportKey[$COLUMN_LENGTH:75$], className[$COLUMN_LENGTH:75$], classPK);
create index IX_59BEA7C3 on ReportInstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_53444305 on ReportInstance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4FE6CB33 on RuleInstance (groupId);
create index IX_9CFE5DD7 on RuleInstance (ruleKey[$COLUMN_LENGTH:75$], userSegmentId);
create index IX_68A837DC on RuleInstance (userSegmentId);
create index IX_3787758B on RuleInstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_56F5E2CD on RuleInstance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4F31601D on Tactic (campaignId);
create index IX_45724B4C on Tactic (groupId);
create index IX_E2180192 on Tactic (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DA77C494 on Tactic (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CE86D0B3 on Tactics_UserSegments (companyId);
create index IX_D4872CBC on Tactics_UserSegments (tacticId);
create index IX_2E573B1E on Tactics_UserSegments (userSegmentId);

create unique index IX_26DFDAA on TrackingActionInstance (campaignId, alias_[$COLUMN_LENGTH:75$]);
create index IX_945F23C4 on TrackingActionInstance (campaignId, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);
create index IX_C00A3E4D on TrackingActionInstance (campaignId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK, eventType[$COLUMN_LENGTH:75$]);
create index IX_B4382AC2 on TrackingActionInstance (groupId);
create unique index IX_4AFD9183 on TrackingActionInstance (reportInstanceId, alias_[$COLUMN_LENGTH:75$]);
create index IX_5FAE87DD on TrackingActionInstance (reportInstanceId, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);
create index IX_E4C7854 on TrackingActionInstance (reportInstanceId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK, eventType[$COLUMN_LENGTH:75$]);
create index IX_D45726DC on TrackingActionInstance (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3BF3B45E on TrackingActionInstance (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8077EFEB on UserSegment (assetCategoryId);
create index IX_633659DC on UserSegment (groupId);
create index IX_6E535502 on UserSegment (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_37513404 on UserSegment (uuid_[$COLUMN_LENGTH:75$], groupId);