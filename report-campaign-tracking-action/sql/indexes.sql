create index IX_470B7A49 on CT_CTA_CTAction (campaignId);
create index IX_727EFD3E on CT_CTA_CTAction (campaignId, elementId);
create index IX_E0B260D4 on CT_CTA_CTAction (campaignId, modifiedDate);
create index IX_AF0AD159 on CT_CTA_CTAction (campaignId, referrerClassName, referrerClassPK);
create unique index IX_8395BFD7 on CT_CTA_CTAction (campaignId, userSegmentId, referrerClassName, referrerClassPK, elementId, eventType);

create index IX_F973ADE5 on CT_CTA_CTActionTotal (campaignId);
create index IX_B4FA1370 on CT_CTA_CTActionTotal (campaignId, modifiedDate);
create unique index IX_3849A752 on CT_CTA_CTActionTotal (campaignId, referrerClassName, referrerClassPK, elementId, eventType);