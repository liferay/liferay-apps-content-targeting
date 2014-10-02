create index IX_9426B172 on CT_Analytics_AnalyticsEvent (anonymousUserId, className, classPK, eventType);
create index IX_48522173 on CT_Analytics_AnalyticsEvent (className, classPK, eventType);
create index IX_24B2DBB1 on CT_Analytics_AnalyticsEvent (className, classPK, eventType, createDate);
create index IX_C24D66E0 on CT_Analytics_AnalyticsEvent (classPK, createDate);
create index IX_6F3D17A7 on CT_Analytics_AnalyticsEvent (companyId);
create index IX_977A23E5 on CT_Analytics_AnalyticsEvent (companyId, createDate);
create index IX_ABBA8EFC on CT_Analytics_AnalyticsEvent (elementId, eventType, createDate);

create index IX_9E01B1B7 on CT_Analytics_AnalyticsReferrer (analyticsEventId, referrerClassName, referrerClassPK);
create index IX_83CCD014 on CT_Analytics_AnalyticsReferrer (referrerClassName, referrerClassPK);