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
2. Clone your own forked GitHub repos. Go to a location on your computer that
you wish to have a copy of the Audience Targeting application source stored.
This could be a "Development" directory within your
<plugins-sdk>/apps/content-targeting. Once in this location, issue the following
git commands to clone your forked repositories to your computer:
	```
	git clone ssh://git@github.com/your-github-username/liferay-apps-content-targeting.git
	```
3. Configure the remote upstream repository for liferay-apps-content-targeting.
Run the command below inside the content-targeting.
	```
	git remote add upstream git://github.com/liferay/liferay-apps-content-targeting.git
	```
4. Create local master branch from the upstream. Run the command below inside
the content-targeting directory.
	```
	git checkout -b master "upstream/master"
	```
5. Sync changes from upstream. If the main repository changes, you will need to
sync changes from upstream. You can accomplish this with the following commands:
	* Get all the updates from upstream
		```
		git fetch upstream
		```
	* Switch to the master branch
		```
		git checkout master
		```
	* Rebase the master branch. With rebase, all local commits are stashed and applied after the fetch
		```
		git pull --rebase upstream master
		```
	* Push the updates to origin
		```
		git push origin master
		```

Now the local, origin, and upstream repositories are all current

6.Add this line to your portal-ext.properties. (It is only needed for building the apps, but it won't have any effect during runtime, therefore it is only used when developing).
```
resource.actions.configs=META-INF/resource-actions/default.xml,resource-actions/default.xml
```
