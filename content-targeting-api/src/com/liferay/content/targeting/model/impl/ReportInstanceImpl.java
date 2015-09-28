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

package com.liferay.content.targeting.model.impl;

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Locale;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The extended model implementation for the ReportInstance service. Represents a row in the &quot;CT_ReportInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.model.ReportInstance} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class ReportInstanceImpl extends ReportInstanceBaseImpl {

	public ReportInstanceImpl() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_reportsRegistry = ServiceTrackerUtil.getService(
			ReportsRegistry.class, bundle.getBundleContext());
	}

	public String getTypeName(Locale locale) {
		Report report = _reportsRegistry.getReport(getReportKey());

		if (report == null) {
			return StringPool.BLANK;
		}

		if (!report.isInstantiable()) {
			return LanguageUtil.get(locale, "system-report");
		}

		return report.getName(locale);
	}

	public boolean isInstantiable() {
		Report report = _reportsRegistry.getReport(getReportKey());

		if (report == null) {
			return false;
		}

		return report.isInstantiable();
	}

	private ReportsRegistry _reportsRegistry;

}