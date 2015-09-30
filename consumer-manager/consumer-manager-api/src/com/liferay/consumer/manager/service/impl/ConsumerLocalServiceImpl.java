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

import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.model.ConsumerExtensionInstance;
import com.liferay.consumer.manager.service.base.ConsumerLocalServiceBaseImpl;
import com.liferay.consumer.manager.util.BaseModelSearchResult;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the consumer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.consumer.manager.service.ConsumerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.consumer.manager.service.base.ConsumerLocalServiceBaseImpl
 * @see com.liferay.consumer.manager.service.ConsumerLocalServiceUtil
 */
public class ConsumerLocalServiceImpl extends ConsumerLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Consumer addConsumer(
			String consumerKey, Map<Locale, String> descriptionMap,
			Map<Locale, String> nameMap, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long consumerId = counterLocalService.increment();

		Consumer consumer = consumerPersistence.create(consumerId);

		User user = userLocalService.getUser(serviceContext.getUserId());

		Date now = new Date();

		consumer.setUuid(serviceContext.getUuid());
		consumer.setCompanyId(user.getCompanyId());
		consumer.setUserId(user.getUserId());
		consumer.setUserName(user.getFullName());
		consumer.setCreateDate(serviceContext.getCreateDate(now));
		consumer.setModifiedDate(serviceContext.getModifiedDate(now));
		consumer.setConsumerKey(consumerKey);
		consumer.setNameMap(nameMap);
		consumer.setDescriptionMap(descriptionMap);

		consumerPersistence.update(consumer);

		return consumer;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Consumer deleteConsumer(Consumer consumer)
		throws PortalException, SystemException {

		consumerPersistence.remove(consumer);

		return consumer;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Consumer deleteConsumer(long consumerId)
		throws PortalException, SystemException {

		Consumer consumer = consumerPersistence.findByPrimaryKey(consumerId);

		return deleteConsumer(consumer);
	}

	@Override
	public Consumer getConsumer(long companyId, String consumerKey)
		throws SystemException {

		return consumerPersistence.fetchByC_C(companyId, consumerKey);
	}

	@Override
	public List<Consumer> getConsumers()
		throws PortalException, SystemException {

		return consumerPersistence.findAll();
	}

	@Override
	public List<Consumer> getConsumers(long companyId)
		throws PortalException, SystemException {

		return consumerPersistence.findByCompanyId(companyId);
	}

	@Override
	public List<Consumer> getConsumers(
			long companyId, int start, int end, OrderByComparator obc)
		throws PortalException, SystemException {

		return consumerPersistence.findByCompanyId(companyId, start, end, obc);
	}

	@Override
	public List<Consumer> getConsumersByConsumerExtensionKey(
			long companyId, String consumerExtensionKey)
		throws PortalException, SystemException {

		List<Long> consumerIds = new ArrayList<Long>();

		List<ConsumerExtensionInstance> consumerExtensionInstances =
			consumerExtensionInstancePersistence.findByC_C(
				companyId, consumerExtensionKey);

		for (ConsumerExtensionInstance consumerExtensionInstance :
				consumerExtensionInstances) {

			if (!consumerIds.contains(
					consumerExtensionInstance.getConsumerId())) {

				consumerIds.add(consumerExtensionInstance.getConsumerId());
			}
		}

		if (consumerIds.isEmpty()) {
			return Collections.emptyList();
		}

		return consumerPersistence.findByConsumerIds(
			ArrayUtil.toLongArray(consumerIds));
	}

	@Override
	public int getConsumersCount(long companyId) throws SystemException {
		return consumerPersistence.countByCompanyId(companyId);
	}

	@Override
	public Hits search(long companyId, String keywords, int start, int end)
		throws PortalException, SystemException {

		Indexer indexer = IndexerRegistryUtil.getIndexer(
			Consumer.class.getName());

		SearchContext searchContext = buildSearchContext(
			companyId, keywords, start, end);

		return indexer.search(searchContext);
	}

	@Override
	public BaseModelSearchResult<Consumer> searchConsumers(
			long companyId, String keywords, int start, int end)
		throws PortalException, SystemException {

		SearchContext searchContext = buildSearchContext(
			companyId, keywords, start, end);

		return searchConsumers(searchContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Consumer updateConsumer(
			long consumerId, String consumerKey,
			Map<Locale, String> descriptionMap, Map<Locale, String> nameMap,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Consumer consumer = consumerPersistence.findByPrimaryKey(consumerId);

		Date now = new Date();

		consumer.setConsumerKey(consumerKey);
		consumer.setNameMap(nameMap);
		consumer.setDescriptionMap(descriptionMap);
		consumer.setModifiedDate(serviceContext.getModifiedDate(now));

		consumerPersistence.update(consumer);

		return consumer;
	}

	protected SearchContext buildSearchContext(
			long companyId, String keywords, int start, int end)
		throws PortalException, SystemException {

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(companyId);
		searchContext.setEnd(end);
		searchContext.setKeywords(keywords);
		searchContext.setStart(start);

		return searchContext;
	}

	protected List<Consumer> getConsumers(Hits hits)
		throws PortalException, SystemException {

		List<Document> documents = hits.toList();

		List<Consumer> consumers = new ArrayList<Consumer>(documents.size());

		for (Document document : documents) {
			long consumerId = GetterUtil.getLong(document.get("consumerId"));

			Consumer consumer = fetchConsumer(consumerId);

			if (consumer == null) {
				consumers = null;

				Indexer indexer = IndexerRegistryUtil.getIndexer(
					Consumer.class);

				long companyId = GetterUtil.getLong(
					document.get(Field.COMPANY_ID));

				indexer.delete(companyId, document.getUID());
			}
			else if (consumers != null) {
				consumers.add(consumer);
			}
		}

		return consumers;
	}

	protected BaseModelSearchResult<Consumer> searchConsumers(
			SearchContext searchContext)
		throws PortalException, SystemException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			Consumer.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext);

			List<Consumer> consumers = getConsumers(hits);

			if (consumers != null) {
				return new BaseModelSearchResult<Consumer>(
					consumers, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

}