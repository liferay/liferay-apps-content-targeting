create index IX_7C956EF1 on ContentTargeting_AnalyticsEvent (className, classPK, eventType, createDate);
create index IX_127B09E1 on ContentTargeting_AnalyticsEvent (className, classPK, referrerClassName, referrerClassPK, eventType, createDate);
create index IX_2C3CAAE7 on ContentTargeting_AnalyticsEvent (companyId);
create index IX_AB76D725 on ContentTargeting_AnalyticsEvent (companyId, createDate);
create index IX_A54953BC on ContentTargeting_AnalyticsEvent (elementId, eventType, createDate);
create index IX_35F29ACC on ContentTargeting_AnalyticsEvent (referrerClassName, referrerClassPK, elementId, eventType, createDate);