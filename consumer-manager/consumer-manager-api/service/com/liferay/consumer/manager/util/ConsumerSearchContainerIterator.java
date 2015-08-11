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

import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.service.ConsumerLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;

/**
 * @author Eduardo Garcia
 */
public class ConsumerSearchContainerIterator
	extends SearchContainerIterator<Consumer> {

	public ConsumerSearchContainerIterator(
			long companyId, String keywords,
			ConsumerLocalService consumerLocalService)
		throws PortletException {

		super(companyId, keywords);

		_consumerLocalService = consumerLocalService;
	}

	@Override
	public List<Consumer> getResults(int start, int end)
		throws PortalException, SystemException {

		if (Validator.isNull(keywords)) {
			return _consumerLocalService.getConsumers(
					companyId, start, end, null);
		}

		BaseModelSearchResult<Consumer> searchResults =
			_consumerLocalService.searchConsumers(
				companyId, keywords, start, end);

		return searchResults.getBaseModels();
	}

	@Override
	public int getTotal() throws PortalException, SystemException {
		if (Validator.isNull(keywords)) {
			return _consumerLocalService.getConsumersCount(companyId);
		}

		BaseModelSearchResult<Consumer> searchResults =
			_consumerLocalService.searchConsumers(
				companyId, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		return searchResults.getLength();
	}

	private ConsumerLocalService _consumerLocalService;

}