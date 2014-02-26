/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service.impl;

import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.service.base.CampaignLocalServiceBaseImpl;
import com.liferay.contenttargeting.util.BaseModelSearchResult;
import com.liferay.contenttargeting.util.CampaignUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the campaign local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.service.CampaignLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Eduardo Garcia
 * @see com.liferay.contenttargeting.service.base.CampaignLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.CampaignLocalServiceUtil
 */
public class CampaignLocalServiceImpl extends CampaignLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Campaign addCampaign(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			int priority, long[] userSegmentIds, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long campaignId = CounterLocalServiceUtil.increment();

		Campaign campaign = campaignPersistence.create(campaignId);

		campaign.setGroupId(groupId);

		campaign.setCompanyId(user.getCompanyId());
		campaign.setUserId(user.getUserId());
		campaign.setUserName(user.getFullName());
		campaign.setCreateDate(serviceContext.getCreateDate(now));
		campaign.setModifiedDate(serviceContext.getModifiedDate(now));
		campaign.setNameMap(nameMap);
		campaign.setDescriptionMap(descriptionMap);
		campaign.setStartDate(startDate);
		campaign.setEndDate(endDate);
		campaign.setPriority(priority);

		campaignPersistence.update(campaign);

		if (userSegmentIds != null) {
			campaignPersistence.setUserSegments(
				campaign.getCampaignId(), userSegmentIds);
		}

		return campaign;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Campaign deleteCampaign(long campaignId)
		throws PortalException, SystemException {

		return campaignPersistence.remove(campaignId);
	}

	@Override
	public Campaign fetchCurrentMaxPriorityCampaign(
			long groupId, long[] userSegmentIds)
		throws SystemException {

		Date now = new Date();

		return campaignFinder.fetchByG_D_U(groupId, now, userSegmentIds);
	}

	@Override
	public List<Campaign> getCampaigns(long groupId)
		throws PortalException, SystemException {

		return getCampaigns(new long[]{groupId});
	}

	@Override
	public List<Campaign> getCampaigns(long[] groupIds)
		throws PortalException, SystemException {

		return campaignPersistence.findByGroupId(groupIds);
	}

	@Override
	public long getCampaignsCount(long groupId)
		throws PortalException, SystemException {

		return campaignPersistence.countByGroupId(groupId);
	}

	@Override
	public long getCampaignsCount(long[] groupIds)
		throws PortalException, SystemException {

		return campaignPersistence.countByGroupId(groupIds);
	}

	@Override
	public Hits search(long groupId, String keywords, int start, int end)
		throws PortalException, SystemException {

		Indexer indexer = IndexerRegistryUtil.getIndexer(
			Campaign.class.getName());

		SearchContext searchContext = buildSearchContext(
			groupId, keywords, start, end);

		return indexer.search(searchContext);
	}

	@Override
	public BaseModelSearchResult<Campaign> searchCampaigns(
			long groupId, String keywords, int start, int end)
		throws PortalException, SystemException {

		SearchContext searchContext = buildSearchContext(
			groupId, keywords, start, end);

		return searchCampaigns(searchContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Campaign updateCampaign(
			long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			int priority, long[] userSegmentIds, ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		Campaign campaign = campaignPersistence.findByPrimaryKey(campaignId);

		campaign.setModifiedDate(serviceContext.getModifiedDate(now));
		campaign.setNameMap(nameMap);
		campaign.setDescriptionMap(descriptionMap);
		campaign.setStartDate(startDate);
		campaign.setEndDate(endDate);
		campaign.setPriority(priority);

		campaignPersistence.update(campaign);

		if (userSegmentIds != null) {
			campaignPersistence.setUserSegments(campaignId, userSegmentIds);
		}

		return campaign;
	}

	protected SearchContext buildSearchContext(
			long groupId, String keywords, int start, int end)
		throws PortalException, SystemException {

		SearchContext searchContext = new SearchContext();

		Group group = GroupLocalServiceUtil.getGroup(groupId);

		searchContext.setCompanyId(group.getCompanyId());

		searchContext.setEnd(end);
		searchContext.setGroupIds(new long[]{groupId});
		searchContext.setKeywords(keywords);
		searchContext.setStart(start);

		return searchContext;
	}

	protected BaseModelSearchResult<Campaign> searchCampaigns(
			SearchContext searchContext)
		throws PortalException, SystemException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			Campaign.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext);

			List<Campaign> campaigns = CampaignUtil.getCampaigns(hits);

			if (campaigns != null) {
				return new BaseModelSearchResult<Campaign>(
					campaigns, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

}