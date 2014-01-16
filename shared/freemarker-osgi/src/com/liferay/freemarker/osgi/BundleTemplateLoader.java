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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.net.URL;

import org.osgi.framework.Bundle;

/**
 * @author Carlos Sierra Andrés
 */
public class BundleTemplateLoader implements TemplateLoader {

	public BundleTemplateLoader(Bundle bundle) {
		_bundle = bundle;
	}

	@Override
	public void closeTemplateSource(Object templateSource) throws IOException {
		BundleTemplateSource bundleTemplateSource =
			(BundleTemplateSource)templateSource;

		InputStream inputStream = bundleTemplateSource.getInputStream();

		inputStream.close();
	}

	@Override
	public Object findTemplateSource(String name) throws IOException {
		URL resource = _bundle.getResource(name);

		if (resource == null) {
			return null;
		}

		return new BundleTemplateSource(resource);
	}

	@Override
	public long getLastModified(Object templateSource) {
		return _bundle.getLastModified();
	}

	@Override
	public Reader getReader(Object templateSource, String encoding)
		throws IOException {

		BundleTemplateSource bundleTemplateSource =
			(BundleTemplateSource)templateSource;

		return new InputStreamReader(bundleTemplateSource.getInputStream());
	}

	public static class BundleTemplateSource {

		public BundleTemplateSource(URL url) throws IOException {

			_url = url;
			_inputStream = url.openStream();
		}

		public InputStream getInputStream() {
			return _inputStream;
		}

		public URL getUrl() {
			return _url;
		}

		private final InputStream _inputStream;

		private URL _url;
	}

	private Bundle _bundle;

}