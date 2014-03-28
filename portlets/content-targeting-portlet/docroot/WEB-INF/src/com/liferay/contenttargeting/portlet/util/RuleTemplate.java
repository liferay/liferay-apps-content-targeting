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

package com.liferay.contenttargeting.portlet.util;

import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Eudaldo Alonso
 */
public class RuleTemplate {

	public String getTemplateKey() {
		String templateKey = _rule.getRuleKey();

		if (_instanceId > 0) {
			templateKey = templateKey.concat(StringPool.UNDERLINE).concat(
				String.valueOf(_instanceId));
		}

		return templateKey;
	}

	public long getInstanceId() {
		return _instanceId;
	}

	public Rule getRule() {
		return _rule;
	}

	public String getTemplate() {
		return _template;
	}

	public void setInstanceId(long instanceId) {
		_instanceId = instanceId;
	}

	public void setRule(Rule rule) {
		_rule = rule;
	}

	public void setTemplate(String template) {
		_template = template;
	}

	private long _instanceId;
	private Rule _rule;
	private String _template;

}