package com.liferay.freemarker.osgi;

import freemarker.cache.TemplateLoader;
import freemarker.ext.servlet.FreemarkerServlet;
import org.osgi.framework.Bundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;

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
