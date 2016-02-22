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
 * The extended model interface for the CTAction service. Represents a row in the &quot;CT_CTA_CTAction&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CTActionModel
 * @see com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionImpl")
@ProviderType
public interface CTAction extends CTActionModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CTAction, Long> C_T_ACTION_ID_ACCESSOR = new Accessor<CTAction, Long>() {
			@Override
			public Long get(CTAction ctAction) {
				return ctAction.getCTActionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CTAction> getTypeClass() {
				return CTAction.class;
			}
		};

	public java.lang.String getUserSegmentName(java.util.Locale locale);
}