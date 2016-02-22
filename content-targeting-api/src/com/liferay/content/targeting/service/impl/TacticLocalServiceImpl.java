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

package com.liferay.content.targeting.service.impl;

import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.base.TacticLocalServiceBaseImpl;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.content.targeting.util.TacticUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.facet.MultiValueFacet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the tactic local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.TacticLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.TacticLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.TacticLocalServiceUtil
 */
public class TacticLocalServiceImpl extends TacticLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Tactic addTactic(
			long userId, long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, long[] userSegmentsIds,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		Date now = new Date();

		long tacticId = counterLocalService.increment();

		Tactic tactic = tacticPersistence.create(tacticId);

		tactic.setUuid(serviceContext.getUuid());
		tactic.setGroupId(serviceContext.getScopeGroupId());
		tactic.setCompanyId(user.getCompanyId());
		tactic.setUserId(user.getUserId());
		tactic.setUserName(user.getFullName());
		tactic.setCreateDate(serviceContext.getCreateDate(now));
		tactic.setModifiedDate(serviceContext.getModifiedDate(now));

		tactic.setCampaignId(campaignId);
		tactic.setNameMap(nameMap);
		tactic.setDescriptionMap(descriptionMap);

		tacticPersistence.update(tactic);

		if (userSegmentsIds != null) {
			tacticPersistence.setUserSegments(tacticId, userSegmentsIds);
		}

		return tactic;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Tactic deleteTactic(long tacticId) throws PortalException {
		for (ChannelInstance channelInstance
				: channelInstanceLocalService.getChannelInstances(tacticId)) {

			channelInstanceLocalService.deleteChannelInstance(
				channelInstance.getChannelInstanceId());
		}

		return super.deleteTactic(tacticId);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Tactic deleteTactic(Tactic tactic) throws PortalException {
		return deleteTactic(tactic.getTacticId());
	}

	public List<Tactic> getTactics(long campaignId) throws PortalException {
		return tacticPersistence.findByCampaignId(campaignId);
	}

	@Override
	public List<Tactic> getTactics(
			long campaignId, int start, int end, OrderByComparator obc)
		throws PortalException {

		return tacticPersistence.findByCampaignId(campaignId, start, end, obc);
	}

	@Override
	public int getTacticsCount(long campaignId) throws PortalException {
		return tacticPersistence.countByCampaignId(campaignId);
	}

	public BaseModelSearchResult<Tactic> searchTactics(
			long campaignId, long groupId, String keywords, int start, int end)
		throws PortalException {

		SearchContext searchContext = buildSearchContext(
			campaignId, groupId, keywords, start, end);

		return searchTactics(searchContext);
	}

	@Override
	public BaseModelSearchResult<Tactic> searchTactics(
			long groupId, String keywords, int start, int end)
		throws PortalException {

		SearchContext searchContext = buildSearchContext(
			groupId, keywords, start, end);

		return searchTactics(searchContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Tactic updateTactic(
			long tacticId, long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, long[] userSegmentsIds,
			ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		Tactic tactic = tacticPersistence.findByPrimaryKey(tacticId);
		tactic.setModifiedDate(serviceContext.getModifiedDate(now));
		tactic.setNameMap(nameMap);
		tactic.setDescriptionMap(descriptionMap);

		tacticPersistence.update(tactic);

		if (userSegmentsIds != null) {
			tacticPersistence.setUserSegments(
				tactic.getTacticId(), userSegmentsIds);
		}

		return tactic;
	}

	protected SearchContext buildSearchContext(
			long campaignId, long groupId, String keywords, int start, int end)
		throws PortalException {

		SearchContext searchContext = new SearchContext();

		Group group = groupLocalService.getGroup(groupId);

		MultiValueFacet multiValueFacet = new MultiValueFacet(searchContext);

		multiValueFacet.setFieldName("campaignId");
		multiValueFacet.setStatic(true);
		multiValueFacet.setValues(new long[] {campaignId});

		searchContext.addFacet(multiValueFacet);
		searchContext.setCompanyId(group.getCompanyId());
		searchContext.setEnd(end);
		searchContext.setGroupIds(new long[] {groupId});
		searchContext.setKeywords(keywords == null ? "" : keywords);
		searchContext.setStart(start);

		return searchContext;
	}

	protected SearchContext buildSearchContext(
			long groupId, String keywords, int start, int end)
		throws PortalException {

		SearchContext searchContext = new SearchContext();

		Group group = groupLocalService.getGroup(groupId);

		searchContext.setCompanyId(group.getCompanyId());
		searchContext.setEnd(end);
		searchContext.setGroupIds(new long[] {groupId});
		searchContext.setKeywords(keywords == null ? "" : keywords);
		searchContext.setStart(start);

		return searchContext;
	}

	protected BaseModelSearchResult<Tactic> searchTactics(
			SearchContext searchContext)
		throws PortalException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Tactic.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext);

			List<Tactic> tactics = TacticUtil.getTactics(hits);

			if ((hits != null) && (tactics != null)) {
				return new BaseModelSearchResult<>(tactics, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

}