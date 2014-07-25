create index IX_EB75EA58 on ContentTargeting_Analytics_AnalyticsEvent (className, classPK, eventType, createDate);
create index IX_1C801DC8 on ContentTargeting_Analytics_AnalyticsEvent (className, classPK, referrerClassName, referrerClassPK, eventType, createDate);
create index IX_466C824E on ContentTargeting_Analytics_AnalyticsEvent (companyId);
create index IX_F853CC0C on ContentTargeting_Analytics_AnalyticsEvent (companyId, createDate);
create index IX_39D81875 on ContentTargeting_Analytics_AnalyticsEvent (elementId, eventType, createDate);
create index IX_CDB73705 on ContentTargeting_Analytics_AnalyticsEvent (referrerClassName, referrerClassPK, elementId, eventType, createDate);