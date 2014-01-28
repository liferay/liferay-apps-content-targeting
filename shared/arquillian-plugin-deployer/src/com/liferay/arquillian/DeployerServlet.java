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

package com.liferay.arquillian;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Carlos Sierra Andrés
 */
public class DeployerServlet extends HttpServlet {

	public static final String BUNDLE_CONTEXT_PATH = "Bundle-Context-Path";
	public static final String DEPLOYER_SERVLET_LOCATION = "DeployerServlet";
	public static final String TEXT = "text/text";
	public static final long TIMEOUT = 10 * 1000L;

	@Override
	protected void doDelete(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		BundleContext bundleContext = _bundle.getBundleContext();

		try {
			Bundle bundle = bundleContext.getBundle(DEPLOYER_SERVLET_LOCATION);

			bundle.stop();

			bundle.uninstall();
		} catch (BundleException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		DiskFileItemFactory factory = new DiskFileItemFactory();

		ServletConfig servletConfig = this.getServletConfig();

		ServletContext servletContext = servletConfig.getServletContext();
		File repository = (File) servletContext.getAttribute(
			"javax.servlet.context.tempdir");

		factory.setRepository(repository);

		ServletFileUpload upload = new ServletFileUpload(factory);

		BundleContext bundleContext = _bundle.getBundleContext();

		ServletOutputStream out = response.getOutputStream();

		try {
			List<FileItem> items = upload.parseRequest(request);

			FileItem fileItem = items.get(0);

			InputStream bundleInputStream = fileItem.getInputStream();

			Bundle newBundle = bundleContext.installBundle(
				DEPLOYER_SERVLET_LOCATION, bundleInputStream);

			newBundle.start();

			long bundleId = newBundle.getBundleId();

			Filter filter = bundleContext.createFilter(
				"(&(objectClass=com.liferay.httpservice.internal.servlet." +
					"BundleServletContext)(bundle.id=" + bundleId + "))");

			ServiceTracker serviceTracker = new ServiceTracker(
				bundleContext, filter, null);

			serviceTracker.open();

			ServletContext sc =
				(ServletContext) serviceTracker.waitForService(TIMEOUT);

			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType(TEXT);
			response.setHeader(BUNDLE_CONTEXT_PATH, sc.getContextPath());

		} catch (Exception e) {
			throw new ServletException(e);
		}
		finally {
			out.flush();
			out.close();
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ServletContext servletContext = config.getServletContext();

		_bundle = (Bundle) servletContext.getAttribute("OSGI_BUNDLE");
	}

	private Bundle _bundle;
}
