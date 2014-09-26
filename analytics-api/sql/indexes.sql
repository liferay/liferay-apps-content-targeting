create index IX_9015B32B on ContentTargeting_Analytics_AnalyticsEvent (anonymousUserId, className, classPK, eventType);
create index IX_3F70B29A on ContentTargeting_Analytics_AnalyticsEvent (className, classPK, eventType);
create index IX_EB75EA58 on ContentTargeting_Analytics_AnalyticsEvent (className, classPK, eventType, createDate);
create index IX_466C824E on ContentTargeting_Analytics_AnalyticsEvent (companyId);
create index IX_F853CC0C on ContentTargeting_Analytics_AnalyticsEvent (companyId, createDate);
create index IX_39D81875 on ContentTargeting_Analytics_AnalyticsEvent (elementId, eventType, createDate);

create index IX_7176901E on ContentTargeting_Analytics_AnalyticsReferrer (analyticsEventId, referrerClassName, referrerClassPK);