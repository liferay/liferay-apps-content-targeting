# Extending the Audience Targeting application (for Developers)

The Audience Targeting application is designed as a framework to be extended by
other developers easily.

They have a set of extension points that can be easily hooked using other
plugins that can be hot deployed into your Liferay installation.

These extension points include:
* Rule Types
* Rules Engine
* Reports
* Tracking Actions

## Creating new Rule Types

In the Audience Targeting application, a User Segment is defined as a group
of users that matches a set of rules. Out of the box, Liferay provides several
types of rules such as age range, gender, location...

Developers will be able to extend the set of available types of rules by
creating and deploying their own OSGi plugins which contain a class implementing
the [Rule Interface](https://github.com/liferay/liferay-apps-content-targeting/blob/master/content-targeting-api/service/com/liferay/contenttargeting/api/model/Rule.java).

OSGi plugins can be quickly hot deployed and undeployed, managing their own
dependencies and providing new services that other OSGi plugins can consume.
In the case of a rule OSGi plugin, it will be consumed by the Audience
Targeting application.

Adding a new type of rule to the Audience Targeting application is easy.
For example, let's see how to create a very simple rule called
"Timezone Rule"

1. Create a folder inside the /shared folder of your Liferay Plugins SDK. (such
as timezone-rule) (Developers can also copy one of the existing rule plugins
included in the Content Targeting repository and use it as a basis).
2. Add the following files to this folder:
	* [bnd.bnd](https://github.com/liferay/liferay-apps-content-targeting/blob/master/rule-time/bnd.bnd)
	* [build.xml](https://github.com/liferay/liferay-apps-content-targeting/blob/master/rule-time/build.xml)
3. Modify these files with the name of your rule and update the dependencies your
rule has. Now you have an OSGI plugin :)
4. Create a sources folder (src) in your rule folder and create a Java class
that implements the interface Rule and implement all the required method. (It
will be handy to extend the existing [BaseRule]
(https://github.com/liferay/liferay-apps-content-targeting/blob/master/content-targeting-api/src/com/liferay/contenttargeting/api/model/BaseRule.java)
but you are not forced to do so).
You will need this code to declare your class as an OSGI component that can be
consumed by the Rules Engine when your plugin is deployed:
	```
	@Component(immediate = true, service = Rule.class)
	```
Some of the methods that have to be implemented are:
	* `processRule`: This method will handle the information provided by the
	administrator when configuring this rule through the Rule GUI.
	For example, to store the selected time zone in the typeSettings field in the
	database from a select.
	* `evaluate`: This method determines whether a given user matches the rule with
	the information that has been stored. For example, it checks the time zone in
	the user profile and compares with the one stored in the database by the
	processRule method. If they match, it will return true.
	* `getFormHtml`: This method will return the HTML displayed to administrators
	when configuring a Rule through the Rule GUI. The BaseRule class already
	implements this method including a freemarker template placed in
	templates/ct_fields.ftl. For example, for the Time Zone Rule, we can add a
	selector with the available time zones.
	* `getIcon`: Configure the icon displayed in the Rule GUI. You should use the name
	 of a FontAwesome icon. For example: "icon-coffee" or "icon-globe"
	 (See <a href="http://fortawesome.github.io/Font-Awesome/3.2.1/">Font Awesome documentation</a>)
	* `getName`: The name of your Rule. (It can be localized)
	* `getSummary`: A description of the Rule once it is configured. This will be used
	to help administrators. For example, for "Users who are in Timezone GMT".

4. Finally, deploy the rule plugin in the Liferay server. The new rule will be
available in the add/edit User Segment form. When the User Segment admin selects
it, the piece of GUI defined by the developer (eg. the time zone selector) is
added to the add/edit User Segment form so that the admin can set a value for
that specific user segment.

## Customize the Rules Engine

## Creating new Reports

## Creating new Tracking Actions

# Troubleshooting

## Changes are not visible after deploy
If the plugin has been successfully deployed but the changes are not visible,
check that the generated .jar in the /dist folder of the plugins SDK actually
contains the latest modifications.

Also se this property to 0 to always retrieve the freemarker code from the
template instead of the cache:
```
freemarker.engine.resource.modification.check.interval=0
```
