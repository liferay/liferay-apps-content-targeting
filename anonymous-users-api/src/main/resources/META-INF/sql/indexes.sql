create index IX_EB2DCDA8 on AnonymousUser (companyId, createDate);
create index IX_16D875B8 on AnonymousUser (userId);
create index IX_B8A559F2 on AnonymousUser (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_200C15C5 on CT_AU_AnonymousUser (companyId, createDate);
create index IX_1138973B on CT_AU_AnonymousUser (userId);
create index IX_E717B3B5 on CT_AU_AnonymousUser (uuid_[$COLUMN_LENGTH:75$], companyId);