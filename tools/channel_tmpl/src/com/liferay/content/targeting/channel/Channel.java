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

package com.liferay.content.targeting.channel.@channel.java.package.name@;

import com.liferay.content.targeting.InvalidChannelException;
import com.liferay.content.targeting.api.model.BaseChannel;
import com.liferay.content.targeting.api.model.Channel;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Brian Chan
 */
@Component(immediate = true, service = Channel.class)
public class @channel.java.class.name@Channel extends BaseChannel {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public String getIcon() {
		return "icon-puzzle";
	}

	@Override
	public String getSummary(ChannelInstance channelInstance, Locale locale) {
		return LanguageUtil.get(locale, channelInstance.getTypeSettings());
	}

	@Override
	public String processChannel(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidChannelException {

		return StringPool.BLANK;
	}

	@Override
	protected void populateContext(
		ChannelInstance channelInstance, Map<String, Object> context,
		Map<String, String> values) {
	}

}