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

import com.liferay.content.targeting.exception.InvalidDateRangeException;
import com.liferay.content.targeting.exception.InvalidNameException;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.service.base.CampaignLocalServiceBaseImpl;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.content.targeting.util.CampaignUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the campaign local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.CampaignLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Eduardo Garcia
 * @see com.liferay.content.targeting.service.base.CampaignLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.CampaignLocalServiceUtil
 */
public class CampaignLocalServiceImpl extends CampaignLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Campaign addCampaign(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			int priority, boolean active, long[] userSegmentIds,
			ServiceContext serviceContext)
		throws PortalException {

		return addCampaign(
			userId, nameMap, descriptionMap, startDate, endDate, null, priority,
			active, userSegmentIds, serviceContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Campaign addCampaign(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			String timeZoneId, int priority, boolean active,
			long[] userSegmentIds, ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		Date now = new Date();

		if (timeZoneId == null) {
			timeZoneId = user.getTimeZone().getID();
		}

		long campaignId = counterLocalService.increment();

		Campaign campaign = campaignPersistence.create(campaignId);

		campaign.setUuid(serviceContext.getUuid());
		campaign.setGroupId(serviceContext.getScopeGroupId());
		campaign.setCompanyId(user.getCompanyId());
		campaign.setUserId(user.getUserId());
		campaign.setUserName(user.getFullName());
		campaign.setCreateDate(serviceContext.getCreateDate(now));
		campaign.setModifiedDate(serviceContext.getModifiedDate(now));
		campaign.setNameMap(nameMap);
		campaign.setDescriptionMap(descriptionMap);
		campaign.setStartDate(startDate);
		campaign.setEndDate(endDate);
		campaign.setTimeZoneId(timeZoneId);
		campaign.setPriority(priority);
		campaign.setActive(active);

		validateCampaign(campaign);

		campaignPersistence.update(campaign);

		// Resources

		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			addCampaignResources(
				campaign, serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());
		}
		else {
			addCampaignResources(
				campaign, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		// User Segments

		if (userSegmentIds != null) {
			campaignPersistence.setUserSegments(
				campaign.getCampaignId(), userSegmentIds);
		}

		return campaign;
	}

	@Override
	public void addCampaignResources(
			Campaign campaign, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		resourceLocalService.addResources(
			campaign.getCompanyId(), campaign.getGroupId(),
			campaign.getUserId(), Campaign.class.getName(),
			campaign.getCampaignId(), false, addGroupPermissions,
			addGuestPermissions);
	}

	@Override
	public void addCampaignResources(
			Campaign campaign, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException {

		resourceLocalService.addModelResources(
			campaign.getCompanyId(), campaign.getGroupId(),
			campaign.getUserId(), Campaign.class.getName(),
			campaign.getCampaignId(), groupPermissions, guestPermissions);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Campaign deleteCampaign(Campaign campaign) throws PortalException {
		campaignPersistence.remove(campaign);

		// System event

		systemEventLocalService.addSystemEvent(
			0, campaign.getGroupId(), Campaign.class.getName(),
			campaign.getCampaignId(), campaign.getUuid(), null,
			SystemEventConstants.TYPE_DELETE, StringPool.BLANK);

		// Resources

		resourceLocalService.deleteResource(
			campaign.getCompanyId(), Campaign.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, campaign.getCampaignId());

		// Reports

		for (ReportInstance reportInstance :
				reportInstanceLocalService.getReportInstances(
					Campaign.class.getName(), campaign.getCampaignId())) {

			reportInstanceLocalService.deleteReportInstance(
				reportInstance.getReportInstanceId());
		}

		// Tracking Actions

		for (TrackingActionInstance trackingActionInstance :
				trackingActionInstanceLocalService.getTrackingActionInstances(
					campaign.getCampaignId())) {

			trackingActionInstanceLocalService.deleteTrackingActionInstance(
				trackingActionInstance.getTrackingActionInstanceId());
		}

		// Tactics

		List<Tactic> tactics = tacticLocalService.getTactics(
			campaign.getCampaignId());

		for (Tactic tactic : tactics) {
			tacticLocalService.deleteTactic(tactic.getTacticId());
		}

		return campaign;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Campaign deleteCampaign(long campaignId) throws PortalException {
		Campaign campaign = campaignPersistence.findByPrimaryKey(campaignId);

		return deleteCampaign(campaign);
	}

	@Override
	public void deleteCampaigns(long groupId) throws PortalException {
		for (Campaign campaign : campaignPersistence.findByGroupId(groupId)) {
			campaignLocalService.deleteCampaign(campaign.getCampaignId());
		}
	}

	@Override
	public Campaign fetchCurrentMaxPriorityCampaign(
		long[] groupIds, long[] userSegmentIds) {

		Date now = new Date();

		return campaignFinder.fetchByG_D_A_U_First(
			groupIds, now, true, userSegmentIds);
	}

	@Override
	public List<Campaign> getCampaigns(long groupId) throws PortalException {
		return getCampaigns(new long[] {groupId});
	}

	@Override
	public List<Campaign> getCampaigns(
			long groupId, int start, int end, OrderByComparator obc)
		throws PortalException {

		return getCampaigns(new long[] {groupId}, start, end, obc);
	}

	@Override
	public List<Campaign> getCampaigns(long[] groupIds) throws PortalException {
		return campaignPersistence.findByGroupId(groupIds);
	}

	@Override
	public List<Campaign> getCampaigns(
			long[] groupIds, int start, int end, OrderByComparator obc)
		throws PortalException {

		return campaignPersistence.findByGroupId(groupIds, start, end, obc);
	}

	@Override
	public List<Campaign> getCampaigns(long[] groupIds, long[] userSegmentIds)
		throws PortalException {

		Date now = new Date();

		return campaignFinder.findByG_D_A_U(
			groupIds, now, true, userSegmentIds);
	}

	@Override
	public int getCampaignsCount(long groupId) throws PortalException {
		return campaignPersistence.countByGroupId(groupId);
	}

	@Override
	public int getCampaignsCount(long[] groupIds) throws PortalException {
		return campaignPersistence.countByGroupId(groupIds);
	}

	@Override
	public Hits search(long groupId, String keywords, int start, int end)
		throws PortalException {

		Indexer indexer = IndexerRegistryUtil.getIndexer(
			Campaign.class.getName());

		SearchContext searchContext = buildSearchContext(
			groupId, keywords, start, end);

		return indexer.search(searchContext);
	}

	@Override
	public BaseModelSearchResult<Campaign> searchCampaigns(
			long groupId, String keywords, int start, int end)
		throws PortalException {

		SearchContext searchContext = buildSearchContext(
			groupId, keywords, start, end);

		return searchCampaigns(searchContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Campaign updateCampaign(
			long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			int priority, boolean active, long[] userSegmentIds,
			ServiceContext serviceContext)
		throws PortalException {

		return updateCampaign(
			campaignId, nameMap, descriptionMap, startDate, endDate, null,
			priority, active, userSegmentIds, serviceContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Campaign updateCampaign(
			long campaignId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, Date startDate, Date endDate,
			String timeZoneId, int priority, boolean active,
			long[] userSegmentIds, ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		if (timeZoneId == null) {
			timeZoneId = serviceContext.getTimeZone().getID();
		}

		Campaign campaign = campaignPersistence.findByPrimaryKey(campaignId);

		campaign.setModifiedDate(serviceContext.getModifiedDate(now));
		campaign.setNameMap(nameMap);
		campaign.setDescriptionMap(descriptionMap);
		campaign.setStartDate(startDate);
		campaign.setEndDate(endDate);
		campaign.setTimeZoneId(timeZoneId);
		campaign.setPriority(priority);
		campaign.setActive(active);

		validateCampaign(campaign);

		campaignPersistence.update(campaign);

		// Resources

		if ((serviceContext.getGroupPermissions() != null) ||
			(serviceContext.getGuestPermissions() != null)) {

			updateCampaignResources(
				campaign, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		// User Segments

		campaignPersistence.setUserSegments(campaignId, userSegmentIds);

		return campaign;
	}

	@Override
	public void updateCampaignResources(
			Campaign campaign, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException {

		resourceLocalService.updateResources(
			campaign.getCompanyId(), campaign.getGroupId(),
			Campaign.class.getName(), campaign.getCampaignId(),
			groupPermissions, guestPermissions);
	}

	protected SearchContext buildSearchContext(
			long groupId, String keywords, int start, int end)
		throws PortalException {

		SearchContext searchContext = new SearchContext();

		Group group = groupLocalService.getGroup(groupId);

		searchContext.setCompanyId(group.getCompanyId());
		searchContext.setEnd(end);
		searchContext.setGroupIds(new long[] {groupId});
		searchContext.setKeywords(keywords);
		searchContext.setStart(start);

		return searchContext;
	}

	protected BaseModelSearchResult<Campaign> searchCampaigns(
			SearchContext searchContext)
		throws PortalException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			Campaign.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext);

			List<Campaign> campaigns = CampaignUtil.getCampaigns(hits);

			if (campaigns != null) {
				return new BaseModelSearchResult<>(campaigns, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

	protected void validateCampaign(Campaign campaign) throws PortalException {
		if (Validator.isNull(campaign.getName(LocaleUtil.getDefault()))) {
			throw new InvalidNameException();
		}

		if ((campaign.getStartDate() == null) ||
			(campaign.getEndDate() == null) ||
			campaign.getStartDate().after(campaign.getEndDate())) {

			throw new InvalidDateRangeException();
		}
	}

}