create table GEO_Geolocation (
	uuid_ VARCHAR(75) null,
	geolocationId LONG not null primary key,
	companyId LONG,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	latitude DOUBLE,
	longitude DOUBLE,
	areaCode VARCHAR(75) null,
	city VARCHAR(75) null,
	countryCode VARCHAR(75) null,
	countryName VARCHAR(75) null,
	metroCode VARCHAR(75) null,
	regionCode VARCHAR(75) null,
	regionName VARCHAR(75) null,
	zipCode VARCHAR(75) null
);