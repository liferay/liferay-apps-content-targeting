create index IX_F70FCB88 on CT_USCReport_UserSegmentContent (userSegmentId);
create unique index IX_1F4D86EC on CT_USCReport_UserSegmentContent (userSegmentId, className, classPK, eventType);
create index IX_C35417D3 on CT_USCReport_UserSegmentContent (userSegmentId, modifiedDate);