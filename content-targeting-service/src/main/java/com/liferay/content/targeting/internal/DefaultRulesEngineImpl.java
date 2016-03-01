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

package com.liferay.content.targeting.internal;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesEngine;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component
public class DefaultRulesEngineImpl implements RulesEngine {

	public long[] getMatchingUserSegmentIds(
		HttpServletRequest request, AnonymousUser anonymousUser,
		List<UserSegment> userSegments) {

		List<Long> userSegmentIds = new ArrayList<>();

		for (UserSegment userSegment : userSegments) {
			if (matches(
					request, anonymousUser, userSegment.getRuleInstances())) {

				updateAnonymousUserUserSegment(anonymousUser, userSegment);

				userSegmentIds.add(userSegment.getUserSegmentId());
			}
		}

		return ArrayUtil.toLongArray(userSegmentIds);
	}

	@Override
	public boolean matches(
		HttpServletRequest request, AnonymousUser anonymousUser,
		List<RuleInstance> ruleInstances) {

		for (RuleInstance ruleInstance : ruleInstances) {
			Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

			if (rule == null) {
				continue;
			}

			try {
				if (!rule.evaluate(request, ruleInstance, anonymousUser)) {
					return false;
				}
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Couldn't evaluate Rule " + ruleInstance.getRuleKey());
				}

				return false;
			}
		}

		return true;
	}

	@Reference(unbind = "unsetRulesRegistry")
	public void setRulesRegistry(RulesRegistry rulesRegistry) {
		_rulesRegistry = rulesRegistry;
	}

	protected void unsetRulesRegistry() {
		_rulesRegistry = null;
	}

	protected void updateAnonymousUserUserSegment(
		AnonymousUser anonymousUser, UserSegment userSegment) {

		Date now = new Date();

		Message message = new Message();

		message.put("anonymousUserId", anonymousUser.getAnonymousUserId());
		message.put("companyId", anonymousUser.getCompanyId());
		message.put("date", now.getTime());
		message.put("userId", anonymousUser.getUserId());
		message.put("userSegmentId", userSegment.getUserSegmentId());

		MessageBusUtil.sendMessage("liferay/anonymous_user_segments", message);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DefaultRulesEngineImpl.class);

	private RulesRegistry _rulesRegistry;

}