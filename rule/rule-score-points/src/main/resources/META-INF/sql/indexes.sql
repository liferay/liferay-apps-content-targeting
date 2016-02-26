create unique index IX_DC6100CC on CT_ScorePoints_ScorePoint (anonymousUserId, userSegmentId);
create index IX_6C7FE3F7 on CT_ScorePoints_ScorePoint (userSegmentId);
create index IX_5E8C8F90 on CT_ScorePoints_ScorePoint (uuid_[$COLUMN_LENGTH:75$], companyId);