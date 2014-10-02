create index IX_9DFB178 on CT_USCR_UserSegmentContent (userSegmentId);
create unique index IX_48FCE2FC on CT_USCR_UserSegmentContent (userSegmentId, className, classPK, eventType);
create index IX_C3A2D9C3 on CT_USCR_UserSegmentContent (userSegmentId, modifiedDate);