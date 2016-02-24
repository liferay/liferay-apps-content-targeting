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

package com.liferay.content.targeting.model.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.util.List;
import java.util.Locale;

/**
 * The extended model implementation for the UserSegment service. Represents a row in the &quot;CT_UserSegment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.model.UserSegment} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class UserSegmentImpl extends UserSegmentBaseImpl {

	public UserSegmentImpl() {
	}

	public long getAssetCategoryId(long groupId) {
		long assetCategoryId = getAssetCategoryId();

		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);

			if (group.isStagingGroup()) {
				AssetCategory liveAssetCategory =
					AssetCategoryLocalServiceUtil.getAssetCategory(
						assetCategoryId);

				AssetCategory stagingAssetCategory =
					AssetCategoryLocalServiceUtil.
						getAssetCategoryByUuidAndGroupId(
							liveAssetCategory.getUuid(), group.getGroupId());

				assetCategoryId = stagingAssetCategory.getCategoryId();
			}
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Category can not be found for groupId " + groupId);
			}
		}

		return assetCategoryId;
	}

	public String getNameWithGroupName(Locale locale, long groupId) {
		String name = getName(locale);

		try {
			Group group = GroupLocalServiceUtil.getGroup(getGroupId());

			if ((groupId != getGroupId()) &&
				(!group.hasStagingGroup() ||
				 (group.getStagingGroup().getGroupId() != groupId))) {

				StringBundler sb = new StringBundler(5);

				sb.append(name);
				sb.append(StringPool.SPACE);
				sb.append(StringPool.OPEN_PARENTHESIS);
				sb.append(group.getDescriptiveName(locale));
				sb.append(StringPool.CLOSE_PARENTHESIS);

				name = sb.toString();
			}
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Group can not be found for groupId " + getGroupId());
			}
		}

		return name;
	}

	public List<RuleInstance> getRuleInstances() {
		return RuleInstanceLocalServiceUtil.getRuleInstances(
			getUserSegmentId());
	}

	public boolean isRuleEnabled(Rule rule) throws Exception {
		if (rule.isInstantiable()) {
			return true;
		}

		if (RuleInstanceLocalServiceUtil.getRuleInstancesCount(
				rule.getRuleKey(), getUserSegmentId()) > 0) {

			return false;
		}

		return true;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserSegmentImpl.class);

}