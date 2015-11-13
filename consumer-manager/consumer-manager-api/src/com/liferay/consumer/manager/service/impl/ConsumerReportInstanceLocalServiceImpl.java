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

package com.liferay.consumer.manager.service.impl;

import com.liferay.consumer.manager.api.model.ConsumerReport;
import com.liferay.consumer.manager.api.model.ConsumerReportsRegistry;
import com.liferay.consumer.manager.model.ConsumerReportInstance;
import com.liferay.consumer.manager.service.base.ConsumerReportInstanceLocalServiceBaseImpl;
import com.liferay.consumer.manager.util.BaseModelSearchResult;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.facet.MultiValueFacet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The implementation of the consumer extension report instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consumer.manager.service.ConsumerReportInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.consumer.manager.service.base.ConsumerReportInstanceLocalServiceBaseImpl
 * @see com.liferay.consumer.manager.service.ConsumerReportInstanceLocalServiceUtil
 */
public class ConsumerReportInstanceLocalServiceImpl
	extends ConsumerReportInstanceLocalServiceBaseImpl {

	public ConsumerReportInstanceLocalServiceImpl() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_consumerReportsRegistry = ServiceTrackerUtil.getService(
			ConsumerReportsRegistry.class, bundle.getBundleContext());
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ConsumerReportInstance addConsumerReportInstance(
			long consumerId, String reportKey, String reportCategoryKey,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long consumerExtensionReportInstanceId =
			counterLocalService.increment();

		ConsumerReportInstance consumerExtensionReportInstance =
			consumerReportInstancePersistence.create(
				consumerExtensionReportInstanceId);

		User user = userLocalService.getUser(serviceContext.getUserId());

		Date now = new Date();

		consumerExtensionReportInstance.setCompanyId(
			serviceContext.getCompanyId());
		consumerExtensionReportInstance.setUserId(user.getUserId());
		consumerExtensionReportInstance.setUserName(user.getFullName());
		consumerExtensionReportInstance.setCreateDate(
			serviceContext.getCreateDate(now));
		consumerExtensionReportInstance.setModifiedDate(
			serviceContext.getModifiedDate(now));

		consumerExtensionReportInstance.setConsumerId(consumerId);
		consumerExtensionReportInstance.setReportCategoryKey(reportCategoryKey);
		consumerExtensionReportInstance.setReportKey(reportKey);
		consumerExtensionReportInstance.setNameMap(nameMap);
		consumerExtensionReportInstance.setDescriptionMap(descriptionMap);
		consumerExtensionReportInstance.setTypeSettings(typeSettings);

		consumerReportInstancePersistence.update(
			consumerExtensionReportInstance);

		return consumerExtensionReportInstance;
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ConsumerReportInstance addConsumerReportInstance(
			long consumerId, String reportKey, String reportCategoryKey,
			String name, String description, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Map<Locale, String> nameMap = new HashMap<Locale, String>();
		nameMap.put(LocaleUtil.getDefault(), name);

		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		descriptionMap.put(LocaleUtil.getDefault(), description);

		return addConsumerReportInstance(
			consumerId, reportKey, reportCategoryKey, nameMap, descriptionMap,
			typeSettings, serviceContext);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public ConsumerReportInstance deleteConsumerReportInstance(
			long consumerExtensionReportInstanceId)
		throws PortalException, SystemException {

		ConsumerReportInstance consumerExtensionReportInstance =
			consumerReportInstancePersistence.fetchByPrimaryKey(
				consumerExtensionReportInstanceId);

		consumerReportInstancePersistence.remove(
			consumerExtensionReportInstanceId);

		return consumerExtensionReportInstance;
	}

	@Override
	public ConsumerReportInstance getReportInstance(
			long consumerExtensionReportInstanceId)
		throws PortalException, SystemException {

		return consumerReportInstancePersistence.findByPrimaryKey(
			consumerExtensionReportInstanceId);
	}

	@Override
	public List<ConsumerReportInstance> getReportInstances(
			long companyId, long consumerId, String reportCategoryKey,
			int start, int end)
		throws PortalException, SystemException {

		return consumerReportInstancePersistence.findByC_C_R(
			companyId, consumerId, reportCategoryKey, start, end);
	}

	@Override
	public int getReportInstancesCount(
			long companyId, long consumerId, String reportCategoryKey)
		throws PortalException, SystemException {

		return consumerReportInstancePersistence.countByC_C_R(
			companyId, consumerId, reportCategoryKey);
	}

	@Override
	public List<ConsumerReportInstance> searchReportInstances(
			long companyId, long consumerId, String reportCategoryKey,
			String keywords, int start, int end)
		throws PortalException, SystemException {

		SearchContext searchContext = buildSearchContext(
			companyId, consumerId, reportCategoryKey, keywords, start, end);

		return searchReportInstances(searchContext).getBaseModels();
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ConsumerReportInstance updateConsumerReportInstance(
			long consumerExtensionReportInstanceId, long consumerId,
			String reportKey, String reportCategoryKey,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ConsumerReportInstance consumerExtensionReportInstance =
			consumerReportInstancePersistence.fetchByPrimaryKey(
				consumerExtensionReportInstanceId);

		if (consumerExtensionReportInstance == null) {
			return null;
		}

		Date now = new Date();

		consumerExtensionReportInstance.setModifiedDate(
			serviceContext.getModifiedDate(now));

		consumerExtensionReportInstance.setConsumerId(consumerId);
		consumerExtensionReportInstance.setReportCategoryKey(reportCategoryKey);
		consumerExtensionReportInstance.setReportKey(reportKey);
		consumerExtensionReportInstance.setNameMap(nameMap);
		consumerExtensionReportInstance.setDescriptionMap(descriptionMap);
		consumerExtensionReportInstance.setTypeSettings(typeSettings);

		return consumerExtensionReportInstance;
	}

	protected SearchContext buildSearchContext(
			long companyId, long consumerId, String reportCategoryKey,
			String keywords, int start, int end)
		throws PortalException, SystemException {

		SearchContext searchContext = new SearchContext();

		MultiValueFacet consumerIdFacet = new MultiValueFacet(searchContext);

		consumerIdFacet.setFieldName("consumerId");
		consumerIdFacet.setStatic(true);
		consumerIdFacet.setValues(new long[] {consumerId});

		MultiValueFacet reportCategoryFacet = new MultiValueFacet(
			searchContext);

		reportCategoryFacet.setFieldName("reportCategoryKey");
		reportCategoryFacet.setStatic(true);
		reportCategoryFacet.setValues(new String[] {reportCategoryKey});

		searchContext.addFacet(consumerIdFacet);
		searchContext.addFacet(reportCategoryFacet);
		searchContext.setCompanyId(companyId);
		searchContext.setGroupIds(new long[]{0});
		searchContext.setEnd(end);
		searchContext.setKeywords(keywords == null ? "" : keywords);
		searchContext.setStart(start);

		return searchContext;
	}

	protected BaseModelSearchResult<ConsumerReportInstance>
			searchReportInstances(SearchContext searchContext)
		throws PortalException, SystemException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			ConsumerReportInstance.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext);

			List<ConsumerReportInstance> reportInstances = null;

			if (hits != null) {
				List<Document> documents = hits.toList();

				reportInstances = new ArrayList<ConsumerReportInstance>(
					documents.size());

				for (Document document : documents) {
					long consumerExtensionReportInstanceId = GetterUtil.getLong(
						document.get("consumerExtensionReportInstanceId"));

					ConsumerReportInstance
						consumerExtensionReportInstance =
							getReportInstance(
								consumerExtensionReportInstanceId);

					ConsumerReport report =
						_consumerReportsRegistry.getReport(
							consumerExtensionReportInstance.getReportKey());

					if (!report.isVisible(
							consumerExtensionReportInstance.getConsumerId())) {

						continue;
					}

					if (consumerExtensionReportInstance != null) {
						reportInstances.add(consumerExtensionReportInstance);
					}
				}
			}
			else {
				reportInstances = new ArrayList<ConsumerReportInstance>(0);
			}

			if ((hits != null) && (reportInstances != null)) {
				return
					new BaseModelSearchResult<ConsumerReportInstance>(
						reportInstances, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

	private ConsumerReportsRegistry _consumerReportsRegistry;

}