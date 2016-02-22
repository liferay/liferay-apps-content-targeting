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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the CTActionTotal service. Represents a row in the &quot;CT_CTA_CTActionTotal&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalModel
 * @see com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalImpl")
@ProviderType
public interface CTActionTotal extends CTActionTotalModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CTActionTotal, Long> C_T_ACTION_TOTAL_ID_ACCESSOR =
		new Accessor<CTActionTotal, Long>() {
			@Override
			public Long get(CTActionTotal ctActionTotal) {
				return ctActionTotal.getCTActionTotalId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CTActionTotal> getTypeClass() {
				return CTActionTotal.class;
			}
		};

	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getViewsByUserSegment()
		throws com.liferay.portal.kernel.exception.PortalException;
}