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

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetCategoryConstants;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.asset.kernel.service.persistence.AssetVocabularyUtil;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.xml.Element;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, service = StagedModelDataHandler.class)
public class UserSegmentStagedModelDataHandler
	extends BaseStagedModelDataHandler<UserSegment> {

	public static final String[] CLASS_NAMES = {UserSegment.class.getName()};

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException {

		UserSegment userSegment =
			_userSegmentLocalService.fetchUserSegmentByUuidAndGroupId(
				uuid, groupId);

		if (userSegment != null) {
			_userSegmentLocalService.deleteUserSegment(userSegment);
		}
	}

	@Override
	public void deleteStagedModel(UserSegment stagedUserSegment)
		throws PortalException {

		_userSegmentLocalService.deleteUserSegment(stagedUserSegment);
	}

	@Override
	public List<UserSegment>
		fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {

		throw new UnsupportedOperationException();
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getDisplayName(UserSegment userSegment) {
		return userSegment.getName(LocaleUtil.getDefault());
	}

	@Override
	public void importCompanyStagedModel(
			PortletDataContext portletDataContext, String uuid,
			long userSegmentId)
		throws PortletDataException {

		UserSegment existingUserSegment =
			_userSegmentLocalService.fetchUserSegmentByUuidAndGroupId(
				uuid, portletDataContext.getScopeGroupId());

		if (existingUserSegment == null) {
			existingUserSegment =
				_userSegmentLocalService.fetchUserSegmentByUuidAndGroupId(
					uuid, portletDataContext.getCompanyGroupId());
		}

		Map<Long, Long> userSegmentIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				UserSegment.class);

		userSegmentIds.put(
			userSegmentId, existingUserSegment.getUserSegmentId());
	}

	@Override
	public void importStagedModel(
			PortletDataContext portletDataContext, UserSegment userSegment)
		throws PortletDataException {

		try {
			Element userSegmentElement =
				portletDataContext.getImportDataElement(userSegment);

			AssetCategory importedAssetCategory = importAssetCategory(
				portletDataContext, userSegmentElement);

			long userId = portletDataContext.getUserId(
				userSegment.getUserUuid());

			ServiceContext serviceContext =
				portletDataContext.createServiceContext(userSegment);

			if (importedAssetCategory != null) {
				serviceContext.setAttribute(
					"userSegmentAssetCategoryId",
					importedAssetCategory.getCategoryId());
			}

			serviceContext.setUserId(userId);

			UserSegment importedUserSegment = null;

			if (portletDataContext.isDataStrategyMirror()) {
				UserSegment existingUserSegment =
					_userSegmentLocalService.fetchUserSegmentByUuidAndGroupId(
						userSegment.getUuid(),
						portletDataContext.getScopeGroupId());

				if (existingUserSegment == null) {
					serviceContext.setUuid(userSegment.getUuid());

					importedUserSegment =
						_userSegmentLocalService.addUserSegment(
							userId, userSegment.getNameMap(),
							userSegment.getDescriptionMap(), serviceContext);
				}
				else {
					importedUserSegment =
						_userSegmentLocalService.updateUserSegment(
							existingUserSegment.getUserSegmentId(),
							userSegment.getNameMap(),
							userSegment.getDescriptionMap(), serviceContext);
				}
			}
			else {
				importedUserSegment = _userSegmentLocalService.addUserSegment(
					userId, userSegment.getNameMap(),
					userSegment.getDescriptionMap(), serviceContext);
			}

			importRuleInstances(
				portletDataContext, userSegment, importedUserSegment);

			portletDataContext.importClassedModel(
				userSegment, importedUserSegment);
		}
		catch (Exception e) {
			throw new PortletDataException(e);
		}
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext, UserSegment userSegment)
		throws Exception {

		Element userSegmentElement = portletDataContext.getExportDataElement(
			userSegment);

		exportAssetCategory(
			portletDataContext, userSegmentElement, userSegment);

		exportRuleInstances(portletDataContext, userSegment);

		portletDataContext.addClassedModel(
			userSegmentElement, ExportImportPathUtil.getModelPath(userSegment),
			userSegment);
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext, UserSegment userSegment)
		throws Exception {

		importStagedModel(portletDataContext, userSegment);
	}

	protected void exportAssetCategory(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment)
		throws Exception {

		AssetCategory assetCategory =
			_assetCategoryLocalService.getAssetCategory(
				userSegment.getAssetCategoryId());

		exportAssetVocabulary(
			portletDataContext, userSegmentElement, assetCategory);

		String path = getAssetCategoryPath(
			portletDataContext, assetCategory.getCategoryId());

		Element assetCategoryElement = userSegmentElement.addElement(
			"category");

		assetCategoryElement.addAttribute("path", path);

		assetCategory.setUserUuid(assetCategory.getUserUuid());

		portletDataContext.addZipEntry(path, assetCategory);

		portletDataContext.addPermissions(
			AssetCategory.class, assetCategory.getCategoryId());
	}

	protected void exportAssetVocabulary(
			PortletDataContext portletDataContext, Element userSegmentElement,
			AssetCategory assetCategory)
		throws Exception {

		AssetVocabulary assetVocabulary = AssetVocabularyUtil.findByPrimaryKey(
			assetCategory.getVocabularyId());

		String path = getAssetVocabulariesPath(
			portletDataContext, assetVocabulary.getVocabularyId());

		Element assetVocabularyElement = userSegmentElement.addElement(
			"vocabulary");

		assetVocabularyElement.addAttribute("path", path);

		assetVocabulary.setUserUuid(assetVocabulary.getUserUuid());

		portletDataContext.addZipEntry(path, assetVocabulary);

		portletDataContext.addPermissions(
			AssetVocabulary.class, assetVocabulary.getVocabularyId());
	}

	protected void exportRuleInstances(
			PortletDataContext portletDataContext, UserSegment userSegment)
		throws Exception {

		List<RuleInstance> ruleInstances =
			_ruleInstanceLocalService.getRuleInstances(
				userSegment.getUserSegmentId());

		for (RuleInstance ruleInstance : ruleInstances) {
			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, userSegment, ruleInstance,
				PortletDataContext.REFERENCE_TYPE_EMBEDDED);
		}
	}

	protected String getAssetCategoryPath(
		PortletDataContext portletDataContext, long assetCategoryId) {

		StringBundler sb = new StringBundler(4);

		sb.append(ExportImportPathUtil.getRootPath(portletDataContext));
		sb.append("/categories/");
		sb.append(assetCategoryId);
		sb.append(".xml");

		return sb.toString();
	}

	protected String getAssetVocabulariesPath(
		PortletDataContext portletDataContext, long assetVocabularyId) {

		StringBundler sb = new StringBundler(4);

		sb.append(ExportImportPathUtil.getRootPath(portletDataContext));
		sb.append("/vocabularies/");
		sb.append(assetVocabularyId);
		sb.append(".xml");

		return sb.toString();
	}

	protected AssetCategory importAssetCategory(
			PortletDataContext portletDataContext, Element userSegmentElement)
		throws Exception {

		Element assetCategoryElement = userSegmentElement.element("category");

		String path = assetCategoryElement.attributeValue("path");

		AssetCategory assetCategory =
			(AssetCategory)portletDataContext.getZipEntryAsObject(path);

		AssetVocabulary assetVocabulary = importAssetVocabulary(
			portletDataContext, userSegmentElement);

		long userId = portletDataContext.getUserId(assetCategory.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			assetCategory);

		serviceContext.setUserId(userId);

		AssetCategory importedAssetCategory = null;

		if (portletDataContext.isDataStrategyMirror()) {
			AssetCategory existingAssetCategory =
				_assetCategoryLocalService.fetchAssetCategoryByUuidAndGroupId(
					assetCategory.getUuid(),
					portletDataContext.getScopeGroupId());

			if (existingAssetCategory == null) {
				serviceContext.setUuid(assetCategory.getUuid());

				importedAssetCategory = _assetCategoryLocalService.addCategory(
					userId, portletDataContext.getGroupId(),
					AssetCategoryConstants.DEFAULT_PARENT_CATEGORY_ID,
					assetCategory.getTitleMap(),
					assetCategory.getDescriptionMap(),
					assetVocabulary.getVocabularyId(), null, serviceContext);
			}
			else {
				importedAssetCategory =
					_assetCategoryLocalService.updateCategory(
						userId, existingAssetCategory.getCategoryId(),
						existingAssetCategory.getParentCategoryId(),
						assetCategory.getTitleMap(),
						assetCategory.getDescriptionMap(),
						existingAssetCategory.getVocabularyId(), null,
						serviceContext);
			}
		}
		else {
			importedAssetCategory = _assetCategoryLocalService.addCategory(
				userId, portletDataContext.getGroupId(),
				AssetCategoryConstants.DEFAULT_PARENT_CATEGORY_ID,
				assetCategory.getTitleMap(), assetCategory.getDescriptionMap(),
				assetVocabulary.getVocabularyId(), null, serviceContext);
		}

		portletDataContext.importClassedModel(
			assetCategory, importedAssetCategory);

		return importedAssetCategory;
	}

	protected AssetVocabulary importAssetVocabulary(
			PortletDataContext portletDataContext, Element userSegmentElement)
		throws Exception {

		Element assetVocabularyElement = userSegmentElement.element(
			"vocabulary");

		String path = assetVocabularyElement.attributeValue("path");

		AssetVocabulary assetVocabulary =
			(AssetVocabulary)portletDataContext.getZipEntryAsObject(path);

		long userId = portletDataContext.getUserId(
			assetVocabulary.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			assetVocabulary);

		serviceContext.setUserId(userId);

		AssetVocabulary importedAssetVocabulary = null;

		if (portletDataContext.isDataStrategyMirror()) {
			AssetVocabulary existingAssetVocabulary =
				_assetVocabularyLocalService.
					fetchAssetVocabularyByUuidAndGroupId(
						assetVocabulary.getUuid(),
						portletDataContext.getScopeGroupId());

			if (existingAssetVocabulary == null) {
				serviceContext.setUuid(assetVocabulary.getUuid());

				importedAssetVocabulary = UserSegmentUtil.addAssetVocabulary(
					userId, serviceContext);
			}
			else {
				importedAssetVocabulary = existingAssetVocabulary;
			}
		}
		else {
			importedAssetVocabulary = UserSegmentUtil.addAssetVocabulary(
				userId, serviceContext);
		}

		portletDataContext.importClassedModel(
			assetVocabulary, importedAssetVocabulary);

		return importedAssetVocabulary;
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

	@Reference(unbind = "-")
	protected void setAssetCategoryLocalService(
		AssetCategoryLocalService assetCategoryLocalService) {

		_assetCategoryLocalService = assetCategoryLocalService;
	}

	@Reference(unbind = "-")
	protected void setAssetVocabularyLocalService(
		AssetVocabularyLocalService assetVocabularyLocalService) {

		_assetVocabularyLocalService = assetVocabularyLocalService;
	}

	@Reference(unbind = "-")
	protected void setRuleInstanceLocalService(
		RuleInstanceLocalService ruleInstanceLocalService) {

		_ruleInstanceLocalService = ruleInstanceLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	@Override
	protected boolean validateMissingReference(String uuid, long groupId) {
		UserSegment userSegment =
			_userSegmentLocalService.fetchUserSegmentByUuidAndGroupId(
				uuid, groupId);

		if (userSegment == null) {
			return false;
		}

		return true;
	}

	private AssetCategoryLocalService _assetCategoryLocalService;
	private AssetVocabularyLocalService _assetVocabularyLocalService;
	private RuleInstanceLocalService _ruleInstanceLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}