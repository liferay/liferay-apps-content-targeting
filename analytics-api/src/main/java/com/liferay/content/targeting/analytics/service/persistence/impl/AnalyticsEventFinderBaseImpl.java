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

package com.liferay.content.targeting.analytics.service.persistence.impl;

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsEventPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AnalyticsEventFinderBaseImpl extends BasePersistenceImpl<AnalyticsEvent> {
	/**
	 * Returns the analytics event persistence.
	 *
	 * @return the analytics event persistence
	 */
	public AnalyticsEventPersistence getAnalyticsEventPersistence() {
		return analyticsEventPersistence;
	}

	/**
	 * Sets the analytics event persistence.
	 *
	 * @param analyticsEventPersistence the analytics event persistence
	 */
	public void setAnalyticsEventPersistence(
		AnalyticsEventPersistence analyticsEventPersistence) {
		this.analyticsEventPersistence = analyticsEventPersistence;
	}

	@BeanReference(type = AnalyticsEventPersistence.class)
	protected AnalyticsEventPersistence analyticsEventPersistence;
}