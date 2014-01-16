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

package com.liferay.freemarker.osgi;

import freemarker.cache.TemplateLoader;

import freemarker.ext.servlet.FreemarkerServlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.osgi.framework.Bundle;

/**
 * @author Carlos Sierra Andrés
 */
public class OsgiFreemarkerServlet extends FreemarkerServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();

		_bundle = (Bundle) servletContext.getAttribute("OSGI_BUNDLE");

		if (_bundle == null) {
			throw new ServletException(
				"Could not find bundle in servletContext under OSGI_BUNDLE");
		}

		super.init(config);
	}

	@Override
	protected TemplateLoader createTemplateLoader(String templatePath)
		throws IOException {

		return new BundleTemplateLoader(_bundle);
	}

	private Bundle _bundle;

}