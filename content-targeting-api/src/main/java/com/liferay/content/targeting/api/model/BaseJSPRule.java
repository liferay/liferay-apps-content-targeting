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

package com.liferay.content.targeting.api.model;

import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Map;

import javax.servlet.ServletContext;

/**
 * @author Eduardo Garcia
 */
public abstract class BaseJSPRule extends BaseRule {

	@Override
	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		String content = StringPool.BLANK;

		try {
			populateContext(ruleInstance, context, values);

			content = ContentTargetingContextUtil.includeJSP(
				_servletContext, getFormTemplatePath(), context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing rule form template " +
					getFormTemplatePath(),
				e);
		}

		return content;
	}

	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	@Override
	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH;
	}

	private static final String _FORM_TEMPLATE_PATH = "/ct_fields.jsp";

	private static final Log _log = LogFactoryUtil.getLog(BaseJSPRule.class);

	private ServletContext _servletContext;

}