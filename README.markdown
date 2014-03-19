# Liferay WCM Plugins

The liferay-wcm-plugins repository is part of the Liferay Portal project.
[Liferay Portal]
(http://www.liferay.com/community/liferay-projects/liferay-portal) is an
open source enterprise web platform for building business solutions that deliver
immediate results and long-term value. Liferay Portal started out as a personal
development project in 2000 and was open sourced in 2001.

To get started, check out the project's community homepage at
[http://liferay.org](http://liferay.org)!

The WCM Plugins are a subset of plugins related to the Web Content Management
Experience that enhance Liferay WCM capabilities.

The list of available plugins right now is:
* Audience Targeting (will be available as an app in the marketplace):

Most of the plugins found in the liferay-plugins repository can be easily
installed on Liferay Portal via [Liferay
Marketplace](http://liferay.com/marketplace). To build one or more of the
plugins yourself, read below for details.

## Quick Start

In the [liferay-wcm-plugins](https://github.com/liferay/temp-wcm-plugins)
repository, plugins are laid out in a software development kit (SDK) -- the
Liferay Plugins SDK. All Liferay plugin types, including portlets, themes,
layout templates, hooks, and EXT plugins, can be created and maintained in the
 SDK. [The Plugins SDK]
 (http://www.liferay.com/documentation/liferay-portal/6.1/development/-/ai/the-plugins-s-3)
chapter of Liferay's [Development Guide]
(http://www.liferay.com/documentation/liferay-portal/6.1/development)
explains how to create, build, and deploy your plugins. Follow the instructions
in this section to build and deploy any of the existing SDK plugins quickly.

For demonstration purposes, let's pretend your user name is *joe* and you have a
Liferay instance bundled with Apache Tomcat running in your `/home/joe/`
directory.

1. Fork the [liferay-wcm-plugins](https://github.com/liferay/temp-wcm-plugins)
repository.

2. Clone your fork of the repository.
3. Create a `build.${username}.properties` file in the root directory of your
liferay-wcm-plugins repository clone. Be sure to replace `${username}` with your
user name.

		/home/joe/liferay-wcm-plugins/build.joe.properties

	Note, to determine your user name, execute `echo %USERNAME%` on Windows or
	`whoami` on Unix/Linux.

4. In your `build.${username}.properties` file, specify the
`app.server.parent.dir` property set to the parent path of your app server.

    	app.server.parent.dir=/home/joe/liferay-portal-6.1.1-ga2

	Use your `build.${username}.properties` file to specify any additional
	properties you wish to override from the base `build.properties` file; do
	not modify the base file.

5. Navigate to the directory of a plugin (e.g. *Sample JSP Portlet*) and deploy
it using Ant.

		cd /home/joe/liferay-wcm-plugins/portlets/sample-jsp-portlet
		ant deploy

	The plugin compiles, its WAR file is built to the plugin's `dist` directory,
	the WAR file is copied to your Liferay *Hot Deploy* directory, and the
	plugin is deployed immediately. It's just that easy!

There are many other options for developing new Liferay plugins using the
Plugins SDK. Consult the [Liferay Development
Guide](http://www.liferay.com/documentation/liferay-portal/6.1/development) for
indispensable explanations, examples, and reference material on the Liferay
Plugins SDK and surrounding technologies.

Also, check out Liferay IDE. The [Liferay IDE
project](http://www.liferay.com/community/liferay-projects/liferay-ide) provides
an Eclipse-based Liferay development environment to help you build and maintain
Liferay projects easily.

Finally, consider using Maven to build Liferay Plugins. For excellent overviews
of Maven support for Liferay, check out [Mika Koivisto's
presentation](http://www.slideshare.net/koivimik/developing-liferay-plugins-with-maven)
and [Getting Started with Liferay Maven
SDK](http://www.liferay.com/web/mika.koivisto/blog/-/blogs/12322618).

## Contributing

Liferay welcomes any and all contributions! If you have an idea for a new plugin
or a new feature in an existing plugin, and wish to implement it, follow the
contribution steps outlined in the [CONTRIBUTING
guide](https://github.com/liferay/liferay-portal/blob/master/CONTRIBUTING.markdown).
It explains how to contribute to Liferay and contains links to additional useful
resources.

## Development

The master branch of the plugins is developed for Liferay 6.2 CE GA1 using the
6.2.0-ce-ga1 version of the plugins SDK.

### Source Code

The Source code of the WCM plugins is organized in the following way:
* Audience Targeting
 * content-targeting-core (/shared) - contains all the common services and
classes for the app.
 * content-targeting-portlet (/portlet) - contains all the all portlets and UIs
 * ct-time-rule (/shared) - rule used by the audience targeting app to filter user audiences by time
 * ct-gender-rule (/shared) - rule used by the audience targeting app to filter user audiences by gender
 * ct-age-rule (/shared) - rule used by the audience targeting app to filter user audiences by age
 * ct-score-rule (/shared) - rule used by the audience targeting app to filter user audiences by their behavior
 * portal-6-2-x-compat-hook (/hooks) - Hook to make the content targeting plugins compatible with Liferay 6.2.x versions.
* OSGI modules required for the project
 * http-service-shared (/shared)
 * log-bridge-shared (/shared)
 * system-packages-extra (/shared)
 * service-utils-shared (/shared)
 * freemarker-osgi (/shared)
* Modules required to run the integration tests
 * arquillian-plugin-deployer (/shared) used for testing
* /modules - OSGI modules required to start the OSGI console

### Deployment

In order to deploy the audience targeting app, you can add this property to your
build.username.properties:

```
plugins.includes=anonymous-users-shared,content-targeting-core,content-targeting-portlet,ct-age-rule,ct-gender-rule,ct-time-rule,freemarker-osgi,http-service-shared,log-bridge-shared,service-utils-shared,system-packages-extra
```


### OSGI Console

The OSGi bundle console gives information about the bundles that are currently
 available in the container and allows some operations over them. In order to
 start the console just run `ant console` from the root folder of the project.

Some useful commands:

* bundles: list bundles and status
* start [bundle id]: starts a bundle
* stop [bundle id]: stops a bundle
* uninstall [bundle id]: uninstalls a bundle

### Freemarker

Set this property to 0 to always retrieve the freemarker code from the template
 instead of the cache.
`freemarker.engine.resource.modification.check.interval=0`

### Debugging

Since the project includes the IntelliJ project files, these configuration files
reference the source code of
[Liferay Portal](http://sourceforge.net/projects/lportal/files/Liferay%20Portal/)
and [Freemarker](http://sourceforge.net/projects/freemarker/files/freemarker/)
for debugging purposes. These sources should be in their own folder at the same
level of the root folder of the project.

### Testing

In order to to execute the Integration tests locally you should follow the
following steps:

1. Download the [Arquillian Liferay Container](https://github.com/liferay-labs/arquillian-liferay-container)
2. Execute `mvn install` from the root folder
3. Deploy the "arquillian-plugin-deployer" from the /shared folder of your
plugin
4. Deploy the plugin that you want to test, but do not deploy its test plugin.
5. Run your server and in the folder of your test plugin, execute `ant test`
In order to run the tests from the IDE (e.g. IntelliJ), you should update the
folder of the runner to use the folder of your plugin as the working directory.

### Troubleshooting

#### Missing dependencies

If a ClassNotFoundException occurs:
* If the class is not in the global classpath, make sure the dependency has been
 exported by the source component and imported in the consumer component:
 * For portal internal packages, check that they are exported in the
 module.framework.system.packages.extra property of the portal-ext.properties.
 * For bundle packages, check the Export-Package/Import-Package of the bnd.bnd
  file in the source/consumer bundles, respectively.
*If the class is in the global classpath, make sure the dependency has been
imported in the bnd.bnd file of the consumer component.

#### Changes are not visible after deploy
If the plugin has been successfully deployed but the changes are not visible,
check that the generated .jar in the /dist folder of the plugins SDK actually
 contains the latest modifications.

#### Exceptions when deploying the plugins
There are some issues with the Spring context and OSGI context. They can easily
by bypassed deploying the apps when the server is already started or also adding
this property to portal-ext.properties:

`module.framework.properties.felix.fileinstall.start.level=20`


## More Information

For more information about filing bugs, staying updated with Liferay on social
media, and other ways to participate, check out the [Liferay Community
Homepage](http://liferay.org) and consult the [README
file](https://github.com/liferay/liferay-portal/blob/master/README.markdown) in
the liferay-portal repository.

## Liferay Portal Community Edition License

This library, *Liferay Portal Community Edition*, is free software ("Licensed
Software"); you can redistribute it and/or modify it under the terms of the [GNU
Lesser General Public License](http://www.gnu.org/licenses/lgpl-2.1.html) as
published by the Free Software Foundation; either version 2.1 of the License, or
(at your option) any later version.

This library is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; including but not limited to, the implied warranty of MERCHANTABILITY,
NONINFRINGEMENT, or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
Public License for more details.

You should have received a copy of the [GNU Lesser General Public
License](http://www.gnu.org/licenses/lgpl-2.1.html) along with this library; if
not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth
Floor, Boston, MA 02110-1301 USA

