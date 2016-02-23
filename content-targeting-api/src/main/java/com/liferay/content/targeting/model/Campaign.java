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

package com.liferay.content.targeting.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Campaign service. Represents a row in the &quot;CT_Campaign&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignModel
 * @see com.liferay.content.targeting.model.impl.CampaignImpl
 * @see com.liferay.content.targeting.model.impl.CampaignModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.model.impl.CampaignImpl")
@ProviderType
public interface Campaign extends CampaignModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.model.impl.CampaignImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Campaign, Long> CAMPAIGN_ID_ACCESSOR = new Accessor<Campaign, Long>() {
			@Override
			public Long get(Campaign campaign) {
				return campaign.getCampaignId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Campaign> getTypeClass() {
				return Campaign.class;
			}
		};

	public java.lang.String getNameWithGroupName(java.util.Locale locale,
		long groupId);

	public java.lang.String getStatus();
}