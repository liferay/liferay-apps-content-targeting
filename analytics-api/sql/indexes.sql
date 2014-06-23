create index IX_6110241 on Analytics_AnalyticsEvent (className, classPK, createDate);
create index IX_658AD8FF on Analytics_AnalyticsEvent (className, classPK, eventType, createDate);
create index IX_E20EEC51 on Analytics_AnalyticsEvent (className, classPK, referrerClassName, referrerClassPK, createDate);
create index IX_F5B104EF on Analytics_AnalyticsEvent (className, classPK, referrerClassName, referrerClassPK, eventType, createDate);
create index IX_906DCCF5 on Analytics_AnalyticsEvent (companyId);
create index IX_C02F5433 on Analytics_AnalyticsEvent (companyId, createDate);