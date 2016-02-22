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

package com.liferay.content.targeting.util;

import com.liferay.asset.kernel.exception.NoSuchVocabularyException;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentUtil {

	public static final String[] SELECTED_FIELD_NAMES =
		{Field.COMPANY_ID, Field.GROUP_ID, Field.UID, "userSegmentId"};

	public static AssetVocabulary addAssetVocabulary(
			long userId, ServiceContext serviceContext)
		throws PortalException {

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		return AssetVocabularyLocalServiceUtil.addVocabulary(
			userId, serviceContext.getScopeGroupId(), StringPool.BLANK,
			_getAssetVocabularyTitleMap(), null, StringPool.BLANK,
			serviceContext);
	}

	public static long getAssetVocabularyId(
			long userId, ServiceContext serviceContext)
		throws PortalException {

		AssetVocabulary vocabulary = null;

		try {
			vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(
				serviceContext.getScopeGroupId(), getAssetVocabularyName());
		}
		catch (NoSuchVocabularyException nsve) {
			Group scopeGroup = serviceContext.getScopeGroup();

			String categoryUuid = serviceContext.getUuid();

			if (scopeGroup.isStagingGroup()) {
				AssetVocabulary liveVocabulary = null;

				try {
					liveVocabulary =
						AssetVocabularyLocalServiceUtil.getGroupVocabulary(
							scopeGroup.getLiveGroupId(),
							getAssetVocabularyName());
				}
				catch (NoSuchVocabularyException nsve2) {
					ServiceContext serviceContextLive =
						(ServiceContext)serviceContext.clone();

					serviceContextLive.setScopeGroupId(
						scopeGroup.getLiveGroupId());

					liveVocabulary = addAssetVocabulary(
						userId, serviceContextLive);
				}

				serviceContext.setUuid(liveVocabulary.getUuid());
			}

			vocabulary = addAssetVocabulary(userId, serviceContext);

			serviceContext.setUuid(categoryUuid);
		}

		return vocabulary.getVocabularyId();
	}

	public static long[] getAssetVocabularyIds(long[] groupIds)
		throws PortalException {

		List<Long> vocabularyIds = new ArrayList<>();

		for (long groupId : groupIds) {
			try {
				AssetVocabulary vocabulary =
					AssetVocabularyLocalServiceUtil.getGroupVocabulary(
						groupId, getAssetVocabularyName());

				vocabularyIds.add(vocabulary.getVocabularyId());
			}
			catch (NoSuchVocabularyException nsve) {
			}
		}

		return ArrayUtil.toLongArray(vocabularyIds);
	}

	public static String getAssetVocabularyName() {
		return LanguageUtil.get(
			LocaleUtil.getDefault(), UserSegmentConstants.VOCABULARY_NAME);
	}

	public static List<UserSegment> getUserSegments(Hits hits)
		throws PortalException {

		List<Document> documents = hits.toList();

		List<UserSegment> userSegments = new ArrayList<>(documents.size());

		for (com.liferay.portal.kernel.search.Document document : documents) {
			long userSegmentId = GetterUtil.getLong(
				document.get("userSegmentId"));

			UserSegment userSegment =
				UserSegmentLocalServiceUtil.fetchUserSegment(userSegmentId);

			if (userSegment == null) {
				userSegments = null;

				Indexer indexer = IndexerRegistryUtil.getIndexer(
					UserSegment.class);

				long companyId = GetterUtil.getLong(
					document.get(Field.COMPANY_ID));

				indexer.delete(companyId, document.getUID());
			}
			else if (userSegments != null) {
				userSegments.add(userSegment);
			}
		}

		return userSegments;
	}

	private static Map<Locale, String> _getAssetVocabularyTitleMap() {
		Map<Locale, String> titleMap = new HashMap<>();

		Set<Locale> locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			titleMap.put(
				locale,
				LanguageUtil.get(locale, UserSegmentConstants.VOCABULARY_NAME));
		}

		return titleMap;
	}

}