create index IX_95B0BCB5 on ContentTargeting_UserSegmentContent (userSegmentId);
create index IX_949B01F on ContentTargeting_UserSegmentContent (userSegmentId, className, classPK, eventType);
create index IX_A48CF640 on ContentTargeting_UserSegmentContent (userSegmentId, modifiedDate);