



insert into AssetVocabulary values ('00000000-0000-0000-0000-00061ad0', 700300, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'User Segment', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment</Title></root>', '', 'multiValued=true\nselectedClassNameIds=0');


		insert into ResourcePermission values (300117, 162, 'com.liferay.portlet.asset.model.AssetVocabulary', 4, '700300', 170, 0, 1);
		insert into ResourcePermission values (300118, 162, 'com.liferay.portlet.asset.model.AssetVocabulary', 4, '700300', 174, 166, 1);
		insert into ResourcePermission values (300119, 162, 'com.liferay.portlet.asset.model.AssetVocabulary', 4, '700300', 177, 0, 1);



	insert into AssetCategory values ('00000000-0000-0000-0000-00061aea', 700326, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 2, 3, 'User Segment 0', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 0</Title></root>', '', 700300);


		insert into ResourcePermission values (300120, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700326', 170, 0, 1);
		insert into ResourcePermission values (300121, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700326', 174, 166, 1);
		insert into ResourcePermission values (300122, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700326', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700326, 208);
	insert into AssetEntries_AssetCategories values (700326, 222);
	insert into AssetEntries_AssetCategories values (700326, 236);
	insert into AssetEntries_AssetCategories values (700326, 250);
	insert into AssetEntries_AssetCategories values (700326, 264);
	insert into AssetEntries_AssetCategories values (700326, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ad1', 700301, 1, 700326, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 0</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 0</Description></root>');


		insert into ResourcePermission values (300123, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700301', 170, 0, 1);
		insert into ResourcePermission values (300124, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700301', 174, 166, 1);
		insert into ResourcePermission values (300125, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700301', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061aeb', 700327, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700301, '');


		insert into ResourcePermission values (300126, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700327', 170, 0, 1);
		insert into ResourcePermission values (300127, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700327', 174, 166, 1);
		insert into ResourcePermission values (300128, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700327', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061aec', 700328, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700301, 'male');


		insert into ResourcePermission values (300129, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700328', 170, 0, 1);
		insert into ResourcePermission values (300130, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700328', 174, 166, 1);
		insert into ResourcePermission values (300131, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700328', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061aed', 700329, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700301, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300132, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700329', 170, 0, 1);
		insert into ResourcePermission values (300133, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700329', 174, 166, 1);
		insert into ResourcePermission values (300134, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700329', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061aee', 700330, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700301, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300135, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700330', 170, 0, 1);
		insert into ResourcePermission values (300136, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700330', 174, 166, 1);
		insert into ResourcePermission values (300137, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700330', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061aef', 700331, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700301, '1');


		insert into ResourcePermission values (300138, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700331', 170, 0, 1);
		insert into ResourcePermission values (300139, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700331', 174, 166, 1);
		insert into ResourcePermission values (300140, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700331', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061af0', 700332, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 4, 5, 'User Segment 1', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 1</Title></root>', '', 700300);


		insert into ResourcePermission values (300141, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700332', 170, 0, 1);
		insert into ResourcePermission values (300142, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700332', 174, 166, 1);
		insert into ResourcePermission values (300143, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700332', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700332, 208);
	insert into AssetEntries_AssetCategories values (700332, 222);
	insert into AssetEntries_AssetCategories values (700332, 236);
	insert into AssetEntries_AssetCategories values (700332, 250);
	insert into AssetEntries_AssetCategories values (700332, 264);
	insert into AssetEntries_AssetCategories values (700332, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ad2', 700302, 1, 700332, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 1</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 1</Description></root>');


		insert into ResourcePermission values (300144, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700302', 170, 0, 1);
		insert into ResourcePermission values (300145, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700302', 174, 166, 1);
		insert into ResourcePermission values (300146, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700302', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061af1', 700333, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700302, '');


		insert into ResourcePermission values (300147, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700333', 170, 0, 1);
		insert into ResourcePermission values (300148, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700333', 174, 166, 1);
		insert into ResourcePermission values (300149, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700333', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061af2', 700334, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700302, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300150, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700334', 170, 0, 1);
		insert into ResourcePermission values (300151, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700334', 174, 166, 1);
		insert into ResourcePermission values (300152, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700334', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061af3', 700335, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700302, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300153, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700335', 170, 0, 1);
		insert into ResourcePermission values (300154, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700335', 174, 166, 1);
		insert into ResourcePermission values (300155, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700335', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061af4', 700336, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700302, 'male');


		insert into ResourcePermission values (300156, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700336', 170, 0, 1);
		insert into ResourcePermission values (300157, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700336', 174, 166, 1);
		insert into ResourcePermission values (300158, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700336', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061af5', 700337, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700302, 'Firefox');


		insert into ResourcePermission values (300159, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700337', 170, 0, 1);
		insert into ResourcePermission values (300160, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700337', 174, 166, 1);
		insert into ResourcePermission values (300161, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700337', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061af6', 700338, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 6, 7, 'User Segment 2', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 2</Title></root>', '', 700300);


		insert into ResourcePermission values (300162, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700338', 170, 0, 1);
		insert into ResourcePermission values (300163, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700338', 174, 166, 1);
		insert into ResourcePermission values (300164, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700338', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700338, 208);
	insert into AssetEntries_AssetCategories values (700338, 222);
	insert into AssetEntries_AssetCategories values (700338, 236);
	insert into AssetEntries_AssetCategories values (700338, 250);
	insert into AssetEntries_AssetCategories values (700338, 264);
	insert into AssetEntries_AssetCategories values (700338, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ad3', 700303, 1, 700338, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 2</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 2</Description></root>');


		insert into ResourcePermission values (300165, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700303', 170, 0, 1);
		insert into ResourcePermission values (300166, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700303', 174, 166, 1);
		insert into ResourcePermission values (300167, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700303', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061af7', 700339, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700303, '');


		insert into ResourcePermission values (300168, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700339', 170, 0, 1);
		insert into ResourcePermission values (300169, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700339', 174, 166, 1);
		insert into ResourcePermission values (300170, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700339', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061af8', 700340, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700303, '1');


		insert into ResourcePermission values (300171, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700340', 170, 0, 1);
		insert into ResourcePermission values (300172, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700340', 174, 166, 1);
		insert into ResourcePermission values (300173, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700340', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061af9', 700341, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700303, '1');


		insert into ResourcePermission values (300174, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700341', 170, 0, 1);
		insert into ResourcePermission values (300175, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700341', 174, 166, 1);
		insert into ResourcePermission values (300176, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700341', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061afa', 700342, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700303, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300177, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700342', 170, 0, 1);
		insert into ResourcePermission values (300178, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700342', 174, 166, 1);
		insert into ResourcePermission values (300179, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700342', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061afb', 700343, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700303, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300180, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700343', 170, 0, 1);
		insert into ResourcePermission values (300181, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700343', 174, 166, 1);
		insert into ResourcePermission values (300182, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700343', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061afc', 700344, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 8, 9, 'User Segment 3', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 3</Title></root>', '', 700300);


		insert into ResourcePermission values (300183, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700344', 170, 0, 1);
		insert into ResourcePermission values (300184, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700344', 174, 166, 1);
		insert into ResourcePermission values (300185, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700344', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700344, 208);
	insert into AssetEntries_AssetCategories values (700344, 222);
	insert into AssetEntries_AssetCategories values (700344, 236);
	insert into AssetEntries_AssetCategories values (700344, 250);
	insert into AssetEntries_AssetCategories values (700344, 264);
	insert into AssetEntries_AssetCategories values (700344, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ad4', 700304, 1, 700344, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 3</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 3</Description></root>');


		insert into ResourcePermission values (300186, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700304', 170, 0, 1);
		insert into ResourcePermission values (300187, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700304', 174, 166, 1);
		insert into ResourcePermission values (300188, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700304', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061afd', 700345, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700304, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300189, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700345', 170, 0, 1);
		insert into ResourcePermission values (300190, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700345', 174, 166, 1);
		insert into ResourcePermission values (300191, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700345', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061afe', 700346, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700304, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300192, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700346', 170, 0, 1);
		insert into ResourcePermission values (300193, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700346', 174, 166, 1);
		insert into ResourcePermission values (300194, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700346', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061aff', 700347, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700304, '700290');


		insert into ResourcePermission values (300195, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700347', 170, 0, 1);
		insert into ResourcePermission values (300196, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700347', 174, 166, 1);
		insert into ResourcePermission values (300197, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700347', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b00', 700348, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700304, 'Firefox');


		insert into ResourcePermission values (300198, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700348', 170, 0, 1);
		insert into ResourcePermission values (300199, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700348', 174, 166, 1);
		insert into ResourcePermission values (300200, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700348', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b01', 700349, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700304, '');


		insert into ResourcePermission values (300201, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700349', 170, 0, 1);
		insert into ResourcePermission values (300202, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700349', 174, 166, 1);
		insert into ResourcePermission values (300203, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700349', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b02', 700350, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 10, 11, 'User Segment 4', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 4</Title></root>', '', 700300);


		insert into ResourcePermission values (300204, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700350', 170, 0, 1);
		insert into ResourcePermission values (300205, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700350', 174, 166, 1);
		insert into ResourcePermission values (300206, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700350', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700350, 208);
	insert into AssetEntries_AssetCategories values (700350, 222);
	insert into AssetEntries_AssetCategories values (700350, 236);
	insert into AssetEntries_AssetCategories values (700350, 250);
	insert into AssetEntries_AssetCategories values (700350, 264);
	insert into AssetEntries_AssetCategories values (700350, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ad5', 700305, 1, 700350, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 4</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 4</Description></root>');


		insert into ResourcePermission values (300207, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700305', 170, 0, 1);
		insert into ResourcePermission values (300208, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700305', 174, 166, 1);
		insert into ResourcePermission values (300209, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700305', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b03', 700351, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700305, '700290');


		insert into ResourcePermission values (300210, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700351', 170, 0, 1);
		insert into ResourcePermission values (300211, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700351', 174, 166, 1);
		insert into ResourcePermission values (300212, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700351', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b04', 700352, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700305, 'male');


		insert into ResourcePermission values (300213, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700352', 170, 0, 1);
		insert into ResourcePermission values (300214, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700352', 174, 166, 1);
		insert into ResourcePermission values (300215, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700352', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b05', 700353, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700305, '700290');


		insert into ResourcePermission values (300216, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700353', 170, 0, 1);
		insert into ResourcePermission values (300217, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700353', 174, 166, 1);
		insert into ResourcePermission values (300218, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700353', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b06', 700354, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700305, '1');


		insert into ResourcePermission values (300219, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700354', 170, 0, 1);
		insert into ResourcePermission values (300220, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700354', 174, 166, 1);
		insert into ResourcePermission values (300221, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700354', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b07', 700355, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700305, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300222, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700355', 170, 0, 1);
		insert into ResourcePermission values (300223, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700355', 174, 166, 1);
		insert into ResourcePermission values (300224, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700355', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b08', 700356, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 12, 13, 'User Segment 5', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 5</Title></root>', '', 700300);


		insert into ResourcePermission values (300225, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700356', 170, 0, 1);
		insert into ResourcePermission values (300226, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700356', 174, 166, 1);
		insert into ResourcePermission values (300227, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700356', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700356, 208);
	insert into AssetEntries_AssetCategories values (700356, 222);
	insert into AssetEntries_AssetCategories values (700356, 236);
	insert into AssetEntries_AssetCategories values (700356, 250);
	insert into AssetEntries_AssetCategories values (700356, 264);
	insert into AssetEntries_AssetCategories values (700356, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ad6', 700306, 1, 700356, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 5</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 5</Description></root>');


		insert into ResourcePermission values (300228, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700306', 170, 0, 1);
		insert into ResourcePermission values (300229, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700306', 174, 166, 1);
		insert into ResourcePermission values (300230, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700306', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b09', 700357, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700306, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300231, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700357', 170, 0, 1);
		insert into ResourcePermission values (300232, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700357', 174, 166, 1);
		insert into ResourcePermission values (300233, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700357', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b0a', 700358, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700306, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300234, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700358', 170, 0, 1);
		insert into ResourcePermission values (300235, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700358', 174, 166, 1);
		insert into ResourcePermission values (300236, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700358', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b0b', 700359, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700306, 'Firefox');


		insert into ResourcePermission values (300237, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700359', 170, 0, 1);
		insert into ResourcePermission values (300238, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700359', 174, 166, 1);
		insert into ResourcePermission values (300239, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700359', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b0c', 700360, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700306, 'male');


		insert into ResourcePermission values (300240, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700360', 170, 0, 1);
		insert into ResourcePermission values (300241, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700360', 174, 166, 1);
		insert into ResourcePermission values (300242, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700360', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b0d', 700361, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700306, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300243, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700361', 170, 0, 1);
		insert into ResourcePermission values (300244, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700361', 174, 166, 1);
		insert into ResourcePermission values (300245, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700361', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b0e', 700362, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 14, 15, 'User Segment 6', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 6</Title></root>', '', 700300);


		insert into ResourcePermission values (300246, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700362', 170, 0, 1);
		insert into ResourcePermission values (300247, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700362', 174, 166, 1);
		insert into ResourcePermission values (300248, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700362', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700362, 208);
	insert into AssetEntries_AssetCategories values (700362, 222);
	insert into AssetEntries_AssetCategories values (700362, 236);
	insert into AssetEntries_AssetCategories values (700362, 250);
	insert into AssetEntries_AssetCategories values (700362, 264);
	insert into AssetEntries_AssetCategories values (700362, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ad7', 700307, 1, 700362, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 6</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 6</Description></root>');


		insert into ResourcePermission values (300249, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700307', 170, 0, 1);
		insert into ResourcePermission values (300250, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700307', 174, 166, 1);
		insert into ResourcePermission values (300251, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700307', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b0f', 700363, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700307, 'Firefox');


		insert into ResourcePermission values (300252, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700363', 170, 0, 1);
		insert into ResourcePermission values (300253, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700363', 174, 166, 1);
		insert into ResourcePermission values (300254, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700363', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b10', 700364, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700307, 'Firefox');


		insert into ResourcePermission values (300255, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700364', 170, 0, 1);
		insert into ResourcePermission values (300256, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700364', 174, 166, 1);
		insert into ResourcePermission values (300257, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700364', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b11', 700365, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700307, 'male');


		insert into ResourcePermission values (300258, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700365', 170, 0, 1);
		insert into ResourcePermission values (300259, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700365', 174, 166, 1);
		insert into ResourcePermission values (300260, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700365', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b12', 700366, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700307, '');


		insert into ResourcePermission values (300261, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700366', 170, 0, 1);
		insert into ResourcePermission values (300262, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700366', 174, 166, 1);
		insert into ResourcePermission values (300263, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700366', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b13', 700367, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700307, '');


		insert into ResourcePermission values (300264, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700367', 170, 0, 1);
		insert into ResourcePermission values (300265, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700367', 174, 166, 1);
		insert into ResourcePermission values (300266, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700367', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b14', 700368, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 16, 17, 'User Segment 7', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 7</Title></root>', '', 700300);


		insert into ResourcePermission values (300267, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700368', 170, 0, 1);
		insert into ResourcePermission values (300268, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700368', 174, 166, 1);
		insert into ResourcePermission values (300269, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700368', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700368, 208);
	insert into AssetEntries_AssetCategories values (700368, 222);
	insert into AssetEntries_AssetCategories values (700368, 236);
	insert into AssetEntries_AssetCategories values (700368, 250);
	insert into AssetEntries_AssetCategories values (700368, 264);
	insert into AssetEntries_AssetCategories values (700368, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ad8', 700308, 1, 700368, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 7</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 7</Description></root>');


		insert into ResourcePermission values (300270, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700308', 170, 0, 1);
		insert into ResourcePermission values (300271, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700308', 174, 166, 1);
		insert into ResourcePermission values (300272, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700308', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b15', 700369, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700308, '1');


		insert into ResourcePermission values (300273, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700369', 170, 0, 1);
		insert into ResourcePermission values (300274, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700369', 174, 166, 1);
		insert into ResourcePermission values (300275, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700369', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b16', 700370, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700308, '700290');


		insert into ResourcePermission values (300276, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700370', 170, 0, 1);
		insert into ResourcePermission values (300277, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700370', 174, 166, 1);
		insert into ResourcePermission values (300278, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700370', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b17', 700371, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700308, 'Firefox');


		insert into ResourcePermission values (300279, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700371', 170, 0, 1);
		insert into ResourcePermission values (300280, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700371', 174, 166, 1);
		insert into ResourcePermission values (300281, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700371', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b18', 700372, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700308, 'Firefox');


		insert into ResourcePermission values (300282, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700372', 170, 0, 1);
		insert into ResourcePermission values (300283, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700372', 174, 166, 1);
		insert into ResourcePermission values (300284, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700372', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b19', 700373, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700308, '700290');


		insert into ResourcePermission values (300285, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700373', 170, 0, 1);
		insert into ResourcePermission values (300286, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700373', 174, 166, 1);
		insert into ResourcePermission values (300287, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700373', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b1a', 700374, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 18, 19, 'User Segment 8', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 8</Title></root>', '', 700300);


		insert into ResourcePermission values (300288, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700374', 170, 0, 1);
		insert into ResourcePermission values (300289, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700374', 174, 166, 1);
		insert into ResourcePermission values (300290, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700374', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700374, 208);
	insert into AssetEntries_AssetCategories values (700374, 222);
	insert into AssetEntries_AssetCategories values (700374, 236);
	insert into AssetEntries_AssetCategories values (700374, 250);
	insert into AssetEntries_AssetCategories values (700374, 264);
	insert into AssetEntries_AssetCategories values (700374, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ad9', 700309, 1, 700374, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 8</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 8</Description></root>');


		insert into ResourcePermission values (300291, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700309', 170, 0, 1);
		insert into ResourcePermission values (300292, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700309', 174, 166, 1);
		insert into ResourcePermission values (300293, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700309', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b1b', 700375, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700309, 'male');


		insert into ResourcePermission values (300294, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700375', 170, 0, 1);
		insert into ResourcePermission values (300295, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700375', 174, 166, 1);
		insert into ResourcePermission values (300296, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700375', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b1c', 700376, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700309, '700290');


		insert into ResourcePermission values (300297, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700376', 170, 0, 1);
		insert into ResourcePermission values (300298, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700376', 174, 166, 1);
		insert into ResourcePermission values (300299, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700376', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b1d', 700377, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700309, '1');


		insert into ResourcePermission values (300300, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700377', 170, 0, 1);
		insert into ResourcePermission values (300301, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700377', 174, 166, 1);
		insert into ResourcePermission values (300302, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700377', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b1e', 700378, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700309, '1');


		insert into ResourcePermission values (300303, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700378', 170, 0, 1);
		insert into ResourcePermission values (300304, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700378', 174, 166, 1);
		insert into ResourcePermission values (300305, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700378', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b1f', 700379, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700309, '');


		insert into ResourcePermission values (300306, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700379', 170, 0, 1);
		insert into ResourcePermission values (300307, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700379', 174, 166, 1);
		insert into ResourcePermission values (300308, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700379', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b20', 700380, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 20, 21, 'User Segment 9', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 9</Title></root>', '', 700300);


		insert into ResourcePermission values (300309, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700380', 170, 0, 1);
		insert into ResourcePermission values (300310, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700380', 174, 166, 1);
		insert into ResourcePermission values (300311, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700380', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700380, 208);
	insert into AssetEntries_AssetCategories values (700380, 222);
	insert into AssetEntries_AssetCategories values (700380, 236);
	insert into AssetEntries_AssetCategories values (700380, 250);
	insert into AssetEntries_AssetCategories values (700380, 264);
	insert into AssetEntries_AssetCategories values (700380, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ada', 700310, 1, 700380, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 9</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 9</Description></root>');


		insert into ResourcePermission values (300312, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700310', 170, 0, 1);
		insert into ResourcePermission values (300313, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700310', 174, 166, 1);
		insert into ResourcePermission values (300314, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700310', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b21', 700381, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700310, 'male');


		insert into ResourcePermission values (300315, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700381', 170, 0, 1);
		insert into ResourcePermission values (300316, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700381', 174, 166, 1);
		insert into ResourcePermission values (300317, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700381', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b22', 700382, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700310, '');


		insert into ResourcePermission values (300318, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700382', 170, 0, 1);
		insert into ResourcePermission values (300319, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700382', 174, 166, 1);
		insert into ResourcePermission values (300320, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700382', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b23', 700383, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700310, 'Firefox');


		insert into ResourcePermission values (300321, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700383', 170, 0, 1);
		insert into ResourcePermission values (300322, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700383', 174, 166, 1);
		insert into ResourcePermission values (300323, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700383', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b24', 700384, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700310, 'male');


		insert into ResourcePermission values (300324, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700384', 170, 0, 1);
		insert into ResourcePermission values (300325, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700384', 174, 166, 1);
		insert into ResourcePermission values (300326, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700384', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b25', 700385, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700310, 'Firefox');


		insert into ResourcePermission values (300327, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700385', 170, 0, 1);
		insert into ResourcePermission values (300328, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700385', 174, 166, 1);
		insert into ResourcePermission values (300329, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700385', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b26', 700386, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 22, 23, 'User Segment 10', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 10</Title></root>', '', 700300);


		insert into ResourcePermission values (300330, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700386', 170, 0, 1);
		insert into ResourcePermission values (300331, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700386', 174, 166, 1);
		insert into ResourcePermission values (300332, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700386', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700386, 208);
	insert into AssetEntries_AssetCategories values (700386, 222);
	insert into AssetEntries_AssetCategories values (700386, 236);
	insert into AssetEntries_AssetCategories values (700386, 250);
	insert into AssetEntries_AssetCategories values (700386, 264);
	insert into AssetEntries_AssetCategories values (700386, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061adb', 700311, 1, 700386, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 10</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 10</Description></root>');


		insert into ResourcePermission values (300333, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700311', 170, 0, 1);
		insert into ResourcePermission values (300334, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700311', 174, 166, 1);
		insert into ResourcePermission values (300335, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700311', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b27', 700387, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700311, '700290');


		insert into ResourcePermission values (300336, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700387', 170, 0, 1);
		insert into ResourcePermission values (300337, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700387', 174, 166, 1);
		insert into ResourcePermission values (300338, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700387', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b28', 700388, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700311, '700290');


		insert into ResourcePermission values (300339, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700388', 170, 0, 1);
		insert into ResourcePermission values (300340, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700388', 174, 166, 1);
		insert into ResourcePermission values (300341, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700388', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b29', 700389, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700311, 'male');


		insert into ResourcePermission values (300342, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700389', 170, 0, 1);
		insert into ResourcePermission values (300343, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700389', 174, 166, 1);
		insert into ResourcePermission values (300344, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700389', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b2a', 700390, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700311, '1');


		insert into ResourcePermission values (300345, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700390', 170, 0, 1);
		insert into ResourcePermission values (300346, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700390', 174, 166, 1);
		insert into ResourcePermission values (300347, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700390', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b2b', 700391, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700311, '700290');


		insert into ResourcePermission values (300348, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700391', 170, 0, 1);
		insert into ResourcePermission values (300349, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700391', 174, 166, 1);
		insert into ResourcePermission values (300350, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700391', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b2c', 700392, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 24, 25, 'User Segment 11', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 11</Title></root>', '', 700300);


		insert into ResourcePermission values (300351, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700392', 170, 0, 1);
		insert into ResourcePermission values (300352, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700392', 174, 166, 1);
		insert into ResourcePermission values (300353, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700392', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700392, 208);
	insert into AssetEntries_AssetCategories values (700392, 222);
	insert into AssetEntries_AssetCategories values (700392, 236);
	insert into AssetEntries_AssetCategories values (700392, 250);
	insert into AssetEntries_AssetCategories values (700392, 264);
	insert into AssetEntries_AssetCategories values (700392, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061adc', 700312, 1, 700392, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 11</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 11</Description></root>');


		insert into ResourcePermission values (300354, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700312', 170, 0, 1);
		insert into ResourcePermission values (300355, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700312', 174, 166, 1);
		insert into ResourcePermission values (300356, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700312', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b2d', 700393, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700312, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300357, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700393', 170, 0, 1);
		insert into ResourcePermission values (300358, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700393', 174, 166, 1);
		insert into ResourcePermission values (300359, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700393', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b2e', 700394, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700312, '700290');


		insert into ResourcePermission values (300360, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700394', 170, 0, 1);
		insert into ResourcePermission values (300361, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700394', 174, 166, 1);
		insert into ResourcePermission values (300362, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700394', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b2f', 700395, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700312, '');


		insert into ResourcePermission values (300363, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700395', 170, 0, 1);
		insert into ResourcePermission values (300364, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700395', 174, 166, 1);
		insert into ResourcePermission values (300365, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700395', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b30', 700396, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700312, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300366, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700396', 170, 0, 1);
		insert into ResourcePermission values (300367, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700396', 174, 166, 1);
		insert into ResourcePermission values (300368, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700396', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b31', 700397, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700312, '1');


		insert into ResourcePermission values (300369, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700397', 170, 0, 1);
		insert into ResourcePermission values (300370, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700397', 174, 166, 1);
		insert into ResourcePermission values (300371, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700397', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b32', 700398, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 26, 27, 'User Segment 12', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 12</Title></root>', '', 700300);


		insert into ResourcePermission values (300372, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700398', 170, 0, 1);
		insert into ResourcePermission values (300373, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700398', 174, 166, 1);
		insert into ResourcePermission values (300374, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700398', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700398, 208);
	insert into AssetEntries_AssetCategories values (700398, 222);
	insert into AssetEntries_AssetCategories values (700398, 236);
	insert into AssetEntries_AssetCategories values (700398, 250);
	insert into AssetEntries_AssetCategories values (700398, 264);
	insert into AssetEntries_AssetCategories values (700398, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061add', 700313, 1, 700398, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 12</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 12</Description></root>');


		insert into ResourcePermission values (300375, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700313', 170, 0, 1);
		insert into ResourcePermission values (300376, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700313', 174, 166, 1);
		insert into ResourcePermission values (300377, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700313', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b33', 700399, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700313, '700290');


		insert into ResourcePermission values (300378, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700399', 170, 0, 1);
		insert into ResourcePermission values (300379, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700399', 174, 166, 1);
		insert into ResourcePermission values (300380, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700399', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b34', 700400, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700313, '');


		insert into ResourcePermission values (300381, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700400', 170, 0, 1);
		insert into ResourcePermission values (300382, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700400', 174, 166, 1);
		insert into ResourcePermission values (300383, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700400', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b35', 700401, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700313, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300384, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700401', 170, 0, 1);
		insert into ResourcePermission values (300385, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700401', 174, 166, 1);
		insert into ResourcePermission values (300386, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700401', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b36', 700402, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700313, 'Firefox');


		insert into ResourcePermission values (300387, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700402', 170, 0, 1);
		insert into ResourcePermission values (300388, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700402', 174, 166, 1);
		insert into ResourcePermission values (300389, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700402', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b37', 700403, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700313, 'Firefox');


		insert into ResourcePermission values (300390, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700403', 170, 0, 1);
		insert into ResourcePermission values (300391, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700403', 174, 166, 1);
		insert into ResourcePermission values (300392, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700403', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b38', 700404, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 28, 29, 'User Segment 13', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 13</Title></root>', '', 700300);


		insert into ResourcePermission values (300393, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700404', 170, 0, 1);
		insert into ResourcePermission values (300394, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700404', 174, 166, 1);
		insert into ResourcePermission values (300395, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700404', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700404, 208);
	insert into AssetEntries_AssetCategories values (700404, 222);
	insert into AssetEntries_AssetCategories values (700404, 236);
	insert into AssetEntries_AssetCategories values (700404, 250);
	insert into AssetEntries_AssetCategories values (700404, 264);
	insert into AssetEntries_AssetCategories values (700404, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ade', 700314, 1, 700404, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 13</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 13</Description></root>');


		insert into ResourcePermission values (300396, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700314', 170, 0, 1);
		insert into ResourcePermission values (300397, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700314', 174, 166, 1);
		insert into ResourcePermission values (300398, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700314', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b39', 700405, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700314, 'male');


		insert into ResourcePermission values (300399, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700405', 170, 0, 1);
		insert into ResourcePermission values (300400, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700405', 174, 166, 1);
		insert into ResourcePermission values (300401, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700405', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b3a', 700406, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700314, 'Firefox');


		insert into ResourcePermission values (300402, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700406', 170, 0, 1);
		insert into ResourcePermission values (300403, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700406', 174, 166, 1);
		insert into ResourcePermission values (300404, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700406', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b3b', 700407, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700314, '700290');


		insert into ResourcePermission values (300405, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700407', 170, 0, 1);
		insert into ResourcePermission values (300406, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700407', 174, 166, 1);
		insert into ResourcePermission values (300407, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700407', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b3c', 700408, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700314, 'male');


		insert into ResourcePermission values (300408, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700408', 170, 0, 1);
		insert into ResourcePermission values (300409, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700408', 174, 166, 1);
		insert into ResourcePermission values (300410, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700408', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b3d', 700409, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700314, 'male');


		insert into ResourcePermission values (300411, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700409', 170, 0, 1);
		insert into ResourcePermission values (300412, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700409', 174, 166, 1);
		insert into ResourcePermission values (300413, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700409', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b3e', 700410, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 30, 31, 'User Segment 14', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 14</Title></root>', '', 700300);


		insert into ResourcePermission values (300414, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700410', 170, 0, 1);
		insert into ResourcePermission values (300415, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700410', 174, 166, 1);
		insert into ResourcePermission values (300416, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700410', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700410, 208);
	insert into AssetEntries_AssetCategories values (700410, 222);
	insert into AssetEntries_AssetCategories values (700410, 236);
	insert into AssetEntries_AssetCategories values (700410, 250);
	insert into AssetEntries_AssetCategories values (700410, 264);
	insert into AssetEntries_AssetCategories values (700410, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061adf', 700315, 1, 700410, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 14</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 14</Description></root>');


		insert into ResourcePermission values (300417, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700315', 170, 0, 1);
		insert into ResourcePermission values (300418, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700315', 174, 166, 1);
		insert into ResourcePermission values (300419, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700315', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b3f', 700411, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700315, '700290');


		insert into ResourcePermission values (300420, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700411', 170, 0, 1);
		insert into ResourcePermission values (300421, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700411', 174, 166, 1);
		insert into ResourcePermission values (300422, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700411', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b40', 700412, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700315, '700290');


		insert into ResourcePermission values (300423, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700412', 170, 0, 1);
		insert into ResourcePermission values (300424, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700412', 174, 166, 1);
		insert into ResourcePermission values (300425, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700412', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b41', 700413, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700315, '1');


		insert into ResourcePermission values (300426, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700413', 170, 0, 1);
		insert into ResourcePermission values (300427, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700413', 174, 166, 1);
		insert into ResourcePermission values (300428, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700413', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b42', 700414, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700315, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300429, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700414', 170, 0, 1);
		insert into ResourcePermission values (300430, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700414', 174, 166, 1);
		insert into ResourcePermission values (300431, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700414', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b43', 700415, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700315, 'male');


		insert into ResourcePermission values (300432, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700415', 170, 0, 1);
		insert into ResourcePermission values (300433, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700415', 174, 166, 1);
		insert into ResourcePermission values (300434, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700415', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b44', 700416, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 32, 33, 'User Segment 15', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 15</Title></root>', '', 700300);


		insert into ResourcePermission values (300435, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700416', 170, 0, 1);
		insert into ResourcePermission values (300436, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700416', 174, 166, 1);
		insert into ResourcePermission values (300437, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700416', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700416, 208);
	insert into AssetEntries_AssetCategories values (700416, 222);
	insert into AssetEntries_AssetCategories values (700416, 236);
	insert into AssetEntries_AssetCategories values (700416, 250);
	insert into AssetEntries_AssetCategories values (700416, 264);
	insert into AssetEntries_AssetCategories values (700416, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae0', 700316, 1, 700416, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 15</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 15</Description></root>');


		insert into ResourcePermission values (300438, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700316', 170, 0, 1);
		insert into ResourcePermission values (300439, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700316', 174, 166, 1);
		insert into ResourcePermission values (300440, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700316', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b45', 700417, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700316, 'male');


		insert into ResourcePermission values (300441, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700417', 170, 0, 1);
		insert into ResourcePermission values (300442, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700417', 174, 166, 1);
		insert into ResourcePermission values (300443, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700417', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b46', 700418, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700316, 'Firefox');


		insert into ResourcePermission values (300444, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700418', 170, 0, 1);
		insert into ResourcePermission values (300445, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700418', 174, 166, 1);
		insert into ResourcePermission values (300446, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700418', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b47', 700419, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700316, 'Firefox');


		insert into ResourcePermission values (300447, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700419', 170, 0, 1);
		insert into ResourcePermission values (300448, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700419', 174, 166, 1);
		insert into ResourcePermission values (300449, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700419', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b48', 700420, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700316, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300450, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700420', 170, 0, 1);
		insert into ResourcePermission values (300451, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700420', 174, 166, 1);
		insert into ResourcePermission values (300452, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700420', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b49', 700421, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700316, '700290');


		insert into ResourcePermission values (300453, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700421', 170, 0, 1);
		insert into ResourcePermission values (300454, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700421', 174, 166, 1);
		insert into ResourcePermission values (300455, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700421', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b4a', 700422, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 34, 35, 'User Segment 16', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 16</Title></root>', '', 700300);


		insert into ResourcePermission values (300456, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700422', 170, 0, 1);
		insert into ResourcePermission values (300457, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700422', 174, 166, 1);
		insert into ResourcePermission values (300458, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700422', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700422, 208);
	insert into AssetEntries_AssetCategories values (700422, 222);
	insert into AssetEntries_AssetCategories values (700422, 236);
	insert into AssetEntries_AssetCategories values (700422, 250);
	insert into AssetEntries_AssetCategories values (700422, 264);
	insert into AssetEntries_AssetCategories values (700422, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae1', 700317, 1, 700422, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 16</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 16</Description></root>');


		insert into ResourcePermission values (300459, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700317', 170, 0, 1);
		insert into ResourcePermission values (300460, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700317', 174, 166, 1);
		insert into ResourcePermission values (300461, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700317', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b4b', 700423, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700317, '1');


		insert into ResourcePermission values (300462, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700423', 170, 0, 1);
		insert into ResourcePermission values (300463, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700423', 174, 166, 1);
		insert into ResourcePermission values (300464, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700423', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b4c', 700424, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700317, '700290');


		insert into ResourcePermission values (300465, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700424', 170, 0, 1);
		insert into ResourcePermission values (300466, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700424', 174, 166, 1);
		insert into ResourcePermission values (300467, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700424', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b4d', 700425, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700317, '700290');


		insert into ResourcePermission values (300468, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700425', 170, 0, 1);
		insert into ResourcePermission values (300469, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700425', 174, 166, 1);
		insert into ResourcePermission values (300470, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700425', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b4e', 700426, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700317, 'Firefox');


		insert into ResourcePermission values (300471, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700426', 170, 0, 1);
		insert into ResourcePermission values (300472, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700426', 174, 166, 1);
		insert into ResourcePermission values (300473, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700426', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b4f', 700427, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700317, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300474, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700427', 170, 0, 1);
		insert into ResourcePermission values (300475, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700427', 174, 166, 1);
		insert into ResourcePermission values (300476, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700427', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b50', 700428, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 36, 37, 'User Segment 17', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 17</Title></root>', '', 700300);


		insert into ResourcePermission values (300477, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700428', 170, 0, 1);
		insert into ResourcePermission values (300478, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700428', 174, 166, 1);
		insert into ResourcePermission values (300479, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700428', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700428, 208);
	insert into AssetEntries_AssetCategories values (700428, 222);
	insert into AssetEntries_AssetCategories values (700428, 236);
	insert into AssetEntries_AssetCategories values (700428, 250);
	insert into AssetEntries_AssetCategories values (700428, 264);
	insert into AssetEntries_AssetCategories values (700428, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae2', 700318, 1, 700428, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 17</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 17</Description></root>');


		insert into ResourcePermission values (300480, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700318', 170, 0, 1);
		insert into ResourcePermission values (300481, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700318', 174, 166, 1);
		insert into ResourcePermission values (300482, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700318', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b51', 700429, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700318, 'male');


		insert into ResourcePermission values (300483, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700429', 170, 0, 1);
		insert into ResourcePermission values (300484, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700429', 174, 166, 1);
		insert into ResourcePermission values (300485, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700429', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b52', 700430, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700318, 'male');


		insert into ResourcePermission values (300486, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700430', 170, 0, 1);
		insert into ResourcePermission values (300487, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700430', 174, 166, 1);
		insert into ResourcePermission values (300488, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700430', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b53', 700431, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700318, '700290');


		insert into ResourcePermission values (300489, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700431', 170, 0, 1);
		insert into ResourcePermission values (300490, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700431', 174, 166, 1);
		insert into ResourcePermission values (300491, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700431', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b54', 700432, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700318, 'male');


		insert into ResourcePermission values (300492, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700432', 170, 0, 1);
		insert into ResourcePermission values (300493, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700432', 174, 166, 1);
		insert into ResourcePermission values (300494, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700432', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b55', 700433, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700318, 'male');


		insert into ResourcePermission values (300495, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700433', 170, 0, 1);
		insert into ResourcePermission values (300496, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700433', 174, 166, 1);
		insert into ResourcePermission values (300497, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700433', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b56', 700434, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 38, 39, 'User Segment 18', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 18</Title></root>', '', 700300);


		insert into ResourcePermission values (300498, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700434', 170, 0, 1);
		insert into ResourcePermission values (300499, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700434', 174, 166, 1);
		insert into ResourcePermission values (300500, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700434', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700434, 208);
	insert into AssetEntries_AssetCategories values (700434, 222);
	insert into AssetEntries_AssetCategories values (700434, 236);
	insert into AssetEntries_AssetCategories values (700434, 250);
	insert into AssetEntries_AssetCategories values (700434, 264);
	insert into AssetEntries_AssetCategories values (700434, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae3', 700319, 1, 700434, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 18</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 18</Description></root>');


		insert into ResourcePermission values (300501, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700319', 170, 0, 1);
		insert into ResourcePermission values (300502, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700319', 174, 166, 1);
		insert into ResourcePermission values (300503, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700319', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b57', 700435, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700319, '1');


		insert into ResourcePermission values (300504, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700435', 170, 0, 1);
		insert into ResourcePermission values (300505, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700435', 174, 166, 1);
		insert into ResourcePermission values (300506, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700435', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b58', 700436, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700319, 'male');


		insert into ResourcePermission values (300507, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700436', 170, 0, 1);
		insert into ResourcePermission values (300508, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700436', 174, 166, 1);
		insert into ResourcePermission values (300509, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700436', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b59', 700437, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700319, '1');


		insert into ResourcePermission values (300510, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700437', 170, 0, 1);
		insert into ResourcePermission values (300511, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700437', 174, 166, 1);
		insert into ResourcePermission values (300512, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700437', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b5a', 700438, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700319, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300513, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700438', 170, 0, 1);
		insert into ResourcePermission values (300514, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700438', 174, 166, 1);
		insert into ResourcePermission values (300515, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700438', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b5b', 700439, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700319, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300516, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700439', 170, 0, 1);
		insert into ResourcePermission values (300517, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700439', 174, 166, 1);
		insert into ResourcePermission values (300518, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700439', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b5c', 700440, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 40, 41, 'User Segment 19', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 19</Title></root>', '', 700300);


		insert into ResourcePermission values (300519, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700440', 170, 0, 1);
		insert into ResourcePermission values (300520, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700440', 174, 166, 1);
		insert into ResourcePermission values (300521, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700440', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700440, 208);
	insert into AssetEntries_AssetCategories values (700440, 222);
	insert into AssetEntries_AssetCategories values (700440, 236);
	insert into AssetEntries_AssetCategories values (700440, 250);
	insert into AssetEntries_AssetCategories values (700440, 264);
	insert into AssetEntries_AssetCategories values (700440, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae4', 700320, 1, 700440, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 19</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 19</Description></root>');


		insert into ResourcePermission values (300522, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700320', 170, 0, 1);
		insert into ResourcePermission values (300523, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700320', 174, 166, 1);
		insert into ResourcePermission values (300524, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700320', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b5d', 700441, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700320, '1');


		insert into ResourcePermission values (300525, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700441', 170, 0, 1);
		insert into ResourcePermission values (300526, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700441', 174, 166, 1);
		insert into ResourcePermission values (300527, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700441', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b5e', 700442, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700320, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300528, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700442', 170, 0, 1);
		insert into ResourcePermission values (300529, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700442', 174, 166, 1);
		insert into ResourcePermission values (300530, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700442', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b5f', 700443, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700320, 'male');


		insert into ResourcePermission values (300531, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700443', 170, 0, 1);
		insert into ResourcePermission values (300532, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700443', 174, 166, 1);
		insert into ResourcePermission values (300533, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700443', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b60', 700444, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700320, '');


		insert into ResourcePermission values (300534, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700444', 170, 0, 1);
		insert into ResourcePermission values (300535, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700444', 174, 166, 1);
		insert into ResourcePermission values (300536, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700444', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b61', 700445, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700320, 'male');


		insert into ResourcePermission values (300537, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700445', 170, 0, 1);
		insert into ResourcePermission values (300538, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700445', 174, 166, 1);
		insert into ResourcePermission values (300539, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700445', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b62', 700446, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 42, 43, 'User Segment 20', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 20</Title></root>', '', 700300);


		insert into ResourcePermission values (300540, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700446', 170, 0, 1);
		insert into ResourcePermission values (300541, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700446', 174, 166, 1);
		insert into ResourcePermission values (300542, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700446', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700446, 208);
	insert into AssetEntries_AssetCategories values (700446, 222);
	insert into AssetEntries_AssetCategories values (700446, 236);
	insert into AssetEntries_AssetCategories values (700446, 250);
	insert into AssetEntries_AssetCategories values (700446, 264);
	insert into AssetEntries_AssetCategories values (700446, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae5', 700321, 1, 700446, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 20</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 20</Description></root>');


		insert into ResourcePermission values (300543, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700321', 170, 0, 1);
		insert into ResourcePermission values (300544, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700321', 174, 166, 1);
		insert into ResourcePermission values (300545, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700321', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b63', 700447, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700321, 'Firefox');


		insert into ResourcePermission values (300546, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700447', 170, 0, 1);
		insert into ResourcePermission values (300547, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700447', 174, 166, 1);
		insert into ResourcePermission values (300548, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700447', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b64', 700448, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700321, '700290');


		insert into ResourcePermission values (300549, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700448', 170, 0, 1);
		insert into ResourcePermission values (300550, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700448', 174, 166, 1);
		insert into ResourcePermission values (300551, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700448', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b65', 700449, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700321, 'Firefox');


		insert into ResourcePermission values (300552, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700449', 170, 0, 1);
		insert into ResourcePermission values (300553, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700449', 174, 166, 1);
		insert into ResourcePermission values (300554, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700449', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b66', 700450, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700321, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300555, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700450', 170, 0, 1);
		insert into ResourcePermission values (300556, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700450', 174, 166, 1);
		insert into ResourcePermission values (300557, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700450', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b67', 700451, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700321, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300558, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700451', 170, 0, 1);
		insert into ResourcePermission values (300559, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700451', 174, 166, 1);
		insert into ResourcePermission values (300560, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700451', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b68', 700452, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 44, 45, 'User Segment 21', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 21</Title></root>', '', 700300);


		insert into ResourcePermission values (300561, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700452', 170, 0, 1);
		insert into ResourcePermission values (300562, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700452', 174, 166, 1);
		insert into ResourcePermission values (300563, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700452', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700452, 208);
	insert into AssetEntries_AssetCategories values (700452, 222);
	insert into AssetEntries_AssetCategories values (700452, 236);
	insert into AssetEntries_AssetCategories values (700452, 250);
	insert into AssetEntries_AssetCategories values (700452, 264);
	insert into AssetEntries_AssetCategories values (700452, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae6', 700322, 1, 700452, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 21</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 21</Description></root>');


		insert into ResourcePermission values (300564, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700322', 170, 0, 1);
		insert into ResourcePermission values (300565, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700322', 174, 166, 1);
		insert into ResourcePermission values (300566, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700322', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b69', 700453, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700322, '');


		insert into ResourcePermission values (300567, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700453', 170, 0, 1);
		insert into ResourcePermission values (300568, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700453', 174, 166, 1);
		insert into ResourcePermission values (300569, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700453', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b6a', 700454, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700322, 'Firefox');


		insert into ResourcePermission values (300570, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700454', 170, 0, 1);
		insert into ResourcePermission values (300571, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700454', 174, 166, 1);
		insert into ResourcePermission values (300572, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700454', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b6b', 700455, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700322, 'male');


		insert into ResourcePermission values (300573, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700455', 170, 0, 1);
		insert into ResourcePermission values (300574, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700455', 174, 166, 1);
		insert into ResourcePermission values (300575, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700455', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b6c', 700456, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700322, 'Firefox');


		insert into ResourcePermission values (300576, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700456', 170, 0, 1);
		insert into ResourcePermission values (300577, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700456', 174, 166, 1);
		insert into ResourcePermission values (300578, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700456', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b6d', 700457, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700322, '');


		insert into ResourcePermission values (300579, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700457', 170, 0, 1);
		insert into ResourcePermission values (300580, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700457', 174, 166, 1);
		insert into ResourcePermission values (300581, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700457', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b6e', 700458, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 46, 47, 'User Segment 22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 22</Title></root>', '', 700300);


		insert into ResourcePermission values (300582, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700458', 170, 0, 1);
		insert into ResourcePermission values (300583, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700458', 174, 166, 1);
		insert into ResourcePermission values (300584, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700458', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700458, 208);
	insert into AssetEntries_AssetCategories values (700458, 222);
	insert into AssetEntries_AssetCategories values (700458, 236);
	insert into AssetEntries_AssetCategories values (700458, 250);
	insert into AssetEntries_AssetCategories values (700458, 264);
	insert into AssetEntries_AssetCategories values (700458, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae7', 700323, 1, 700458, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 22</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 22</Description></root>');


		insert into ResourcePermission values (300585, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700323', 170, 0, 1);
		insert into ResourcePermission values (300586, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700323', 174, 166, 1);
		insert into ResourcePermission values (300587, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700323', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b6f', 700459, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'UserLogged', 700323, '');


		insert into ResourcePermission values (300588, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700459', 170, 0, 1);
		insert into ResourcePermission values (300589, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700459', 174, 166, 1);
		insert into ResourcePermission values (300590, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700459', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b70', 700460, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700323, 'Firefox');


		insert into ResourcePermission values (300591, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700460', 170, 0, 1);
		insert into ResourcePermission values (300592, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700460', 174, 166, 1);
		insert into ResourcePermission values (300593, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700460', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b71', 700461, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700323, '1');


		insert into ResourcePermission values (300594, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700461', 170, 0, 1);
		insert into ResourcePermission values (300595, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700461', 174, 166, 1);
		insert into ResourcePermission values (300596, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700461', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b72', 700462, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700323, 'male');


		insert into ResourcePermission values (300597, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700462', 170, 0, 1);
		insert into ResourcePermission values (300598, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700462', 174, 166, 1);
		insert into ResourcePermission values (300599, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700462', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b73', 700463, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700323, 'male');


		insert into ResourcePermission values (300600, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700463', 170, 0, 1);
		insert into ResourcePermission values (300601, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700463', 174, 166, 1);
		insert into ResourcePermission values (300602, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700463', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b74', 700464, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 48, 49, 'User Segment 23', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 23</Title></root>', '', 700300);


		insert into ResourcePermission values (300603, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700464', 170, 0, 1);
		insert into ResourcePermission values (300604, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700464', 174, 166, 1);
		insert into ResourcePermission values (300605, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700464', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700464, 208);
	insert into AssetEntries_AssetCategories values (700464, 222);
	insert into AssetEntries_AssetCategories values (700464, 236);
	insert into AssetEntries_AssetCategories values (700464, 250);
	insert into AssetEntries_AssetCategories values (700464, 264);
	insert into AssetEntries_AssetCategories values (700464, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae8', 700324, 1, 700464, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 23</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 23</Description></root>');


		insert into ResourcePermission values (300606, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700324', 170, 0, 1);
		insert into ResourcePermission values (300607, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700324', 174, 166, 1);
		insert into ResourcePermission values (300608, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700324', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b75', 700465, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700324, 'Firefox');


		insert into ResourcePermission values (300609, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700465', 170, 0, 1);
		insert into ResourcePermission values (300610, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700465', 174, 166, 1);
		insert into ResourcePermission values (300611, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700465', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b76', 700466, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700324, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300612, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700466', 170, 0, 1);
		insert into ResourcePermission values (300613, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700466', 174, 166, 1);
		insert into ResourcePermission values (300614, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700466', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b77', 700467, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700324, 'male');


		insert into ResourcePermission values (300615, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700467', 170, 0, 1);
		insert into ResourcePermission values (300616, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700467', 174, 166, 1);
		insert into ResourcePermission values (300617, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700467', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b78', 700468, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'BrowserRule', 700324, 'Firefox');


		insert into ResourcePermission values (300618, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700468', 170, 0, 1);
		insert into ResourcePermission values (300619, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700468', 174, 166, 1);
		insert into ResourcePermission values (300620, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700468', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b79', 700469, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700324, '700290');


		insert into ResourcePermission values (300621, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700469', 170, 0, 1);
		insert into ResourcePermission values (300622, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700469', 174, 166, 1);
		insert into ResourcePermission values (300623, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700469', 177, 0, 1);

	insert into AssetCategory values ('00000000-0000-0000-0000-00061b7a', 700470, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 0, 50, 51, 'User Segment 24', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Title language-id="en_US">User Segment 24</Title></root>', '', 700300);


		insert into ResourcePermission values (300624, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700470', 170, 0, 1);
		insert into ResourcePermission values (300625, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700470', 174, 166, 1);
		insert into ResourcePermission values (300626, 162, 'com.liferay.portlet.asset.model.AssetCategory', 4, '700470', 177, 0, 1);

	insert into AssetEntries_AssetCategories values (700470, 208);
	insert into AssetEntries_AssetCategories values (700470, 222);
	insert into AssetEntries_AssetCategories values (700470, 236);
	insert into AssetEntries_AssetCategories values (700470, 250);
	insert into AssetEntries_AssetCategories values (700470, 264);
	insert into AssetEntries_AssetCategories values (700470, 278);

	

	insert into CT_UserSegment values ('00000000-0000-0000-0000-00061ae9', 700325, 1, 700470, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">User Segment 24</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">User Segment 24</Description></root>');


		insert into ResourcePermission values (300627, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700325', 170, 0, 1);
		insert into ResourcePermission values (300628, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700325', 174, 166, 1);
		insert into ResourcePermission values (300629, 162, 'com.liferay.content.targeting.model.UserSegment', 4, '700325', 177, 0, 1);


		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b7b', 700471, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'SiteMemberRule', 700325, '1');


		insert into ResourcePermission values (300630, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700471', 170, 0, 1);
		insert into ResourcePermission values (300631, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700471', 174, 166, 1);
		insert into ResourcePermission values (300632, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700471', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b7c', 700472, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'AgeRule', 700325, '{"olderThan":30,"youngerThan":100}');


		insert into ResourcePermission values (300633, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700472', 170, 0, 1);
		insert into ResourcePermission values (300634, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700472', 174, 166, 1);
		insert into ResourcePermission values (300635, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700472', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b7d', 700473, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'PageVisitedRule', 700325, '700290');


		insert into ResourcePermission values (300636, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700473', 170, 0, 1);
		insert into ResourcePermission values (300637, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700473', 174, 166, 1);
		insert into ResourcePermission values (300638, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700473', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b7e', 700474, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700325, 'male');


		insert into ResourcePermission values (300639, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700474', 170, 0, 1);
		insert into ResourcePermission values (300640, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700474', 174, 166, 1);
		insert into ResourcePermission values (300641, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700474', 177, 0, 1);
		insert into CT_RuleInstance values ('00000000-0000-0000-0000-00061b7f', 700475, 1, 162, 166, 'Sample', '2017-07-11 14:14:22', '2017-07-11 14:14:22', 'GenderRule', 700325, 'male');


		insert into ResourcePermission values (300642, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700475', 170, 0, 1);
		insert into ResourcePermission values (300643, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700475', 174, 166, 1);
		insert into ResourcePermission values (300644, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700475', 177, 0, 1);


	insert into Layout values ('00000000-0000-0000-0000-00061b80', 700476, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 13, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_1</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P1P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_1', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300645, 162, 'com.liferay.portal.model.Layout', 4, '700476', 170, 0, 1);
		insert into ResourcePermission values (300646, 162, 'com.liferay.portal.model.Layout', 4, '700476', 174, 166, 1);
		insert into ResourcePermission values (300647, 162, 'com.liferay.portal.model.Layout', 4, '700476', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b81', 700477, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700476, false, '/user_segment_content_display_1', 'en_US');

	

	insert into PortletPreferences values (700478, 0, 3, 700476, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P1P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700470</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700446</value></preference><preference><name>assetEntryIdDefault</name><value>222</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>236</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>236</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>250</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700338</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>250</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>264</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700392</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700422</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300648, 162, 'usersegmentcontentdisplay', 4, '700476_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P1P1', 170, 0, 1);
		insert into ResourcePermission values (300649, 162, 'usersegmentcontentdisplay', 4, '700476_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P1P1', 174, 0, 1);
		insert into ResourcePermission values (300650, 162, 'usersegmentcontentdisplay', 4, '700476_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P1P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b82', 700479, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 14, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_2</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P2P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_2', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300651, 162, 'com.liferay.portal.model.Layout', 4, '700479', 170, 0, 1);
		insert into ResourcePermission values (300652, 162, 'com.liferay.portal.model.Layout', 4, '700479', 174, 166, 1);
		insert into ResourcePermission values (300653, 162, 'com.liferay.portal.model.Layout', 4, '700479', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b83', 700480, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700479, false, '/user_segment_content_display_2', 'en_US');

	

	insert into PortletPreferences values (700481, 0, 3, 700479, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P2P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700440</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700332</value></preference><preference><name>assetEntryIdDefault</name><value>236</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>278</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>222</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>222</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700458</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>236</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>278</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700368</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700326</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300654, 162, 'usersegmentcontentdisplay', 4, '700479_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P2P1', 170, 0, 1);
		insert into ResourcePermission values (300655, 162, 'usersegmentcontentdisplay', 4, '700479_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P2P1', 174, 0, 1);
		insert into ResourcePermission values (300656, 162, 'usersegmentcontentdisplay', 4, '700479_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P2P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b84', 700482, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 15, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_3</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P3P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_3', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300657, 162, 'com.liferay.portal.model.Layout', 4, '700482', 170, 0, 1);
		insert into ResourcePermission values (300658, 162, 'com.liferay.portal.model.Layout', 4, '700482', 174, 166, 1);
		insert into ResourcePermission values (300659, 162, 'com.liferay.portal.model.Layout', 4, '700482', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b85', 700483, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700482, false, '/user_segment_content_display_3', 'en_US');

	

	insert into PortletPreferences values (700484, 0, 3, 700482, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P3P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700464</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700380</value></preference><preference><name>assetEntryIdDefault</name><value>236</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>250</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>208</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>250</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700410</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>250</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>278</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700410</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700410</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300660, 162, 'usersegmentcontentdisplay', 4, '700482_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P3P1', 170, 0, 1);
		insert into ResourcePermission values (300661, 162, 'usersegmentcontentdisplay', 4, '700482_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P3P1', 174, 0, 1);
		insert into ResourcePermission values (300662, 162, 'usersegmentcontentdisplay', 4, '700482_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P3P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b86', 700485, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 16, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_4</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P4P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_4', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300663, 162, 'com.liferay.portal.model.Layout', 4, '700485', 170, 0, 1);
		insert into ResourcePermission values (300664, 162, 'com.liferay.portal.model.Layout', 4, '700485', 174, 166, 1);
		insert into ResourcePermission values (300665, 162, 'com.liferay.portal.model.Layout', 4, '700485', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b87', 700486, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700485, false, '/user_segment_content_display_4', 'en_US');

	

	insert into PortletPreferences values (700487, 0, 3, 700485, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P4P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700452</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700416</value></preference><preference><name>assetEntryIdDefault</name><value>236</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>236</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>264</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>222</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700356</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>208</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>264</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700338</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700458</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300666, 162, 'usersegmentcontentdisplay', 4, '700485_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P4P1', 170, 0, 1);
		insert into ResourcePermission values (300667, 162, 'usersegmentcontentdisplay', 4, '700485_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P4P1', 174, 0, 1);
		insert into ResourcePermission values (300668, 162, 'usersegmentcontentdisplay', 4, '700485_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P4P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b88', 700488, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 17, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_5</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P5P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_5', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300669, 162, 'com.liferay.portal.model.Layout', 4, '700488', 170, 0, 1);
		insert into ResourcePermission values (300670, 162, 'com.liferay.portal.model.Layout', 4, '700488', 174, 166, 1);
		insert into ResourcePermission values (300671, 162, 'com.liferay.portal.model.Layout', 4, '700488', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b89', 700489, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700488, false, '/user_segment_content_display_5', 'en_US');

	

	insert into PortletPreferences values (700490, 0, 3, 700488, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P5P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700416</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700410</value></preference><preference><name>assetEntryIdDefault</name><value>236</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>208</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>236</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>264</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700470</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>222</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>236</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700404</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700452</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300672, 162, 'usersegmentcontentdisplay', 4, '700488_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P5P1', 170, 0, 1);
		insert into ResourcePermission values (300673, 162, 'usersegmentcontentdisplay', 4, '700488_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P5P1', 174, 0, 1);
		insert into ResourcePermission values (300674, 162, 'usersegmentcontentdisplay', 4, '700488_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P5P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b8a', 700491, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 18, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_6</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P6P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_6', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300675, 162, 'com.liferay.portal.model.Layout', 4, '700491', 170, 0, 1);
		insert into ResourcePermission values (300676, 162, 'com.liferay.portal.model.Layout', 4, '700491', 174, 166, 1);
		insert into ResourcePermission values (300677, 162, 'com.liferay.portal.model.Layout', 4, '700491', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b8b', 700492, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700491, false, '/user_segment_content_display_6', 'en_US');

	

	insert into PortletPreferences values (700493, 0, 3, 700491, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P6P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700458</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700392</value></preference><preference><name>assetEntryIdDefault</name><value>264</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>250</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>278</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>250</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700362</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>236</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>236</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700350</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700350</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300678, 162, 'usersegmentcontentdisplay', 4, '700491_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P6P1', 170, 0, 1);
		insert into ResourcePermission values (300679, 162, 'usersegmentcontentdisplay', 4, '700491_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P6P1', 174, 0, 1);
		insert into ResourcePermission values (300680, 162, 'usersegmentcontentdisplay', 4, '700491_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P6P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b8c', 700494, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 19, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_7</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P7P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_7', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300681, 162, 'com.liferay.portal.model.Layout', 4, '700494', 170, 0, 1);
		insert into ResourcePermission values (300682, 162, 'com.liferay.portal.model.Layout', 4, '700494', 174, 166, 1);
		insert into ResourcePermission values (300683, 162, 'com.liferay.portal.model.Layout', 4, '700494', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b8d', 700495, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700494, false, '/user_segment_content_display_7', 'en_US');

	

	insert into PortletPreferences values (700496, 0, 3, 700494, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P7P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700440</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700458</value></preference><preference><name>assetEntryIdDefault</name><value>278</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>208</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>222</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>222</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700464</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>278</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>208</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700416</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700332</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300684, 162, 'usersegmentcontentdisplay', 4, '700494_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P7P1', 170, 0, 1);
		insert into ResourcePermission values (300685, 162, 'usersegmentcontentdisplay', 4, '700494_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P7P1', 174, 0, 1);
		insert into ResourcePermission values (300686, 162, 'usersegmentcontentdisplay', 4, '700494_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P7P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b8e', 700497, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 20, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_8</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P8P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_8', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300687, 162, 'com.liferay.portal.model.Layout', 4, '700497', 170, 0, 1);
		insert into ResourcePermission values (300688, 162, 'com.liferay.portal.model.Layout', 4, '700497', 174, 166, 1);
		insert into ResourcePermission values (300689, 162, 'com.liferay.portal.model.Layout', 4, '700497', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b8f', 700498, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700497, false, '/user_segment_content_display_8', 'en_US');

	

	insert into PortletPreferences values (700499, 0, 3, 700497, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P8P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700392</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700464</value></preference><preference><name>assetEntryIdDefault</name><value>278</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>278</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>222</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>250</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700338</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>250</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>236</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700368</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700422</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300690, 162, 'usersegmentcontentdisplay', 4, '700497_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P8P1', 170, 0, 1);
		insert into ResourcePermission values (300691, 162, 'usersegmentcontentdisplay', 4, '700497_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P8P1', 174, 0, 1);
		insert into ResourcePermission values (300692, 162, 'usersegmentcontentdisplay', 4, '700497_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P8P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b90', 700500, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 21, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_9</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P9P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_9', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300693, 162, 'com.liferay.portal.model.Layout', 4, '700500', 170, 0, 1);
		insert into ResourcePermission values (300694, 162, 'com.liferay.portal.model.Layout', 4, '700500', 174, 166, 1);
		insert into ResourcePermission values (300695, 162, 'com.liferay.portal.model.Layout', 4, '700500', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b91', 700501, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700500, false, '/user_segment_content_display_9', 'en_US');

	

	insert into PortletPreferences values (700502, 0, 3, 700500, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P9P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700338</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700380</value></preference><preference><name>assetEntryIdDefault</name><value>250</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>264</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>222</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>264</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700374</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>264</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>222</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700446</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700368</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300696, 162, 'usersegmentcontentdisplay', 4, '700500_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P9P1', 170, 0, 1);
		insert into ResourcePermission values (300697, 162, 'usersegmentcontentdisplay', 4, '700500_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P9P1', 174, 0, 1);
		insert into ResourcePermission values (300698, 162, 'usersegmentcontentdisplay', 4, '700500_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P9P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b92', 700503, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 22, 0, '<?xml version="1.0"?><root><name>user_segment_content_display_10</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P10P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_display_10', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300699, 162, 'com.liferay.portal.model.Layout', 4, '700503', 170, 0, 1);
		insert into ResourcePermission values (300700, 162, 'com.liferay.portal.model.Layout', 4, '700503', 174, 166, 1);
		insert into ResourcePermission values (300701, 162, 'com.liferay.portal.model.Layout', 4, '700503', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b93', 700504, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700503, false, '/user_segment_content_display_10', 'en_US');

	

	insert into PortletPreferences values (700505, 0, 3, 700503, 'usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P10P1', '<portlet-preferences><preference><name>queryContains1</name><value>true</value></preference><preference><name>queryAndOperator2</name><value>false</value></preference><preference><name>queryAndOperator4</name><value>false</value></preference><preference><name>userSegmentAssetCategoryIds4</name><value>700428</value></preference><preference><name>showAssetTitle</name><value>false</value></preference><preference><name>queryContains4</name><value>true</value></preference><preference><name>userSegmentAssetCategoryIds3</name><value>700386</value></preference><preference><name>assetEntryIdDefault</name><value>264</value></preference><preference><name>queryContains2</name><value>true</value></preference><preference><name>queryLogicIndexes</name><value>0</value><value>1</value><value>2</value><value>3</value><value>4</value></preference><preference><name>assetEntryId2</name><value>236</value></preference><preference><name>queryAndOperator0</name><value>false</value></preference><preference><name>queryContains3</name><value>true</value></preference><preference><name>enableSocialBookmarks</name><value>false</value></preference><preference><name>displayStyleGroupId</name><value>1</value></preference><preference><name>queryAndOperator1</name><value>false</value></preference><preference><name>assetEntryId3</name><value>236</value></preference><preference><name>contentDefaultValue</name><value>false</value></preference><preference><name>assetEntryId1</name><value>236</value></preference><preference><name>userSegmentAssetCategoryIds1</name><value>700446</value></preference><preference><name>displayStyle</name><value>full-content</value></preference><preference><name>assetEntryId4</name><value>278</value></preference><preference><name>queryAndOperator3</name><value>false</value></preference><preference><name>assetEntryId0</name><value>222</value></preference><preference><name>userSegmentAssetCategoryIds2</name><value>700338</value></preference><preference><name>userSegmentAssetCategoryIds0</name><value>700434</value></preference><preference><name>queryContains0</name><value>true</value></preference></portlet-preferences>');


		insert into ResourcePermission values (300702, 162, 'usersegmentcontentdisplay', 4, '700503_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P10P1', 170, 0, 1);
		insert into ResourcePermission values (300703, 162, 'usersegmentcontentdisplay', 4, '700503_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P10P1', 174, 0, 1);
		insert into ResourcePermission values (300704, 162, 'usersegmentcontentdisplay', 4, '700503_LAYOUT_usersegmentcontentdisplay_WAR_contenttargetingweb_INSTANCE_P10P1', 177, 0, 1);


	insert into Layout values ('00000000-0000-0000-0000-00061b94', 700506, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 23, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_1</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P1P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_1', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300705, 162, 'com.liferay.portal.model.Layout', 4, '700506', 170, 0, 1);
		insert into ResourcePermission values (300706, 162, 'com.liferay.portal.model.Layout', 4, '700506', 174, 166, 1);
		insert into ResourcePermission values (300707, 162, 'com.liferay.portal.model.Layout', 4, '700506', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b95', 700507, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700506, false, '/user_segment_content_list_1', 'en_US');

	

	insert into PortletPreferences values (700508, 0, 3, 700506, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P1P1', '<portlet-preferences />');


		insert into ResourcePermission values (300708, 162, 'usersegmentcontentlist', 4, '700506_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P1P1', 170, 0, 1);
		insert into ResourcePermission values (300709, 162, 'usersegmentcontentlist', 4, '700506_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P1P1', 174, 0, 1);
		insert into ResourcePermission values (300710, 162, 'usersegmentcontentlist', 4, '700506_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P1P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b96', 700509, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 24, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_2</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P2P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_2', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300711, 162, 'com.liferay.portal.model.Layout', 4, '700509', 170, 0, 1);
		insert into ResourcePermission values (300712, 162, 'com.liferay.portal.model.Layout', 4, '700509', 174, 166, 1);
		insert into ResourcePermission values (300713, 162, 'com.liferay.portal.model.Layout', 4, '700509', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b97', 700510, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700509, false, '/user_segment_content_list_2', 'en_US');

	

	insert into PortletPreferences values (700511, 0, 3, 700509, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P2P1', '<portlet-preferences />');


		insert into ResourcePermission values (300714, 162, 'usersegmentcontentlist', 4, '700509_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P2P1', 170, 0, 1);
		insert into ResourcePermission values (300715, 162, 'usersegmentcontentlist', 4, '700509_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P2P1', 174, 0, 1);
		insert into ResourcePermission values (300716, 162, 'usersegmentcontentlist', 4, '700509_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P2P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b98', 700512, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 25, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_3</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P3P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_3', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300717, 162, 'com.liferay.portal.model.Layout', 4, '700512', 170, 0, 1);
		insert into ResourcePermission values (300718, 162, 'com.liferay.portal.model.Layout', 4, '700512', 174, 166, 1);
		insert into ResourcePermission values (300719, 162, 'com.liferay.portal.model.Layout', 4, '700512', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b99', 700513, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700512, false, '/user_segment_content_list_3', 'en_US');

	

	insert into PortletPreferences values (700514, 0, 3, 700512, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P3P1', '<portlet-preferences />');


		insert into ResourcePermission values (300720, 162, 'usersegmentcontentlist', 4, '700512_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P3P1', 170, 0, 1);
		insert into ResourcePermission values (300721, 162, 'usersegmentcontentlist', 4, '700512_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P3P1', 174, 0, 1);
		insert into ResourcePermission values (300722, 162, 'usersegmentcontentlist', 4, '700512_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P3P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b9a', 700515, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 26, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_4</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P4P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_4', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300723, 162, 'com.liferay.portal.model.Layout', 4, '700515', 170, 0, 1);
		insert into ResourcePermission values (300724, 162, 'com.liferay.portal.model.Layout', 4, '700515', 174, 166, 1);
		insert into ResourcePermission values (300725, 162, 'com.liferay.portal.model.Layout', 4, '700515', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b9b', 700516, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700515, false, '/user_segment_content_list_4', 'en_US');

	

	insert into PortletPreferences values (700517, 0, 3, 700515, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P4P1', '<portlet-preferences />');


		insert into ResourcePermission values (300726, 162, 'usersegmentcontentlist', 4, '700515_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P4P1', 170, 0, 1);
		insert into ResourcePermission values (300727, 162, 'usersegmentcontentlist', 4, '700515_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P4P1', 174, 0, 1);
		insert into ResourcePermission values (300728, 162, 'usersegmentcontentlist', 4, '700515_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P4P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b9c', 700518, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 27, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_5</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P5P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_5', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300729, 162, 'com.liferay.portal.model.Layout', 4, '700518', 170, 0, 1);
		insert into ResourcePermission values (300730, 162, 'com.liferay.portal.model.Layout', 4, '700518', 174, 166, 1);
		insert into ResourcePermission values (300731, 162, 'com.liferay.portal.model.Layout', 4, '700518', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b9d', 700519, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700518, false, '/user_segment_content_list_5', 'en_US');

	

	insert into PortletPreferences values (700520, 0, 3, 700518, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P5P1', '<portlet-preferences />');


		insert into ResourcePermission values (300732, 162, 'usersegmentcontentlist', 4, '700518_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P5P1', 170, 0, 1);
		insert into ResourcePermission values (300733, 162, 'usersegmentcontentlist', 4, '700518_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P5P1', 174, 0, 1);
		insert into ResourcePermission values (300734, 162, 'usersegmentcontentlist', 4, '700518_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P5P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061b9e', 700521, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 28, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_6</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P6P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_6', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300735, 162, 'com.liferay.portal.model.Layout', 4, '700521', 170, 0, 1);
		insert into ResourcePermission values (300736, 162, 'com.liferay.portal.model.Layout', 4, '700521', 174, 166, 1);
		insert into ResourcePermission values (300737, 162, 'com.liferay.portal.model.Layout', 4, '700521', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061b9f', 700522, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700521, false, '/user_segment_content_list_6', 'en_US');

	

	insert into PortletPreferences values (700523, 0, 3, 700521, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P6P1', '<portlet-preferences />');


		insert into ResourcePermission values (300738, 162, 'usersegmentcontentlist', 4, '700521_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P6P1', 170, 0, 1);
		insert into ResourcePermission values (300739, 162, 'usersegmentcontentlist', 4, '700521_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P6P1', 174, 0, 1);
		insert into ResourcePermission values (300740, 162, 'usersegmentcontentlist', 4, '700521_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P6P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061ba0', 700524, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 29, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_7</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P7P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_7', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300741, 162, 'com.liferay.portal.model.Layout', 4, '700524', 170, 0, 1);
		insert into ResourcePermission values (300742, 162, 'com.liferay.portal.model.Layout', 4, '700524', 174, 166, 1);
		insert into ResourcePermission values (300743, 162, 'com.liferay.portal.model.Layout', 4, '700524', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061ba1', 700525, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700524, false, '/user_segment_content_list_7', 'en_US');

	

	insert into PortletPreferences values (700526, 0, 3, 700524, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P7P1', '<portlet-preferences />');


		insert into ResourcePermission values (300744, 162, 'usersegmentcontentlist', 4, '700524_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P7P1', 170, 0, 1);
		insert into ResourcePermission values (300745, 162, 'usersegmentcontentlist', 4, '700524_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P7P1', 174, 0, 1);
		insert into ResourcePermission values (300746, 162, 'usersegmentcontentlist', 4, '700524_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P7P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061ba2', 700527, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 30, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_8</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P8P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_8', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300747, 162, 'com.liferay.portal.model.Layout', 4, '700527', 170, 0, 1);
		insert into ResourcePermission values (300748, 162, 'com.liferay.portal.model.Layout', 4, '700527', 174, 166, 1);
		insert into ResourcePermission values (300749, 162, 'com.liferay.portal.model.Layout', 4, '700527', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061ba3', 700528, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700527, false, '/user_segment_content_list_8', 'en_US');

	

	insert into PortletPreferences values (700529, 0, 3, 700527, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P8P1', '<portlet-preferences />');


		insert into ResourcePermission values (300750, 162, 'usersegmentcontentlist', 4, '700527_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P8P1', 170, 0, 1);
		insert into ResourcePermission values (300751, 162, 'usersegmentcontentlist', 4, '700527_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P8P1', 174, 0, 1);
		insert into ResourcePermission values (300752, 162, 'usersegmentcontentlist', 4, '700527_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P8P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061ba4', 700530, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 31, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_9</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P9P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_9', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300753, 162, 'com.liferay.portal.model.Layout', 4, '700530', 170, 0, 1);
		insert into ResourcePermission values (300754, 162, 'com.liferay.portal.model.Layout', 4, '700530', 174, 166, 1);
		insert into ResourcePermission values (300755, 162, 'com.liferay.portal.model.Layout', 4, '700530', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061ba5', 700531, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700530, false, '/user_segment_content_list_9', 'en_US');

	

	insert into PortletPreferences values (700532, 0, 3, 700530, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P9P1', '<portlet-preferences />');


		insert into ResourcePermission values (300756, 162, 'usersegmentcontentlist', 4, '700530_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P9P1', 170, 0, 1);
		insert into ResourcePermission values (300757, 162, 'usersegmentcontentlist', 4, '700530_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P9P1', 174, 0, 1);
		insert into ResourcePermission values (300758, 162, 'usersegmentcontentlist', 4, '700530_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P9P1', 177, 0, 1);

	insert into Layout values ('00000000-0000-0000-0000-00061ba6', 700533, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', false, 32, 0, '<?xml version="1.0"?><root><name>user_segment_content_list_10</name></root>', '', '', '', '', 'portlet', 'column-2=usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P10P1,\nlayout-template-id=2_columns_ii\n', false, '/user_segment_content_list_10', false, 0, '', '', '', '', '', 0, '', false, '');


		insert into ResourcePermission values (300759, 162, 'com.liferay.portal.model.Layout', 4, '700533', 170, 0, 1);
		insert into ResourcePermission values (300760, 162, 'com.liferay.portal.model.Layout', 4, '700533', 174, 166, 1);
		insert into ResourcePermission values (300761, 162, 'com.liferay.portal.model.Layout', 4, '700533', 177, 0, 1);


	insert into LayoutFriendlyURL values ('00000000-0000-0000-0000-00061ba7', 700534, 1, 162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', 700533, false, '/user_segment_content_list_10', 'en_US');

	

	insert into PortletPreferences values (700535, 0, 3, 700533, 'usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P10P1', '<portlet-preferences />');


		insert into ResourcePermission values (300762, 162, 'usersegmentcontentlist', 4, '700533_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P10P1', 170, 0, 1);
		insert into ResourcePermission values (300763, 162, 'usersegmentcontentlist', 4, '700533_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P10P1', 174, 0, 1);
		insert into ResourcePermission values (300764, 162, 'usersegmentcontentlist', 4, '700533_LAYOUT_usersegmentcontentlist_WAR_contenttargetingweb_INSTANCE_P10P1', 177, 0, 1);


	insert into CT_Campaign values ('00000000-0000-0000-0000-00061ba8', 700536, 1,  162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">Campaign 0</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">Campaign 0</Description></root>', '2016-07-11 14:14:23', '2018-07-11 14:14:23', 1, true);


		insert into ResourcePermission values (300765, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700536', 170, 0, 1);
		insert into ResourcePermission values (300766, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700536', 174, 166, 1);
		insert into ResourcePermission values (300767, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700536', 177, 0, 1);

	insert into CT_Campaigns_UserSegments values (700536, 700301);
	insert into CT_Campaign values ('00000000-0000-0000-0000-00061ba9', 700537, 1,  162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">Campaign 1</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">Campaign 1</Description></root>', '2016-07-11 14:14:23', '2018-07-11 14:14:23', 3, true);


		insert into ResourcePermission values (300768, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700537', 170, 0, 1);
		insert into ResourcePermission values (300769, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700537', 174, 166, 1);
		insert into ResourcePermission values (300770, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700537', 177, 0, 1);

	insert into CT_Campaigns_UserSegments values (700537, 700302);
	insert into CT_Campaign values ('00000000-0000-0000-0000-00061baa', 700538, 1,  162, 166, 'Sample', '2017-07-11 14:14:23', '2017-07-11 14:14:23', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Name language-id="en_US">Campaign 2</Name></root>', '<?xml version="1.0" encoding="UTF-8"?><root available-locales="en_US" default-locale="en_US"><Description language-id="en_US">Campaign 2</Description></root>', '2016-07-11 14:14:23', '2018-07-11 14:14:23', 3, true);


		insert into ResourcePermission values (300771, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700538', 170, 0, 1);
		insert into ResourcePermission values (300772, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700538', 174, 166, 1);
		insert into ResourcePermission values (300773, 162, 'com.liferay.content.targeting.model.RuleInstance', 4, '700538', 177, 0, 1);

	insert into CT_Campaigns_UserSegments values (700538, 700303);



	update Counter set currentId = 700539 where name = 'com.liferay.counter.model.Counter';
	update Counter set currentId = 300774 where name = 'com.liferay.portal.model.ResourcePermission';
	update Counter set currentId = 8 where name = 'com.liferay.portlet.social.model.SocialActivity';

COMMIT_TRANSACTION