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

package com.liferay.content.targeting.lar;

import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.portal.kernel.lar.ExportImportPathUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.service.ServiceContext;

import javax.portlet.UnavailableException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 */
public class RuleInstanceStagedModelDataHandler
	extends BaseStagedModelDataHandler<RuleInstance> {

	public static final String[] CLASS_NAMES = {RuleInstance.class.getName()};

	public RuleInstanceStagedModelDataHandler() throws UnavailableException {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		_rulesRegistry = ServiceTrackerUtil.getService(
			RulesRegistry.class, bundle.getBundleContext());
	}

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException, SystemException {

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.fetchRuleInstanceByUuidAndGroupId(
				uuid, groupId);

		if (ruleInstance != null) {
			Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

			if (rule != null) {
				rule.deleteData(ruleInstance);
			}

			RuleInstanceLocalServiceUtil.deleteRuleInstance(ruleInstance);
		}
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext, RuleInstance ruleInstance)
		throws Exception {

		Element ruleInstanceElement = portletDataContext.getExportDataElement(
			ruleInstance);

		Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

		if (rule != null) {
			UserSegment userSegment =
				UserSegmentLocalServiceUtil.getUserSegment(
					ruleInstance.getUserSegmentId());

			Element userSegmentElement =
				portletDataContext.getExportDataElement(userSegment);

			rule.exportData(
				portletDataContext, userSegmentElement, userSegment,
				ruleInstanceElement, ruleInstance);
		}

		portletDataContext.addClassedModel(
			ruleInstanceElement,
			ExportImportPathUtil.getModelPath(ruleInstance), ruleInstance);
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext, RuleInstance ruleInstance)
		throws Exception {

		Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

		if (rule != null) {
			UserSegment userSegment =
				UserSegmentLocalServiceUtil.getUserSegment(
					ruleInstance.getUserSegmentId());

			rule.importData(portletDataContext, userSegment, ruleInstance);
		}

		long userId = portletDataContext.getUserId(ruleInstance.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			ruleInstance);

		serviceContext.setUuid(ruleInstance.getUuid());

		RuleInstance importedRuleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				userId, ruleInstance.getRuleKey(),
				ruleInstance.getUserSegmentId(), ruleInstance.getTypeSettings(),
				serviceContext);

		portletDataContext.importClassedModel(
			ruleInstance, importedRuleInstance);
	}

	@Override
	protected boolean validateMissingReference(
			String uuid, long companyId, long groupId)
		throws Exception {

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.fetchRuleInstanceByUuidAndGroupId(
				uuid, groupId);

		if (ruleInstance == null) {
			return false;
		}

		return true;
	}

	private RulesRegistry _rulesRegistry;

}