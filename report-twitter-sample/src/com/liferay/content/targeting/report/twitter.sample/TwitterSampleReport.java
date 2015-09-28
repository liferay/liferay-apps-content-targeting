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

package com.liferay.content.targeting.report.twitter.sample;

import com.liferay.content.targeting.api.model.BaseReport;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true, service = Report.class)
public class TwitterSampleReport extends BaseReport {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public String getIcon() {
		return "icon-twitter";
	}

	@Override
	public String getReportType() {
		return Campaign.class.getName();
	}

	@Override
	public boolean isInstantiable() {
		return true;
	}

	@Override
	public String processEditReport(
			PortletRequest request, PortletResponse response,
			ReportInstance reportInstance)
		throws Exception {

		String topic = ParamUtil.getString(request, "topic");

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("topic", topic);

		return jsonObj.toString();
	}

	@Override
	public void updateReport(ReportInstance reportInstance) {
	}

	@Override
	protected void populateContext(
		ReportInstance reportInstance, Map<String, Object> context) {

		String topic = StringPool.BLANK;

		if (reportInstance != null) {
			String typeSettings = reportInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				topic = jsonObj.getString("topic");
			}
			catch (JSONException jse) {
			}
		}

		context.put("topic", topic);
	}

	@Override
	protected void populateEditContext(
		ReportInstance reportInstance, Map<String, Object> context) {

		populateContext(reportInstance, context);
	}

}