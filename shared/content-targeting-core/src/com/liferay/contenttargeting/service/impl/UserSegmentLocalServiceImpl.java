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

import com.liferay.contenttargeting.UsedUserSegmentException;
import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.base.UserSegmentLocalServiceBaseImpl;
import com.liferay.contenttargeting.util.BaseModelSearchResult;
import com.liferay.contenttargeting.util.UserSegmentUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import com.liferay.portlet.asset.NoSuchCategoryException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryConstants;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the user segment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contenttargeting.service.UserSegmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Eudaldo Alonso
 * @author Julio Camarero
 * @see com.liferay.contenttargeting.service.base.UserSegmentLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.UserSegmentLocalServiceUtil
 */
public class UserSegmentLocalServiceImpl
		extends UserSegmentLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UserSegment addUserSegment(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		long userSegmentId = CounterLocalServiceUtil.increment();

		UserSegment userSegment = userSegmentPersistence.create(userSegmentId);

		userSegment.setGroupId(groupId);

		AssetCategory assetCategory = addUserSegmentCategory(
			userId, nameMap, descriptionMap, serviceContext);

		userSegment.setAssetCategoryId(assetCategory.getCategoryId());
		userSegment.setCompanyId(user.getCompanyId());
		userSegment.setUserId(user.getUserId());
		userSegment.setUserName(user.getFullName());
		userSegment.setCreateDate(serviceContext.getCreateDate(now));
		userSegment.setModifiedDate(serviceContext.getModifiedDate(now));
		userSegment.setNameMap(nameMap);
		userSegment.setDescriptionMap(descriptionMap);

		userSegmentPersistence.update(userSegment);

		return userSegment;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public UserSegment deleteUserSegment(long userSegmentId)
		throws PortalException, SystemException {

		List<Campaign> campaigns = userSegmentPersistence.getCampaigns(
			userSegmentId);

		if (!campaigns.isEmpty()) {
			throw new UsedUserSegmentException(campaigns);
		}

		UserSegment userSegment = userSegmentPersistence.remove(userSegmentId);

		for (RuleInstance ruleInstance :
				ruleInstancePersistence.findByUserSegmentId(userSegmentId)) {

			ruleInstanceService.deleteRuleInstance(
				ruleInstance.getRuleInstanceId());
		}

		try {
			removeUserSegmentCategory(userSegment.getAssetCategoryId());
		}
		catch (NoSuchCategoryException nsace) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Category " + userSegment.getAssetCategoryId() +
						"could not be deleted");
			}
		}

		return userSegment;
	}

	@Override
	public List<UserSegment> getUserSegments(long groupId)
		throws PortalException, SystemException {

		return getUserSegments(new long[]{groupId});
	}

	@Override
	public List<UserSegment> getUserSegments(long[] groupIds)
		throws PortalException, SystemException {

		return userSegmentPersistence.findByGroupId(groupIds);
	}

	@Override
	public int getUserSegmentsCount(long groupId)
		throws PortalException, SystemException {

		return userSegmentPersistence.countByGroupId(groupId);
	}

	@Override
	public int getUserSegmentsCount(long[] groupIds)
		throws PortalException, SystemException {

		return userSegmentPersistence.countByGroupId(groupIds);
	}

	@Override
	public Hits search(long groupId, String keywords, int start, int end)
		throws PortalException, SystemException {

		Indexer indexer = IndexerRegistryUtil.getIndexer(
			UserSegment.class.getName());

		SearchContext searchContext = buildSearchContext(
			groupId, keywords, start, end);

		return indexer.search(searchContext);
	}

	@Override
	public BaseModelSearchResult<UserSegment> searchUserSegments(
			long groupId, String keywords, int start, int end)
		throws PortalException, SystemException {

		SearchContext searchContext = buildSearchContext(
			groupId, keywords, start, end);

		return searchUserSegments(searchContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UserSegment updateUserSegment(
			long userSegmentId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		UserSegment userSegment = userSegmentPersistence.findByPrimaryKey(
			userSegmentId);

		userSegment.setModifiedDate(serviceContext.getModifiedDate(now));
		userSegment.setNameMap(nameMap);
		userSegment.setDescriptionMap(descriptionMap);

		userSegmentPersistence.update(userSegment);

		updateUserSegmentCategory(
			userSegment.getUserId(), userSegment.getAssetCategoryId(), nameMap,
			descriptionMap, serviceContext);

		return userSegment;
	}

	protected AssetCategory addUserSegmentCategory(
			long userId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long vocabularyId = UserSegmentUtil.getAssetVocabularyId(
			userId, serviceContext);

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		AssetCategory assetCategory = AssetCategoryLocalServiceUtil.addCategory(
			userId, AssetCategoryConstants.DEFAULT_PARENT_CATEGORY_ID, titleMap,
			descriptionMap, vocabularyId, null, serviceContext);

		return assetCategory;
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

	protected void removeUserSegmentCategory(long assetCategoryId)
		throws PortalException, SystemException {

		AssetCategory assetCategory =
			AssetCategoryLocalServiceUtil.fetchAssetCategory(assetCategoryId);

		AssetCategoryLocalServiceUtil.deleteCategory(assetCategory);

		int categoriesCount =
			AssetCategoryLocalServiceUtil.getVocabularyRootCategoriesCount(
				assetCategory.getVocabularyId());

		if (categoriesCount > 0) {
			return;
		}

		AssetVocabularyLocalServiceUtil.deleteAssetVocabulary(
			assetCategory.getVocabularyId());
	}

	protected BaseModelSearchResult<UserSegment> searchUserSegments(
			SearchContext searchContext)
		throws PortalException, SystemException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			UserSegment.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext);

			List<UserSegment> userSegments = UserSegmentUtil.getUserSegments(
				hits);

			if (userSegments != null) {
				return new BaseModelSearchResult<UserSegment>(
					userSegments, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

	protected AssetCategory updateUserSegmentCategory(
			long userId, long assetCategoryId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long vocabularyId = UserSegmentUtil.getAssetVocabularyId(
			userId, serviceContext);

		AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getCategory(
			assetCategoryId);

		AssetCategoryLocalServiceUtil.updateCategory(
			userId, assetCategoryId, assetCategory.getParentCategoryId(),
			titleMap, descriptionMap, vocabularyId, null, serviceContext);

		return assetCategory;
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserSegmentLocalServiceImpl.class);

}