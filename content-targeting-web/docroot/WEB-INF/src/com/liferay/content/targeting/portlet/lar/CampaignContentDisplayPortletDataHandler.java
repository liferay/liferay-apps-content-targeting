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

package com.liferay.content.targeting.portlet.lar;

import com.liferay.content.targeting.portlet.util.CampaignQueryRuleUtil;
import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.List;

import javax.portlet.PortletPreferences;

/**
 * @author Eduardo Garcia
 */
public class CampaignContentDisplayPortletDataHandler
	extends BaseContentTargetingDisplayPortletDataHandler {

	protected List<QueryRule> getQueryRules(
			PortletPreferences portletPreferences)
		throws Exception {

		return CampaignQueryRuleUtil.getCampaignQueryRules(
			portletPreferences, LocaleUtil.getDefault(), false);
	}

}