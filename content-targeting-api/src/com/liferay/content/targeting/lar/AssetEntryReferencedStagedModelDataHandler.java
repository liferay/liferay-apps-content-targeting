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
import com.liferay.portal.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

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
			AssetEntryReferencedStagedModel stagedModel)
		throws Exception {
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext,
			AssetEntryReferencedStagedModel stagedModel)
		throws Exception {
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