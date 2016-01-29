create index IX_9426B172 on CT_Analytics_AnalyticsEvent (anonymousUserId, className[$COLUMN_LENGTH:75$], classPK, eventType[$COLUMN_LENGTH:75$]);
create index IX_24B2DBB1 on CT_Analytics_AnalyticsEvent (className[$COLUMN_LENGTH:75$], classPK, eventType[$COLUMN_LENGTH:75$], createDate);
create index IX_C24D66E0 on CT_Analytics_AnalyticsEvent (classPK, createDate);
create index IX_977A23E5 on CT_Analytics_AnalyticsEvent (companyId, createDate);
create index IX_ABBA8EFC on CT_Analytics_AnalyticsEvent (elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$], createDate);

create index IX_9E01B1B7 on CT_Analytics_AnalyticsReferrer (analyticsEventId, referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK);
create index IX_83CCD014 on CT_Analytics_AnalyticsReferrer (referrerClassName[$COLUMN_LENGTH:75$], referrerClassPK);