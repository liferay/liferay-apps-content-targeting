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

package com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.impl;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CTActionFinderBaseImpl extends BasePersistenceImpl<CTAction> {
	@Override
	public Set<String> getBadColumnNames() {
		return getCTActionPersistence().getBadColumnNames();
	}

	/**
	 * Returns the c t action persistence.
	 *
	 * @return the c t action persistence
	 */
	public CTActionPersistence getCTActionPersistence() {
		return ctActionPersistence;
	}

	/**
	 * Sets the c t action persistence.
	 *
	 * @param ctActionPersistence the c t action persistence
	 */
	public void setCTActionPersistence(CTActionPersistence ctActionPersistence) {
		this.ctActionPersistence = ctActionPersistence;
	}

	@BeanReference(type = CTActionPersistence.class)
	protected CTActionPersistence ctActionPersistence;
}