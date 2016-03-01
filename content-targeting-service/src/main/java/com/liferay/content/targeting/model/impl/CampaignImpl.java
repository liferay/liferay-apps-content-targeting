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

import com.liferay.content.targeting.util.CampaignConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.Locale;

/**
 * The extended model implementation for the Campaign service. Represents a row in the &quot;CT_Campaign&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.model.Campaign} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class CampaignImpl extends CampaignBaseImpl {

	public CampaignImpl() {
	}

	public String getNameWithGroupName(Locale locale, long groupId) {
		String name = getName(locale);

		if (groupId != getGroupId()) {
			try {
				Group group = GroupLocalServiceUtil.getGroup(getGroupId());

				StringBundler sb = new StringBundler(5);

				sb.append(name);
				sb.append(StringPool.SPACE);
				sb.append(StringPool.OPEN_PARENTHESIS);
				sb.append(group.getDescriptiveName(locale));
				sb.append(StringPool.CLOSE_PARENTHESIS);

				name = sb.toString();
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Group can not be found for groupId " + getGroupId());
				}
			}
		}

		return name;
	}

	@Override
	public String getStatus() {
		if (!isActive()) {
			return CampaignConstants.STATUS_INACTIVE;
		}

		Date now = new Date();

		if (getStartDate().getTime() > now.getTime()) {
			return CampaignConstants.STATUS_UPCOMING;
		}
		else if (getEndDate().getTime() < now.getTime()) {
			return CampaignConstants.STATUS_FINISHED;
		}

		return CampaignConstants.STATUS_STARTED;
	}

	private static final Log _log = LogFactoryUtil.getLog(CampaignImpl.class);

}