package com.liferay.freemarker.osgi;

import freemarker.cache.TemplateLoader;
import org.osgi.framework.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

/**
 * @author Carlos Sierra Andrés
 */
public class BundleTemplateLoader implements TemplateLoader {

	public BundleTemplateLoader(Bundle bundle) {
		_bundle = bundle;
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
			(BundleTemplateSource) templateSource;

		return new InputStreamReader(bundleTemplateSource.getInputStream());
	}

	@Override
	public void closeTemplateSource(Object templateSource) throws IOException {
		BundleTemplateSource bundleTemplateSource =
			(BundleTemplateSource) templateSource;

		InputStream inputStream = bundleTemplateSource.getInputStream();

		inputStream.close();
	}

	private Bundle _bundle;

	public static class BundleTemplateSource {
		private final InputStream _inputStream;
		private URL _url;

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
	}
}
