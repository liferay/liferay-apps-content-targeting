create unique index IX_8072DB73 on GEO_Geolocation (classNameId, classPK);
create index IX_B922C09F on GEO_Geolocation (companyId, classNameId, classPK);
create index IX_9DFA772A on GEO_Geolocation (companyId, modifiedDate, classNameId, classPK);
create index IX_5C846856 on GEO_Geolocation (uuid_);
create index IX_7522A12 on GEO_Geolocation (uuid_, companyId);