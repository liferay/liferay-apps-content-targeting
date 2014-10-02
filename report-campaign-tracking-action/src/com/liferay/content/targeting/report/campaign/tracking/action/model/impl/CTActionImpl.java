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

package com.liferay.content.targeting.report.campaign.tracking.action.model.impl;

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The extended model implementation for the CTAction service. Represents a row in the &quot;CTActionsReport_CTAction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class CTActionImpl extends CTActionBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a campaign tracking action model instance should use the {@link com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction} interface instead.
	 */
	public CTActionImpl() {
	}

	@Override
	public String getUserSegmentName(Locale locale) {
		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			UserSegmentLocalService userSegmentLocalService =
				ServiceTrackerUtil.getService(
					UserSegmentLocalService.class, bundle.getBundleContext());

			UserSegment userSegment = userSegmentLocalService.getUserSegment(
				getUserSegmentId());

			return userSegment.getName(locale);
		}
		catch (Exception e) {
			return StringPool.BLANK;
		}
	}

}