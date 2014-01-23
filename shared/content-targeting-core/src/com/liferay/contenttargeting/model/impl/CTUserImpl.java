/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.model.impl;

import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * The extended model implementation for the CTUser service. Represents a row in the &quot;CT_CTUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.model.CTUser} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class CTUserImpl extends CTUserBaseImpl {

	public CTUserImpl() {
	}

	public long[] getMatchesUserSegmentIds(
			long[] groupIds, RulesRegistry rulesRegistry)
		throws PortalException, SystemException {

		if (ArrayUtil.isEmpty(groupIds)) {
			return null;
		}

		List<Long> userSegmentIds = new ArrayList<Long>();

		List<UserSegment> userSegments =
			UserSegmentLocalServiceUtil.getUserSegments(groupIds);

		for (UserSegment userSegment : userSegments) {
			if (userSegment.matches(this, rulesRegistry)) {
				userSegmentIds.add(userSegment.getUserSegmentId());
			}
		}

		return ArrayUtil.toLongArray(userSegmentIds);
	}

}