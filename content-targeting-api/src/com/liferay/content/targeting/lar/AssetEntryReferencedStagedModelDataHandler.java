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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.portal.kernel.lar.ExportImportPathUtil;
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import java.util.Map;

/**
 * @author Eduardo Garcia
 */
public class AssetEntryReferencedStagedModelDataHandler
	extends BaseStagedModelDataHandler<AssetEntryReferencedStagedModel> {

	public static final String[] CLASS_NAMES = {
		AssetEntryReferencedStagedModel.class.getName()};

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException, SystemException {
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getDisplayName(
		AssetEntryReferencedStagedModel assetEntryReferencedStagedModel) {

		String title = assetEntryReferencedStagedModel.getTitle();

		String type = ResourceActionsUtil.getModelResource(
			LocaleUtil.getDefault(),
			assetEntryReferencedStagedModel.getClassName());

		return title + " - " + type;
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext,
			AssetEntryReferencedStagedModel assetEntryReferencedStagedModel)
		throws Exception {

		StagedModel supportedStagedModel = getSupportedStagedModel(
			assetEntryReferencedStagedModel.getClassName(),
			assetEntryReferencedStagedModel.getClassPK());

		if (supportedStagedModel != null) {
			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, assetEntryReferencedStagedModel,
				AssetEntryReferencedStagedModel.class, supportedStagedModel,
				getSupportedStagedModelClass(
					assetEntryReferencedStagedModel.getClassName()),
				PortletDataContext.REFERENCE_TYPE_DEPENDENCY);

			Element assetEntryReferencedStagedModelElement =
				portletDataContext.getExportDataElement(
					assetEntryReferencedStagedModel);

			portletDataContext.addClassedModel(
				assetEntryReferencedStagedModelElement,
				ExportImportPathUtil.getModelPath(
					assetEntryReferencedStagedModel),
				assetEntryReferencedStagedModel);

			return;
		}

		throw new UnsupportedOperationException();
	}

	@Override
	protected void doImportCompanyStagedModel(
			PortletDataContext portletDataContext, String uuid, long classPK)
		throws Exception {

		AssetEntry existingAssetEntry =
			AssetEntryLocalServiceUtil.fetchEntry(
				uuid, portletDataContext.getCompanyGroupId());

		if (existingAssetEntry == null) {
			return;
		}

		Map<Long, Long> assetEntryReferencedStagedModelIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				AssetEntryReferencedStagedModel.class);

		assetEntryReferencedStagedModelIds.put(
			classPK, existingAssetEntry.getClassPK());
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext,
			AssetEntryReferencedStagedModel assetEntryReferencedStagedModel)
		throws Exception {

		Class clazz = getSupportedStagedModelClass(
			assetEntryReferencedStagedModel.getClassName());

		if (clazz != null) {
			StagedModelDataHandlerUtil.importReferenceStagedModels(
				portletDataContext, assetEntryReferencedStagedModel, clazz);
		}
		else {
			String stagedModelPath = ExportImportPathUtil.getModelPath(
				portletDataContext,
				assetEntryReferencedStagedModel.getClassName(),
				assetEntryReferencedStagedModel.getClassPK());

			StagedModel stagedModel =
				(StagedModel)portletDataContext.getZipEntryAsObject(
					stagedModelPath);

			StagedModelDataHandlerUtil.importStagedModel(
				portletDataContext, stagedModel);
		}
	}

	protected StagedModel getSupportedStagedModel(
			String className, long classPK)
		throws PortalException, SystemException {

		if (className.equals(JournalArticle.class.getName())) {
			return JournalArticleLocalServiceUtil.fetchLatestIndexableArticle(
				classPK);
		}
		else if (className.equals(DLFileEntry.class.getName())) {
			return DLAppLocalServiceUtil.getFileEntry(classPK);
		}

		return null;
	}

	protected Class getSupportedStagedModelClass(String className)
		throws PortalException, SystemException {

		if (className.equals(JournalArticle.class.getName())) {
			return JournalArticle.class;
		}
		else if (className.equals(DLFileEntry.class.getName())) {
			return FileEntry.class;
		}

		return null;
	}

	@Override
	protected boolean validateMissingReference(
			String uuid, long companyId, long groupId)
		throws Exception {

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
			groupId, uuid);

		if (assetEntry == null) {
			return false;
		}

		return true;
	}

}