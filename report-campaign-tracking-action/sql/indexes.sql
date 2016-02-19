create index IX_727EFD3E on CT_CTA_CTAction (campaignId, elementId[$COLUMN_LENGTH:75$]);
create index IX_E0B260D4 on CT_CTA_CTAction (campaignId, modifiedDate);
create index IX_AF0AD159 on CT_CTA_CTAction (campaignId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK);
create unique index IX_8395BFD7 on CT_CTA_CTAction (campaignId, userSegmentId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);
create index IX_7F103045 on CT_CTA_CTAction (reportInstanceId, elementId[$COLUMN_LENGTH:75$]);
create index IX_55B37C6D on CT_CTA_CTAction (reportInstanceId, modifiedDate);
create index IX_901A4432 on CT_CTA_CTAction (reportInstanceId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK);
create unique index IX_B8AC509E on CT_CTA_CTAction (reportInstanceId, userSegmentId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);

create index IX_B4FA1370 on CT_CTA_CTActionTotal (campaignId, modifiedDate);
create unique index IX_3849A752 on CT_CTA_CTActionTotal (campaignId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);
create index IX_EA39CA09 on CT_CTA_CTActionTotal (reportInstanceId, modifiedDate);
create unique index IX_7F649C6B on CT_CTA_CTActionTotal (reportInstanceId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);