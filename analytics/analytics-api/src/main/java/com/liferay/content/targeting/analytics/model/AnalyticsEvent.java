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

package com.liferay.content.targeting.analytics.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AnalyticsEvent service. Represents a row in the &quot;CT_Analytics_AnalyticsEvent&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventModel
 * @see com.liferay.content.targeting.analytics.model.impl.AnalyticsEventImpl
 * @see com.liferay.content.targeting.analytics.model.impl.AnalyticsEventModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.analytics.model.impl.AnalyticsEventImpl")
@ProviderType
public interface AnalyticsEvent extends AnalyticsEventModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsEventImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnalyticsEvent, Long> ANALYTICS_EVENT_ID_ACCESSOR =
		new Accessor<AnalyticsEvent, Long>() {
			@Override
			public Long get(AnalyticsEvent analyticsEvent) {
				return analyticsEvent.getAnalyticsEventId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnalyticsEvent> getTypeClass() {
				return AnalyticsEvent.class;
			}
		};
}