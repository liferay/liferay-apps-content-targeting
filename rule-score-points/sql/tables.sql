create table CT_ScorePoints_ScorePoint (
	uuid_ VARCHAR(75) null,
	scorePointId LONG not null primary key,
	anonymousUserId LONG,
	userSegmentId LONG,
	points LONG
);