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

import com.liferay.asset.kernel.exception.DuplicateCategoryException;
import com.liferay.asset.kernel.exception.NoSuchCategoryException;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetCategoryConstants;
import com.liferay.content.targeting.exception.InvalidNameException;
import com.liferay.content.targeting.exception.UsedUserSegmentException;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.base.UserSegmentLocalServiceBaseImpl;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the user segment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.UserSegmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Eudaldo Alonso
 * @author Julio Camarero
 * @see com.liferay.content.targeting.service.base.UserSegmentLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.UserSegmentLocalServiceUtil
 */
public class UserSegmentLocalServiceImpl
	extends UserSegmentLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UserSegment addUserSegment(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		Date now = new Date();

		long userSegmentId = counterLocalService.increment();

		UserSegment userSegment = userSegmentPersistence.create(userSegmentId);

		userSegment.setUuid(serviceContext.getUuid());
		userSegment.setGroupId(serviceContext.getScopeGroupId());

		// Category

		AssetCategory assetCategory = null;

		long assetCategoryId = GetterUtil.getLong(
			serviceContext.getAttribute("userSegmentAssetCategoryId"));

		if (assetCategoryId > 0) {
			assetCategory = assetCategoryLocalService.getAssetCategory(
				assetCategoryId);
		}
		else {
			assetCategory = addUserSegmentCategory(
				userId, nameMap, descriptionMap, serviceContext);
		}

		userSegment.setAssetCategoryId(assetCategory.getCategoryId());
		userSegment.setCompanyId(user.getCompanyId());
		userSegment.setUserId(user.getUserId());
		userSegment.setUserName(user.getFullName());
		userSegment.setCreateDate(serviceContext.getCreateDate(now));
		userSegment.setModifiedDate(serviceContext.getModifiedDate(now));
		userSegment.setNameMap(nameMap);
		userSegment.setDescriptionMap(descriptionMap);

		validateUserSegment(userSegment);

		userSegmentPersistence.update(userSegment);

		// Resources

		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			addUserSegmentResources(
				userSegment, serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());
		}
		else {
			addUserSegmentResources(
				userSegment, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		// Local Live Category

		Group scopeGroup = serviceContext.getScopeGroup();

		if (scopeGroup.hasStagingGroup() &&
			!ContentTargetingUtil.isStaged(
				scopeGroup.getGroupId(), PortletKeys.CT_ADMIN)) {

			Group stagingGroup = scopeGroup.getStagingGroup();

			ServiceContext serviceContextStaging =
				(ServiceContext)serviceContext.clone();

			serviceContextStaging.setScopeGroupId(stagingGroup.getGroupId());
			serviceContextStaging.setUuid(assetCategory.getUuid());

			addUserSegmentCategory(
				userId, nameMap, descriptionMap, serviceContextStaging);
		}

		return userSegment;
	}

	@Override
	public void addUserSegmentResources(
			UserSegment userSegment, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws PortalException {

		resourceLocalService.addResources(
			userSegment.getCompanyId(), userSegment.getGroupId(),
			userSegment.getUserId(), UserSegment.class.getName(),
			userSegment.getUserSegmentId(), false, addGroupPermissions,
			addGuestPermissions);
	}

	@Override
	public void addUserSegmentResources(
			UserSegment userSegment, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException {

		resourceLocalService.addModelResources(
			userSegment.getCompanyId(), userSegment.getGroupId(),
			userSegment.getUserId(), UserSegment.class.getName(),
			userSegment.getUserSegmentId(), groupPermissions, guestPermissions);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public UserSegment deleteUserSegment(long userSegmentId)
		throws PortalException {

		List<Campaign> campaigns = userSegmentPersistence.getCampaigns(
			userSegmentId);

		if (!campaigns.isEmpty()) {
			throw new UsedUserSegmentException(campaigns);
		}

		UserSegment userSegment = userSegmentPersistence.findByPrimaryKey(
			userSegmentId);

		return deleteUserSegment(userSegment);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public UserSegment deleteUserSegment(UserSegment userSegment)
		throws PortalException {

		userSegmentPersistence.remove(userSegment);

		// System event

		systemEventLocalService.addSystemEvent(
			0, userSegment.getGroupId(), UserSegment.class.getName(),
			userSegment.getUserSegmentId(), userSegment.getUuid(), null,
			SystemEventConstants.TYPE_DELETE, StringPool.BLANK);

		// Resources

		resourceLocalService.deleteResource(
			userSegment.getCompanyId(), UserSegment.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, userSegment.getUserSegmentId());

		// Reports

		for (ReportInstance reportInstance :
				reportInstanceLocalService.getReportInstances(
					UserSegment.class.getName(),
					userSegment.getUserSegmentId())) {

			reportInstanceLocalService.deleteReportInstance(
				reportInstance.getReportInstanceId());
		}

		// Rules

		for (RuleInstance ruleInstance :
				ruleInstanceLocalService.getRuleInstances(
					userSegment.getUserSegmentId())) {

			ruleInstanceLocalService.deleteRuleInstance(
				ruleInstance.getRuleInstanceId());
		}

		// Categories

		Group group = groupLocalService.fetchGroup(userSegment.getGroupId());

		AssetCategory stagingAssetCategory = getStagingAssetCategory(
			group, userSegment.getAssetCategoryId());

		if (stagingAssetCategory != null) {
			removeUserSegmentCategory(stagingAssetCategory.getCategoryId());
		}

		removeUserSegmentCategory(userSegment.getAssetCategoryId());

		return userSegment;
	}

	@Override
	public void deleteUserSegments(long groupId) throws PortalException {
		for (UserSegment userSegment :
				userSegmentPersistence.findByGroupId(groupId)) {

			userSegmentLocalService.deleteUserSegment(
				userSegment.getUserSegmentId());
		}
	}

	@Override
	public UserSegment fetchUserSegmentByAssetCategoryId(long assetCategoryId)
		throws PortalException {

		return userSegmentPersistence.fetchByAssetCategoryId(assetCategoryId);
	}

	@Override
	public List<UserSegment> getUserSegments(long groupId)
		throws PortalException {

		return getUserSegments(new long[] {groupId});
	}

	@Override
	public List<UserSegment> getUserSegments(
			long groupId, int start, int end, OrderByComparator obc)
		throws PortalException {

		return getUserSegments(new long[] {groupId}, start, end, obc);
	}

	@Override
	public List<UserSegment> getUserSegments(long[] groupIds)
		throws PortalException {

		return userSegmentPersistence.findByGroupId(groupIds);
	}

	@Override
	public List<UserSegment> getUserSegments(
			long[] groupIds, int start, int end, OrderByComparator obc)
		throws PortalException {

		return userSegmentPersistence.findByGroupId(groupIds, start, end, obc);
	}

	@Override
	public int getUserSegmentsCount(long groupId) throws PortalException {
		return userSegmentPersistence.countByGroupId(groupId);
	}

	@Override
	public int getUserSegmentsCount(long[] groupIds) throws PortalException {
		return userSegmentPersistence.countByGroupId(groupIds);
	}

	@Override
	public Hits search(long groupId, String keywords, int start, int end)
		throws PortalException {

		Indexer indexer = IndexerRegistryUtil.getIndexer(
			UserSegment.class.getName());

		SearchContext searchContext = buildSearchContext(
			groupId, keywords, start, end);

		return indexer.search(searchContext);
	}

	@Override
	public BaseModelSearchResult<UserSegment> searchUserSegments(
			long groupId, String keywords, int start, int end)
		throws PortalException {

		SearchContext searchContext = buildSearchContext(
			groupId, keywords, start, end);

		return searchUserSegments(searchContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UserSegment updateUserSegment(
			long userSegmentId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException {

		Date now = new Date();

		UserSegment userSegment = userSegmentPersistence.findByPrimaryKey(
			userSegmentId);

		userSegment.setModifiedDate(serviceContext.getModifiedDate(now));
		userSegment.setNameMap(nameMap);
		userSegment.setDescriptionMap(descriptionMap);

		validateUserSegment(userSegment);

		userSegmentPersistence.update(userSegment);

		// Resources

		if ((serviceContext.getGroupPermissions() != null) ||
			(serviceContext.getGuestPermissions() != null)) {

			updateUserSegmentResources(
				userSegment, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		// Categories

		updateUserSegmentCategory(
			userSegment.getUserId(), userSegment.getAssetCategoryId(), nameMap,
			descriptionMap, serviceContext);

		AssetCategory stagingAssetCategory = getStagingAssetCategory(
			serviceContext.getScopeGroup(), userSegment.getAssetCategoryId());

		if (stagingAssetCategory != null) {
			ServiceContext serviceContextStaging =
				(ServiceContext)serviceContext.clone();

			serviceContextStaging.setScopeGroupId(
				stagingAssetCategory.getGroupId());

			updateUserSegmentCategory(
				userSegment.getUserId(), stagingAssetCategory.getCategoryId(),
				nameMap, descriptionMap, serviceContextStaging);
		}

		return userSegment;
	}

	@Override
	public void updateUserSegmentResources(
			UserSegment userSegment, String[] groupPermissions,
			String[] guestPermissions)
		throws PortalException {

		resourceLocalService.updateResources(
			userSegment.getCompanyId(), userSegment.getGroupId(),
			UserSegment.class.getName(), userSegment.getUserSegmentId(),
			groupPermissions, guestPermissions);
	}

	protected AssetCategory addUserSegmentCategory(
			long userId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException {

		long vocabularyId = UserSegmentUtil.getAssetVocabularyId(
			userId, serviceContext);

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		AssetCategory assetCategory = null;

		try {
			assetCategory = assetCategoryLocalService.addCategory(
				userId, serviceContext.getScopeGroupId(),
				AssetCategoryConstants.DEFAULT_PARENT_CATEGORY_ID, titleMap,
				descriptionMap, vocabularyId, null, serviceContext);
		}
		catch (DuplicateCategoryException dce) {
			throw new InvalidNameException();
		}

		return assetCategory;
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

	protected AssetCategory getStagingAssetCategory(
		Group scopeGroup, long assetCategoryId) {

		if (!scopeGroup.hasStagingGroup()) {
			return null;
		}

		Group stagingGroup = scopeGroup.getStagingGroup();

		AssetCategory assetCategory =
			assetCategoryLocalService.fetchAssetCategory(assetCategoryId);

		return assetCategoryLocalService.fetchAssetCategoryByUuidAndGroupId(
			assetCategory.getUuid(), stagingGroup.getGroupId());
	}

	protected void removeUserSegmentCategory(long assetCategoryId)
		throws PortalException {

		AssetCategory assetCategory =
			assetCategoryLocalService.fetchAssetCategory(assetCategoryId);

		try {
			assetCategoryLocalService.deleteCategory(assetCategory);
		}
		catch (NoSuchCategoryException nsce) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Category " + assetCategoryId + "could not be deleted");
			}
		}

		int categoriesCount =
			assetCategoryLocalService.getVocabularyRootCategoriesCount(
				assetCategory.getVocabularyId());

		if (categoriesCount > 0) {
			return;
		}

		assetVocabularyLocalService.deleteAssetVocabulary(
			assetCategory.getVocabularyId());
	}

	protected BaseModelSearchResult<UserSegment> searchUserSegments(
			SearchContext searchContext)
		throws PortalException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			UserSegment.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext);

			List<UserSegment> userSegments = UserSegmentUtil.getUserSegments(
				hits);

			if (userSegments != null) {
				return new BaseModelSearchResult<>(
					userSegments, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

	protected AssetCategory updateUserSegmentCategory(
			long userId, long assetCategoryId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException {

		long vocabularyId = UserSegmentUtil.getAssetVocabularyId(
			userId, serviceContext);

		AssetCategory assetCategory = assetCategoryLocalService.getCategory(
			assetCategoryId);

		assetCategoryLocalService.updateCategory(
			userId, assetCategoryId, assetCategory.getParentCategoryId(),
			titleMap, descriptionMap, vocabularyId, null, serviceContext);

		return assetCategory;
	}

	protected void validateUserSegment(UserSegment userSegment)
		throws PortalException {

		if (Validator.isNull(userSegment.getName(LocaleUtil.getDefault()))) {
			throw new InvalidNameException();
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserSegmentLocalServiceImpl.class);

}