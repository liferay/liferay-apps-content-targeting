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

package com.liferay.content.targeting.model.impl;

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;
import java.util.Map;

/**
 * The extended model implementation for the RuleInstance service. Represents a row in the &quot;CT_RuleInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.model.RuleInstance} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class RuleInstanceImpl extends RuleInstanceBaseImpl {

	public RuleInstanceImpl() {
	}

	public String getRuleGuid() {
		return _ruleGuid;
	}

	@Override
	public String getUserSegmentName(Locale locale) {
		try {
			UserSegment userSegment =
				UserSegmentLocalServiceUtil.getUserSegment(getUserSegmentId());

			return userSegment.getName(locale);
		}
		catch (Exception e) {
		}

		return StringPool.BLANK;
	}

	public Map<String, String> getValues() {
		return _values;
	}

	public void setRuleGuid(String ruleGuid) {
		_ruleGuid = ruleGuid;
	}

	public void setValues(Map<String, String> values) {
		this._values = values;
	}

	private String _ruleGuid;
	private Map<String, String> _values;

}