/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package unit.com.liferay.contenttargeting.service.impl;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * @author Carlos Sierra Andrés
 */
public class BaseOsgiTestPlugin {

	@Deployment
	public static WebArchive getDeployment() throws FileNotFoundException {
		WebArchive webArchive = ShrinkWrap.create(WebArchive.class);

		//webArchive.
		return webArchive;
	}

}