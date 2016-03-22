create index IX_470B7A49 on CT_CTA_CTAction (campaignId);
create index IX_7F103045 on CT_CTA_CTAction (reportInstanceId, elementId[$COLUMN_LENGTH:75$]);
create index IX_55B37C6D on CT_CTA_CTAction (reportInstanceId, modifiedDate);
create index IX_B3CDDB17 on CT_CTA_CTAction (reportInstanceId, referrerClassNameId, referrerClassPK);
create unique index IX_B8AC509E on CT_CTA_CTAction (reportInstanceId, userSegmentId, referrerClassNameId, referrerClassPK, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);

create index IX_F973ADE5 on CT_CTA_CTActionTotal (campaignId);
create index IX_EA39CA09 on CT_CTA_CTActionTotal (reportInstanceId, modifiedDate);
create unique index IX_7F649C6B on CT_CTA_CTActionTotal (reportInstanceId, referrerClassNameId, referrerClassPK, elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$]);