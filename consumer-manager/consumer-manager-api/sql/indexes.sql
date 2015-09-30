create index IX_6FC93237 on CM_Consumer (companyId);
create unique index IX_3FD677A2 on CM_Consumer (companyId, consumerKey);
create index IX_33A85B6 on CM_Consumer (consumerId);
create index IX_F962B743 on CM_Consumer (uuid_);
create index IX_938D3505 on CM_Consumer (uuid_, companyId);

create index IX_EBA80E59 on CM_ConsumerExtensionInstance (companyId);
create index IX_3EDDCCC3 on CM_ConsumerExtensionInstance (companyId, consumerExtensionKey);
create index IX_D21E5459 on CM_ConsumerExtensionInstance (consumerExtensionKey);
create index IX_3372DD4 on CM_ConsumerExtensionInstance (consumerId);
create index IX_58904DFE on CM_ConsumerExtensionInstance (consumerId, consumerExtensionKey);
create index IX_3AC8F465 on CM_ConsumerExtensionInstance (uuid_);
create index IX_F066CEA3 on CM_ConsumerExtensionInstance (uuid_, companyId);