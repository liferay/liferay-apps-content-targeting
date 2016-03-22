create index IX_20FA6B2B on AnalyticsEvent (anonymousUserId, classNameId, classPK, eventType[$COLUMN_LENGTH:75$]);
create index IX_9C7E3258 on AnalyticsEvent (classNameId, classPK, eventType[$COLUMN_LENGTH:75$], createDate);
create index IX_625F34C7 on AnalyticsEvent (classPK, createDate);
create index IX_7A50140C on AnalyticsEvent (companyId, createDate);
create index IX_D8DED075 on AnalyticsEvent (elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$], createDate);

create index IX_6A60D81E on AnalyticsReferrer (analyticsEventId, referrerClassNameId, referrerClassPK);
create index IX_A6A3923B on AnalyticsReferrer (referrerClassNameId, referrerClassPK);

create index IX_903070AD on CT_Analytics_AnalyticsEvent (anonymousUserId, classNameId, classPK, eventType[$COLUMN_LENGTH:75$]);
create index IX_ED84FE2C on CT_Analytics_AnalyticsEvent (classNameId, classPK, eventType[$COLUMN_LENGTH:75$], createDate);
create index IX_C24D66E0 on CT_Analytics_AnalyticsEvent (classPK, createDate);
create index IX_977A23E5 on CT_Analytics_AnalyticsEvent (companyId, createDate);
create index IX_ABBA8EFC on CT_Analytics_AnalyticsEvent (elementId[$COLUMN_LENGTH:75$], eventType[$COLUMN_LENGTH:75$], createDate);

create index IX_E58FFB5C on CT_Analytics_AnalyticsReferrer (analyticsEventId, referrerClassNameId, referrerClassPK);
create index IX_850CF679 on CT_Analytics_AnalyticsReferrer (referrerClassNameId, referrerClassPK);