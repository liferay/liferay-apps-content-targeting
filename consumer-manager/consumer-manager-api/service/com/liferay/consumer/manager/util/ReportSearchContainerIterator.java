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

package com.liferay.consumer.manager.util;

import com.liferay.consumer.manager.model.ConsumerReportInstance;
import com.liferay.consumer.manager.service.ConsumerReportInstanceLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

/**
 * @author Eduardo Garcia
 */
public class ReportSearchContainerIterator
	extends SearchContainerIterator<ConsumerReportInstance> {

	public ReportSearchContainerIterator(
			long companyId, long consumerId, PortletRequest portletRequest,
			ConsumerReportInstanceLocalService
				consumerReportInstanceLocalService)
		throws PortletException {

		super(companyId, "");

		_consumerId = consumerId;
		_consumerReportInstanceLocalService =
			consumerReportInstanceLocalService;
		_portletRequest = portletRequest;
	}

	public List<ConsumerReportInstance> getResults(
			String reportCategoryKey, int start, int end)
		throws PortalException, SystemException {

		String keywordsParam = String.format(
			"_%s_reportKeywords", reportCategoryKey);

		keywords = ParamUtil.getString(_portletRequest, keywordsParam, null);

		if (Validator.isNull(keywords)) {
			_consumerReportInstanceLocalService.getReportInstances(
				companyId, _consumerId, reportCategoryKey, start, end);
		}

		List<ConsumerReportInstance> searchResults =
			_consumerReportInstanceLocalService.searchReportInstances(
				companyId, _consumerId, reportCategoryKey, keywords, start,
				end);

		return searchResults;
	}

	public int getTotal(String reportCategoryKey)
		throws PortalException, SystemException {

		String keywordsParam = String.format(
			"_%s_reportKeywords", reportCategoryKey);

		keywords = ParamUtil.getString(_portletRequest, keywordsParam, null);

		if (Validator.isNull(keywords)) {
			_consumerReportInstanceLocalService.getReportInstancesCount(
				companyId, _consumerId, reportCategoryKey);
		}

		List<ConsumerReportInstance> searchResults =
			_consumerReportInstanceLocalService.searchReportInstances(
				companyId, _consumerId, reportCategoryKey, keywords,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		return searchResults.size();
	}

	private long _consumerId;
	private ConsumerReportInstanceLocalService
		_consumerReportInstanceLocalService;
	private PortletRequest _portletRequest;

}