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

package com.liferay.contenttargeting.service.persistence;

import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.service.RuleInstanceLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class RuleInstanceActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public RuleInstanceActionableDynamicQuery() throws SystemException {
		setBaseLocalService(RuleInstanceLocalServiceUtil.getService());
		setClass(RuleInstance.class);

		setClassLoader(com.liferay.contenttargeting.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("ruleInstanceId");
	}
}