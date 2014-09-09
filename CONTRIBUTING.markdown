# How to Contribute to the Audience Targeting application (for Developers)

## Contributing to Liferay

Liferay is developed by its community consisting of Liferay users, enthusiasts,
employees, customers, partners, and others. We strongly encourage you to
contribute to Liferay's open source projects by implementing new features,
enhancing existing features, and fixing bugs. We also welcome your participation
in our forums, writing documentation, and translating existing documentation.

Liferay is known for its innovative top quality features. To maintain this
reputation, all code changes are reviewed by a core set of Liferay project
maintainers. We encourage you to introduce yourself to the [core
maintainer(s)](http://issues.liferay.com/browse/LPS#selectedTab=com.atlassian.jira.plugin.system.project%3Acomponents-panel)
and engage them as you contribute to the areas they maintain.

As you have ideas for features you want to implement, follow the contribution
steps outlined in the [CONTRIBUTING
guide](https://github.com/liferay/liferay-portal/blob/master/CONTRIBUTING.markdown)
found in the [liferay-portal](https://github.com/liferay/liferay-portal)
repository. This guide contains details on how to contribute to Liferay and
additional useful resource links. For more details on specific steps, and to get
a deeper understanding of Liferay in general, make sure to read Liferay's
official [User
Guide](http://www.liferay.com/documentation/liferay-portal/6.2/user-guide) and
[Development
Guide](http://www.liferay.com/documentation/liferay-portal/6.2/development).
These guides contain extensive explanations, examples, and reference material
for you to consult time and time again.

## Contributing to the Audience Targeting application

In order to contribute your code to the Audience Targeting application you have
to go first through the steps described in the [Liferay CONTRIBUTING guide]
(https://github.com/liferay/liferay-portal/blob/master/CONTRIBUTING.markdown).

Then, follow these steps:

1. Fork the Audience Targeting application repository. Remember that the
Audience Targeting application is actually a submodule of the
[liferay-plugins](https://github.com/liferay/liferay-plugins)
repository. The source code lives in the [liferay-apps-content-targeting]
(https://github.com/liferay/liferay-apps-content-targeting) repository. You can
fork this repository to your GitHub account by visiting it and then click the
"Fork" button.
2. Obtain the latest version of the Liferay 6.2 SDK. You can clone locally the
6.2.x branch of the [liferay-plugins]
(https://github.com/liferay/liferay-plugins) repository.
3. Init the Audience Targeting application submodule in the Liferay 6.2 SDK by
running these commands:
	```
	git submodule init
	git submodule update
	```
4. Configure the remote upstream and origin repositories for
liferay-apps-content-targeting by editing the file
`.git/modules/apps/content-targeting/config`:
	```
	[core]
	repositoryformatversion = 0
	filemode = true
	bare = false
	logallrefupdates = true
	worktree = ../../../../apps/content-targeting
	[remote "origin"]
	url = <url-to-your-forked-repository>
	fetch = +refs/heads/*:refs/remotes/origin/*
	[remote "upstream"]
	url = git@github.com:liferay/liferay-apps-content-targeting.git
	fetch = +refs/heads/*:refs/remotes/upstream/*
	[branch "master"]
	remote = origin
	merge = refs/heads/master
	```
5. Add this line to your portal-ext.properties. (It is only needed for building the apps, but it won't have any effect during runtime, therefore it is only used when developing).
```
resource.actions.configs=META-INF/resource-actions/default.xml,resource-actions/default.xml
```
