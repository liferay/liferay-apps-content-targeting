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

package com.liferay.content.targeting.service.messaging;

import com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalServiceUtil;
import com.liferay.content.targeting.service.AnonymousUserUserSegmentServiceUtil;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.CampaignServiceUtil;
import com.liferay.content.targeting.service.ChannelInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.ChannelInstanceServiceUtil;
import com.liferay.content.targeting.service.ClpSerializer;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.ReportInstanceServiceUtil;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.RuleInstanceServiceUtil;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.content.targeting.service.TacticServiceUtil;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.TrackingActionInstanceServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AnonymousUserUserSegmentLocalServiceUtil.clearService();

			AnonymousUserUserSegmentServiceUtil.clearService();
			CampaignLocalServiceUtil.clearService();

			CampaignServiceUtil.clearService();
			ChannelInstanceLocalServiceUtil.clearService();

			ChannelInstanceServiceUtil.clearService();
			ReportInstanceLocalServiceUtil.clearService();

			ReportInstanceServiceUtil.clearService();
			RuleInstanceLocalServiceUtil.clearService();

			RuleInstanceServiceUtil.clearService();
			TacticLocalServiceUtil.clearService();

			TacticServiceUtil.clearService();
			TrackingActionInstanceLocalServiceUtil.clearService();

			TrackingActionInstanceServiceUtil.clearService();
			UserSegmentLocalServiceUtil.clearService();

			UserSegmentServiceUtil.clearService();
		}
	}
}