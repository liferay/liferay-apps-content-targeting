create table ScorePoints_ScorePoint (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	anonymousUserId LONG,
	userSegmentId LONG,
	points LONG
);