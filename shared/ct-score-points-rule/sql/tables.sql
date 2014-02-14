create table CT_ScorePoint (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	CTUserId LONG,
	assetCategoryId LONG,
	points LONG
);

create table ScorePoints_ScorePoint (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	CTUserId LONG,
	assetCategoryId LONG,
	points LONG
);