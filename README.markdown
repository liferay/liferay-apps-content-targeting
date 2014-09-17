# Liferay Audience Targeting application

"Audience Targeting” is a new App for Liferay 6.2 that will put the engagement
 experience of your portal at a whole new level. This app allows you to segment
 your audience, target specific content to different user segments, create 
 campaigns for them and measure quickly the effectivity.

![Audience Targeting App](https://raw.githubusercontent.com/liferay/liferay-apps-content-targeting/master/audience_targeting_icon.png) 

The Liferay Audience Targeting application is part of the Liferay Portal
project.
[Liferay Portal]
(http://www.liferay.com/community/liferay-projects/liferay-portal) is an
open source enterprise web platform for building business solutions that deliver
immediate results and long-term value. Liferay Portal started out as a personal
development project in 2000 and was open sourced in 2001.

To get started, check out the project's community homepage at
[http://liferay.org](http://liferay.org)!

The Audience Targeting application are a subset of plugins related to the Web
Content Management Experience that enhance Liferay WCM capabilities.

Most of the plugins found in the liferay-plugins repository can be easily
installed on Liferay Portal via [Liferay
Marketplace](http://liferay.com/marketplace). To build one or more of the
plugins yourself, read below for details.

## Quick Start

### Deployment

In order to deploy the Audience Targeting application, you need to go through
the following steps:

1. Obtain the latest version of the Liferay 6.2 SDK. You can clone locally the
6.2.x branch of the [liferay-plugins]
(https://github.com/liferay/liferay-plugins) repository.
2. Init the Audience Targeting application submodule in the Liferay 6.2 SDK by
running these commands:
	```
	git submodule init
	git submodule update
	```
3. Set this property in the build.<username>.properties of your Liferay SDK:
	```
	plugins.includes=*-api,*-hook,*-service,*-web,report-*,rule-*,runtime-dependencies,tracking-action-*
	```
4. Go to apps/content-targeting and run `ant build-app`

### OSGI Console

The OSGi bundle console gives information about the bundles that are currently
 available in the container and allows some operations over them. In order to
 start the console just run `telnet localhost 6666` once the Audience Targeting
 application plugins have been deployed.

Some useful commands:

* bundles: list bundles and status
* start [bundle id]: starts a bundle
* stop [bundle id]: stops a bundle
* uninstall [bundle id]: uninstalls a bundle

### Testing

In order to execute the Integration tests locally you have to go through the
following steps:

1. Append the test modules to the `plugins.includes` property of your
build.<username>.properties file:
	```
	plugins.includes=<all other audience targeting application modules>,*-test,runtime-test-dependencies
	```
2. Make sure you have deployed all the Audience Targeting application plugins
and that your server is running.
3. Go to apps/content-targeting and run `ant test`. In order to run the tests
from the IDE (e.g. IntelliJ), you should update the
folder of the runner to use the folder of your plugin as the working directory.

### Troubleshooting

#### Exceptions when deploying the plugins

There are some issues with the Spring context and OSGI context. They can easily
by bypassed deploying the apps when the server is already started or also adding
this property to portal-ext.properties:

	```
	module.framework.properties.felix.fileinstall.start.level=20
	```

## User Guide

Take a look to the [Liferay Portal User Guide]
(https://www.liferay.com/documentation/liferay-portal/6.2/user-guide) for
information about using Liferay Portal.

The Audience Targeting application is built on top of Liferay Portal and follows
the same usability patterns. For more information about how to use Audience
Targeting, read this [User Guide](USING.markdown).

## Source Code

The source code of the Audience Targeting application is located in the
[liferay-apps-content-targeting]
(https://github.com/liferay/liferay-apps-content-targeting) repository. This
repository is aggregated as a submodule of the [liferay-plugins]
(https://github.com/liferay/liferay-plugins) repository under /apps.

## Contributing

Liferay welcomes any and all contributions! If you have an idea for a new plugin
or a new feature in an existing plugin, and wish to implement it, follow the
contribution steps outlined in the [CONTRIBUTING
guide](CONTRIBUTING.markdown).
It explains how to contribute to Liferay and contains links to additional useful
resources.

## Development

The master branch of the Liferay Audience Targeting application is developed for
Liferay 6.2 CE using the 6.2 version of the plugins SDK.

The Audience Targeting application is designed as a framework to be extended by
other developers easily. See this [DEVELOPING guide](DEVELOPING.markdown).

## More Information

For more information about filling bugs, staying updated with Liferay on social
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