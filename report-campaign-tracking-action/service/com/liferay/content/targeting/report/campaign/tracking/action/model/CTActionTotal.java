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

package com.liferay.content.targeting.report.campaign.tracking.action.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the CTActionTotal service. Represents a row in the &quot;CT_CTA_CTActionTotal&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalModel
 * @see com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl
 * @generated
 */
public interface CTActionTotal extends CTActionTotalModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getViewsByUserSegment()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}