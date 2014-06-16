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

package com.liferay.contenttargeting.hook;

import com.liferay.contenttargeting.util.UserSegmentUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.asset.NoSuchVocabularyException;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.model.AssetVocabularyDisplay;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyService;
import com.liferay.portlet.asset.service.AssetVocabularyServiceWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class CTAssetVocabularyServiceImpl
		extends AssetVocabularyServiceWrapper {

	public CTAssetVocabularyServiceImpl(
		AssetVocabularyService assetVocabularyService) {

		super(assetVocabularyService);
	}

	@Override
	public AssetVocabularyDisplay getGroupVocabulariesDisplay(
			long groupId, String name, int start, int end,
			boolean addDefaultVocabulary, OrderByComparator obc)
		throws PortalException, SystemException {

		AssetVocabularyDisplay vocabularyDisplay =
			super.getGroupVocabulariesDisplay(
				groupId, name, start, end, addDefaultVocabulary, obc);

		List<AssetVocabulary> vocabularies =
			vocabularyDisplay.getVocabularies();

		AssetVocabulary vocabulary = null;

		try {
			vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(
				groupId, UserSegmentUtil.getAssetVocabularyName());
		}
		catch (NoSuchVocabularyException nsve) {
			return vocabularyDisplay;
		}

		List<AssetVocabulary> removes = new ArrayList<AssetVocabulary>();

		removes.add(vocabulary);

		vocabularyDisplay.setVocabularies(
			ListUtil.remove(vocabularies, removes));

		return vocabularyDisplay;
	}

}