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

package com.liferay.content.targeting.report.campaign.mobile.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the CampaignMobile service. Represents a row in the &quot;CT_CMR_CampaignMobile&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignMobileModel
 * @see com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileImpl
 * @see com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl
 * @generated
 */
public interface CampaignMobile extends CampaignMobileModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getTitle(java.util.Locale locale);

	public java.lang.String getType(java.util.Locale locale);

	public java.lang.String getConsumerName(java.util.Locale locale);

	public java.lang.String getPlaceholderName(java.util.Locale locale);

	public java.lang.String getUserSegmentName(java.util.Locale locale);
}