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
 * The extended model interface for the ConsumerData service. Represents a row in the &quot;CT_CMR_ConsumerData&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerDataModel
 * @see com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataImpl
 * @see com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl
 * @generated
 */
public interface ConsumerData extends ConsumerDataModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getConsumerName(java.util.Locale locale);
}