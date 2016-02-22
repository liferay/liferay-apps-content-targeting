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

package com.liferay.content.targeting.hook.upgrade.v1_0_0;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.util.List;

/**
 * @author Eduardo Garcia
 */
public class UpgradeAsset extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		List<Group> groups = GroupLocalServiceUtil.getGroups(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (Group group : groups) {
			upgradeUserSegmentAssetVocabularyPermissions(group.getGroupId());
		}
	}

	protected void upgradeUserSegmentAssetVocabularyPermissions(long groupId)
		throws Exception {

		// Cannot search by vocabulary name because bundle language resources
		// may not be available at this point

		List<UserSegment> userSegments =
			UserSegmentLocalServiceUtil.getUserSegments(groupId, 0, 1, null);

		if (userSegments.isEmpty()) {
			return;
		}

		UserSegment userSegment = userSegments.get(0);

		AssetCategory assetCategory =
			AssetCategoryLocalServiceUtil.getAssetCategory(
				userSegment.getAssetCategoryId());

		AssetVocabulary assetVocabulary =
			AssetVocabularyLocalServiceUtil.getAssetVocabulary(
				assetCategory.getVocabularyId());

		AssetVocabularyLocalServiceUtil.addVocabularyResources(
			assetVocabulary, true, true);
	}

}