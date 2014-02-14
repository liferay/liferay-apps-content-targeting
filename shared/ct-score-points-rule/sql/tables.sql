create table ScorePoints_ScorePoint (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	CTUserId LONG,
	userSegmentId LONG,
	points LONG
);