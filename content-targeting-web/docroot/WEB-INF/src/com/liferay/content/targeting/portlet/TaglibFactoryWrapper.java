/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.content.targeting.portlet;

import freemarker.ext.jsp.TaglibFactory;

import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;

/**
 * @author Pavel Savinov
 */
public class TaglibFactoryWrapper implements TemplateHashModel {

	public TaglibFactoryWrapper(ServletContext servletContext) {
		_classLoader = servletContext.getClassLoader();
		_taglibFactory = new TaglibFactory(servletContext);
	}

	@Override
	public TemplateModel get(String uri) throws TemplateModelException {
		TemplateModel templateModel = _templateModels.get(uri);

		if (templateModel == null) {
			Thread currentThread = Thread.currentThread();

			ClassLoader contextClassLoader =
				currentThread.getContextClassLoader();

			try {
				currentThread.setContextClassLoader(_classLoader);

				templateModel = _taglibFactory.get(uri);
			}
			finally {
				currentThread.setContextClassLoader(contextClassLoader);
			}

			_templateModels.put(uri, templateModel);
		}

		return templateModel;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	private ClassLoader _classLoader;
	private final TaglibFactory _taglibFactory;
	private final Map<String, TemplateModel> _templateModels =
		new ConcurrentHashMap<>();

}