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

import com.liferay.content.targeting.exception.InvalidChannelException;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Element;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author PavelSavinov
 */
public abstract class BaseChannel implements Channel {

	@Override
	public void activate() {
		if (_log.isDebugEnabled()) {
			_log.debug("Channel activate: " + getClass().getSimpleName());
		}
	}

	@Override
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			_log.debug("Channel deactivate: " + getClass().getSimpleName());
		}
	}

	@Override
	public void deleteData(ChannelInstance channelInstance)
		throws PortalException {
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element tacticElement,
			Tactic tactic, Element channelInstanceElement,
			ChannelInstance channelInstance)
		throws Exception {
	}

	@Override
	public String getChannelKey() {
		return getClass().getSimpleName();
	}

	@Override
	public String getDescription(Locale locale) {
		String key = getClass().getName().concat(".description");

		String description = ContentTargetingUtil.getModelResource(
			locale, getClass(), key);

		if (description.endsWith(key)) {
			description = getShortDescription(locale);
		}

		return description;
	}

	@Override
	public String getFormHTML(
		ChannelInstance channelInstance, Map<String, Object> context,
		Map<String, String> values) {

		String content = StringPool.BLANK;

		try {
			populateContext(channelInstance, context, values);

			content = ContentTargetingContextUtil.parseTemplate(
				getClass(), _FORM_TEMPLATE_PATH, context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing channel form template " +
					_FORM_TEMPLATE_PATH,
				e);
		}

		return content;
	}

	@Override
	public String getIcon() {
		return "icon-file";
	}

	@Override
	public String getName(Locale locale) {
		return ContentTargetingUtil.getModelResource(
			locale, getClass(), getClass().getName());
	}

	@Override
	public String getShortDescription(Locale locale) {
		String key = getClass().getName().concat(".shortDescription");

		String shortDescription = ContentTargetingUtil.getModelResource(
			locale, getClass(), key);

		if (shortDescription.endsWith(key)) {
			shortDescription = StringPool.BLANK;
		}

		return shortDescription;
	}

	@Override
	public void importData(
			PortletDataContext portletDataContext, Tactic tactic,
			ChannelInstance channelInstance)
		throws Exception {
	}

	@Override
	public boolean isInstantiable() {
		return true;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public String processChannel(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) throws InvalidChannelException {

		return StringPool.BLANK;
	}

	@Override
	public void updateChannel(String typeSettings, long channelInstanceId) {
	}

	protected String getExportImportErrorMessage(
		Tactic tactic, ChannelInstance channelInstance,
		String missingReferenceClassName, String missingReferenceId,
		String action) {

		StringBundler sb = new StringBundler(9);

		if (action.equals(Constants.EXPORT)) {
			sb.append("Cannot export channel ");
		}
		else {
			sb.append("Cannot import channel ");
		}

		sb.append(getName(LocaleUtil.getDefault()));
		sb.append(" from tactic ");
		sb.append(tactic.getName(LocaleUtil.getDefault()));
		sb.append(" because it refers to a missing ");
		sb.append(
			ResourceActionsUtil.getModelResource(
				LocaleUtil.getDefault(), missingReferenceClassName));
		sb.append(" with id ");
		sb.append(missingReferenceId);
		sb.append(".");

		return sb.toString();
	}

	protected void populateContext(
		ChannelInstance channelInstance, Map<String, Object> context,
		Map<String, String> values) {
	}

	private static final String _FORM_TEMPLATE_PATH =
		"templates/ct_channel.ftl";

	private static final Log _log = LogFactoryUtil.getLog(BaseChannel.class);

}