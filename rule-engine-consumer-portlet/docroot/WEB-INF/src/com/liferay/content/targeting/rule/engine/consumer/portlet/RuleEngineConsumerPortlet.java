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

package com.liferay.content.targeting.rule.engine.consumer.portlet;

import com.liferay.compat.util.bridges.mvc.MVCPortlet;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.content.targeting.rule.engine.service.RuleEngineLocalServiceUtil;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Sample portlet using the Rule Engine API
 *
 * @author Eduardo Garcia
 */
public class RuleEngineConsumerPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long[] userSegmentIds = new long[]{};

		try {

			// TODO: parametrize anonymousUserId

			AnonymousUser anonymousUser =
				AnonymousUserLocalServiceUtil.fetchAnonymousUserByUserId(
					themeDisplay.getUserId());

			if (anonymousUser != null) {
				userSegmentIds =
					RuleEngineLocalServiceUtil.getMatchesUserSegmentIds(
						themeDisplay.getRequest(),
						themeDisplay.getScopeGroupId(),
						anonymousUser.getAnonymousUserId());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		renderRequest.setAttribute("userSegmentIds", userSegmentIds);

		super.doView(renderRequest, renderResponse);
	}

}