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

package com.liferay.content.targeting.report.campaign.mobile.model.impl;

import com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData;
import com.liferay.content.targeting.report.campaign.mobile.service.ConsumerDataLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ConsumerData service. Represents a row in the &quot;CT_CMR_ConsumerData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ConsumerDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerDataImpl
 * @see com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData
 * @generated
 */
public abstract class ConsumerDataBaseImpl extends ConsumerDataModelImpl
	implements ConsumerData {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a consumer data model instance should use the {@link ConsumerData} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ConsumerDataLocalServiceUtil.addConsumerData(this);
		}
		else {
			ConsumerDataLocalServiceUtil.updateConsumerData(this);
		}
	}
}