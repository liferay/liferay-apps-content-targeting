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

package com.liferay.contenttargeting.model.impl;

import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The extended model implementation for the UserSegment service. Represents a row in the &quot;CT_UserSegment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.model.UserSegment} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class UserSegmentImpl extends UserSegmentBaseImpl {

	public UserSegmentImpl() {
	}

	public List<RuleInstance> getRuleInstances() throws SystemException {
		return RuleInstanceLocalServiceUtil.getRuleInstances(
			getUserSegmentId());
	}

	public boolean matches(CTUser ctUser, RulesRegistry rulesRegistry)
		throws Exception {

		List<RuleInstance> rules = getRuleInstances();

		for (RuleInstance ruleInstance : rules) {
			Rule rule = rulesRegistry.getRule(ruleInstance.getRuleKey());

			if (!rule.evaluate(ruleInstance, ctUser)) {
				return false;
			}
		}

		return true;
	}

}