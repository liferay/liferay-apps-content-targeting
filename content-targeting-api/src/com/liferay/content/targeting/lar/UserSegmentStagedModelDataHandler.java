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

import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.portal.kernel.lar.ExportImportPathUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * @author Eduardo Garcia
 */
public class UserSegmentStagedModelDataHandler
	extends BaseStagedModelDataHandler<UserSegment> {

	public static final String[] CLASS_NAMES = {UserSegment.class.getName()};

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException, SystemException {

		UserSegment userSegment =
			UserSegmentLocalServiceUtil.fetchUserSegmentByUuidAndGroupId(
				uuid, groupId);

		if (userSegment != null) {
			UserSegmentLocalServiceUtil.deleteUserSegment(userSegment);
		}
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getDisplayName(UserSegment userSegment) {
		return userSegment.getName();
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext, UserSegment userSegment)
		throws Exception {

		Element userSegmentElement = portletDataContext.getExportDataElement(
			userSegment);

		portletDataContext.addClassedModel(
			userSegmentElement, ExportImportPathUtil.getModelPath(userSegment),
			userSegment);

		exportRuleInstances(portletDataContext, userSegment);
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext, UserSegment userSegment)
		throws Exception {

		long userId = portletDataContext.getUserId(userSegment.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			userSegment);

		serviceContext.setUserId(userId);

		UserSegment importedUserSegment = null;

		if (portletDataContext.isDataStrategyMirror()) {
			UserSegment existingUserSegment =
				UserSegmentLocalServiceUtil.fetchUserSegmentByUuidAndGroupId(
					userSegment.getUuid(),
					portletDataContext.getScopeGroupId());

			if (existingUserSegment == null) {
				serviceContext.setUuid(userSegment.getUuid());

				importedUserSegment =
					UserSegmentLocalServiceUtil.addUserSegment(
						userId, userSegment.getNameMap(),
						userSegment.getDescriptionMap(), serviceContext);
			}
			else {
				importedUserSegment =
					UserSegmentLocalServiceUtil.updateUserSegment(
						existingUserSegment.getUserSegmentId(),
						userSegment.getNameMap(),
						userSegment.getDescriptionMap(), serviceContext);
			}
		}
		else {
			importedUserSegment = UserSegmentLocalServiceUtil.addUserSegment(
				userId, userSegment.getNameMap(),
				userSegment.getDescriptionMap(), serviceContext);
		}

		importRuleInstances(
				portletDataContext, userSegment, importedUserSegment);

		portletDataContext.importClassedModel(userSegment, importedUserSegment);
	}

	protected void exportRuleInstances(
			PortletDataContext portletDataContext, UserSegment userSegment)
		throws Exception {

		List<RuleInstance> ruleInstances =
			RuleInstanceLocalServiceUtil.getRuleInstances(
				userSegment.getUserSegmentId());

		for (RuleInstance ruleInstance : ruleInstances) {
			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, userSegment, ruleInstance,
				PortletDataContext.REFERENCE_TYPE_EMBEDDED);
		}
	}

	protected void importRuleInstances(
			PortletDataContext portletDataContext, UserSegment userSegment,
			UserSegment importedUserSegment)
		throws Exception {

		List<Element> ruleInstanceElements =
			portletDataContext.getReferenceDataElements(
				userSegment, RuleInstance.class);

		for (Element ruleInstanceElement : ruleInstanceElements) {
			String ruleInstancePath = ruleInstanceElement.attributeValue(
				"path");

			RuleInstance ruleInstance =
				(RuleInstance)portletDataContext.getZipEntryAsObject(
					ruleInstancePath);

			ruleInstance.setUserSegmentId(
				importedUserSegment.getUserSegmentId());

			StagedModelDataHandlerUtil.importStagedModel(
				portletDataContext, ruleInstance);
		}
	}

	@Override
	protected boolean validateMissingReference(
			String uuid, long companyId, long groupId)
		throws Exception {

		UserSegment userSegment =
			UserSegmentLocalServiceUtil.fetchUserSegmentByUuidAndGroupId(
				uuid, groupId);

		if (userSegment == null) {
			return false;
		}

		return true;
	}

}