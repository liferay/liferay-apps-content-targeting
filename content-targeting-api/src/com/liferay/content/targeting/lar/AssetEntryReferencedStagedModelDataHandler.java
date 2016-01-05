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

import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.exportimport.lar.BaseStagedModelDataHandler;
import com.liferay.portlet.exportimport.lar.ExportImportPathUtil;
import com.liferay.portlet.exportimport.lar.PortletDataContext;
import com.liferay.portlet.exportimport.lar.PortletDataException;
import com.liferay.portlet.exportimport.lar.PortletDataHandler;
import com.liferay.portlet.exportimport.lar.StagedModelDataHandler;
import com.liferay.portlet.exportimport.lar.StagedModelDataHandlerUtil;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true,
	service = StagedModelDataHandler.class
)
public class AssetEntryReferencedStagedModelDataHandler
	extends BaseStagedModelDataHandler<AssetEntryReferencedStagedModel> {

	public static final String[] CLASS_NAMES = {
		AssetEntryReferencedStagedModel.class.getName()};

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException {
	}

	@Override
	public void deleteStagedModel(
			AssetEntryReferencedStagedModel assetEntryReferencedStagedModel)
		throws PortalException {
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
	public List<AssetEntryReferencedStagedModel>
		fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {

		throw new UnsupportedOperationException();
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

	protected void doImportStagedModel(
			PortletDataContext portletDataContext,
			AssetEntryReferencedStagedModel assetEntryReferencedStagedModel)
		throws Exception {

		if (assetEntryReferencedStagedModel != null) {
			doImportCompanyStagedModel(
				portletDataContext, assetEntryReferencedStagedModel.getUuid(),
				assetEntryReferencedStagedModel.getClassPK());
		}
	}

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
	public void importStagedModel(
			PortletDataContext portletDataContext,
			AssetEntryReferencedStagedModel assetEntryReferencedStagedModel)
		throws PortletDataException {

		try {
			Class clazz = getSupportedStagedModelClass(
				assetEntryReferencedStagedModel.getClassName());

			if (clazz != null) {
				StagedModelDataHandlerUtil.importReferenceStagedModels(
					portletDataContext, assetEntryReferencedStagedModel, clazz);
			} else {
				String stagedModelPath = ExportImportPathUtil.getModelPath(
					portletDataContext,
					assetEntryReferencedStagedModel.getClassName(),
					assetEntryReferencedStagedModel.getClassPK());

				StagedModel stagedModel =
					(StagedModel) portletDataContext.getZipEntryAsObject(
						stagedModelPath);

				StagedModelDataHandlerUtil.importStagedModel(
					portletDataContext, stagedModel);
			}
		}
		catch (Exception e) {
			throw new PortletDataException(e);
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
	protected boolean validateMissingReference(String uuid, long groupId) {

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
			groupId, uuid);

		if (assetEntry == null) {
			return false;
		}

		return true;
	}

}