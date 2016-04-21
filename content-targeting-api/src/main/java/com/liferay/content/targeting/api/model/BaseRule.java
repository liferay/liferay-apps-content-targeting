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

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
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

/**
 * @author Eduardo Garcia
 */
public abstract class BaseRule implements Rule {

	@Override
	public void activate() {
		Class<?> clazz = getClass();

		if (_log.isDebugEnabled()) {
			_log.debug("Rule activate: " + clazz.getSimpleName());
		}
	}

	@Override
	public void deActivate() {
		Class<?> clazz = getClass();

		if (_log.isDebugEnabled()) {
			_log.debug("Rule deactivate: " + clazz.getSimpleName());
		}
	}

	@Override
	public void deleteData(RuleInstance ruleInstance) throws PortalException {
	}

	public boolean evaluate(
		Map<String, Object> context, RuleInstance ruleInstance,
		AnonymousUser anonymousUser) {

		throw new UnsupportedOperationException();
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment, Element ruleInstanceElement,
			RuleInstance ruleInstance)
		throws Exception {
	}

	public long getCacheTime() {
		return 0;
	}

	@Override
	public String getDescription(Locale locale) {
		return ContentTargetingUtil.getDescription(getClass(), locale);
	}

	@Override
	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		String content = StringPool.BLANK;

		try {
			populateContext(ruleInstance, context, values);

			content = ContentTargetingContextUtil.parseTemplate(
				getClass(), getFormTemplatePath(), context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing rule form template " +
					getFormTemplatePath(),
				e);
		}

		return content;
	}

	@Override
	public String getIcon() {
		return "icon-retweet";
	}

	@Override
	public String getName(Locale locale) {
		return ContentTargetingUtil.getName(getClass(), locale);
	}

	@Override
	public String getRuleCategoryKey() {
		return StringPool.BLANK;
	}

	@Override
	public String getRuleKey() {
		Class<?> clazz = getClass();

		return clazz.getSimpleName();
	}

	@Override
	public String getShortDescription(Locale locale) {
		return ContentTargetingUtil.getShortDescription(getClass(), locale);
	}

	@Override
	public void importData(
			PortletDataContext portletDataContext, UserSegment userSegment,
			RuleInstance ruleInstance)
		throws Exception {
	}

	@Override
	public boolean isInstantiable() {
		return false;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	public boolean supportsOfflineEvaluation() {
		return false;
	}

	protected String getExportImportErrorMessage(
		UserSegment userSegment, RuleInstance ruleInstance,
		String missingReferenceClassName, String missingReferenceId,
		String action) {

		StringBundler sb = new StringBundler(9);

		if (action.equals(Constants.EXPORT)) {
			sb.append("Cannot export rule ");
		}
		else {
			sb.append("Cannot import rule ");
		}

		sb.append(getName(LocaleUtil.getDefault()));
		sb.append(" from user segment ");
		sb.append(userSegment.getName(LocaleUtil.getDefault()));
		sb.append(" because it refers to a missing ");
		sb.append(
			ResourceActionsUtil.getModelResource(
				LocaleUtil.getDefault(), missingReferenceClassName));
		sb.append(" with id ");
		sb.append(missingReferenceId);
		sb.append(".");

		return sb.toString();
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH;
	}

	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {
	}

	private static final String _FORM_TEMPLATE_PATH = "templates/ct_fields.ftl";

	private static final Log _log = LogFactoryUtil.getLog(BaseRule.class);

}