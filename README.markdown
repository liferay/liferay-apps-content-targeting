# Liferay Audience Targeting application

*Audience Targeting* is a new App for Liferay 6.2 that will put the engagement
 experience of your portal at a whole new level. This app allows you to segment
 your audience, target specific content to different user segments, create 
 campaigns for them and measure the campaigns' effectivness quickly.

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

The Audience Targeting application is a subset of plugins related to the Web
Content Management Experience that enhance Liferay WCM capabilities.

The Audience Targeting App can be easily installed on Liferay Portal via
[Liferay Marketplace](http://liferay.com/marketplace).
To build the app yourself, read below for details.

## Quick Start

### Deployment

In order to deploy the Audience Targeting application, you need to go through
the following steps:

1. Obtain the latest version of the Liferay 6.2 SDK. You can clone locally the
6.2.x branch of the [liferay-plugins]
(https://github.com/liferay/liferay-plugins) repository.
2. Init the Audience Targeting application submodule in the Liferay 6.2 SDK by
running these commands inside the directory apps/content-targeting:

		git submodule init
		git submodule update

3. Set these properties in the `build.<username>.properties` of your Liferay SDK:

		plugins.includes=*-api,*-hook,*-service,*-web,report-*,rule-*,tracking-action-*
		plugin.excludes=*-test

4. Go to apps/content-targeting and run `ant build-app`

### Documentation

Take a look at the [Liferay Portal User Guide](https://dev.liferay.com/discover/portal)
for information about using Liferay Portal.

The Audience Targeting application is built on top of Liferay Portal and follows
the same usability patterns. For more information about how to use Audience
Targeting, read the [Targeting Content to your Audience]
(https://dev.liferay.com/discover/portal/-/knowledge_base/6-2/targeting-content-to-your-audience)
section.

There are also available several [Tutorials in the Liferay Developer Network]
(https://dev.liferay.com/develop/tutorials/-/knowledge_base/6-2/audience-targeting)
to guide you through all the available extensions to the Audience Targeting App.


## Development

The *master* branch of this repository will always contain the latest release
available of the app.

The latest work can be found in the branch *develop*.

Please, send any pull request to the user @liferay and the branch *develop* and
we will start a discussion there about your changes.

The master branch of the Liferay Audience Targeting application is developed for
Liferay 6.2 CE using the 6.2 version of the plugins SDK.

The Audience Targeting application is designed as a framework to be extended by
other developers easily. See the Audience Targeting [tutorials](https://dev.liferay.com/develop/tutorials/-/knowledge_base/6-2/audience-targeting).

### Source Code

The source code of the Audience Targeting application is located in the
[liferay-apps-content-targeting]
(https://github.com/liferay/liferay-apps-content-targeting) repository. This
repository is aggregated as a submodule of the [liferay-plugins]
(https://github.com/liferay/liferay-plugins) repository under /apps.

Execute `git tag` to see the tags of the different released versions of the app.

### Contributing

We welcome any and all contributions! If you have an idea for a new plugin
or a new feature in an existing plugin, and wish to implement it, just send a
pull request to the user @liferay and to the branch *develop* and
we will start a discussion there around your changes.

You can contact us in the [forums]
(https://www.liferay.com/es/community/forums/-/message_boards/category/43900641)
 and create bugs or feature requests in our [issue tracker]
 (http://issues.liferay.com/browse/WCM).


### Testing

In order to execute the Integration tests locally, you have to go through the
following steps:

1. Append the test modules to the `plugins.includes` property of your
`build.<username>.properties` file:

		plugins.includes=<all other audience targeting application modules>,*-test,runtime-test-dependencies

2. Make sure you have deployed all the Audience Targeting application plugins
and that your server is running.
3. Go to apps/content-targeting and run `ant test`. In order to run the tests
from the IDE (e.g. IntelliJ), you should update the
folder of the runner to use the folder of your plugin as the working directory.


### OSGI Console

The OSGi bundle console gives information about the bundles that are currently
 available in the container and allows some operations over them. In order to
 start the console you need to add this line to your portal-ext.properties

```
module.framework.properties.osgi.console=11311
```

 Then you can just run `telnet localhost 11311` once the Audience Targeting
 application plugins have been deployed.

Some useful commands:

* bundles: list bundles and status
* start [bundle id]: starts a bundle
* stop [bundle id]: stops a bundle
* uninstall [bundle id]: uninstalls a bundle

## More Information

Bugs and Feature Requests for the project can be found in our [issue tracker]
(http://issues.liferay.com/browse/WCM).

Feel free to ask us anything in our [forums]
(https://www.liferay.com/es/community/forums/-/message_boards/category/43900641).

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
