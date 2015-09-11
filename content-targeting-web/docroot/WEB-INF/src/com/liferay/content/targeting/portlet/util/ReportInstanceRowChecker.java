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

package com.liferay.content.targeting.portlet.util;

import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public class ReportInstanceRowChecker extends RowChecker {

	public ReportInstanceRowChecker(
		PortletRequest request, PortletResponse response) {

		super(response);
	}

	@Override
	public String getRowCheckBox(
		HttpServletRequest request, boolean checked, boolean disabled,
		String primaryKey) {

		if (disabled) {
			return StringPool.BLANK;
		}

		return super.getRowCheckBox(request, checked, disabled, primaryKey);
	}

	@Override
	public boolean isDisabled(Object obj) {
		if (obj instanceof ReportInstance) {
			ReportInstance reportInstance = (ReportInstance)obj;

			return !reportInstance.isInstantiable();
		}

		return super.isDisabled(obj);
	}

}