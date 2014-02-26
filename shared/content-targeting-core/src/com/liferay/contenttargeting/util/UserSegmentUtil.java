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

package com.liferay.contenttargeting.util;

import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.NoSuchVocabularyException;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentUtil {

	public static final String[] SELECTED_FIELD_NAMES =
		{Field.COMPANY_ID, Field.GROUP_ID, Field.UID, "userSegmentId"};

	public static Map<Locale, String> getAssetVocabularyDescription() {
		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			descriptionMap.put(
				locale,
				LanguageUtil.get(
					locale, UserSegmentConstants.VOCABULARY_DESCRIPTION));
		}

		return descriptionMap;
	}

	public static long getAssetVocabularyId(
			long userId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		AssetVocabulary vocabulary = null;

		try {
			vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(
				serviceContext.getScopeGroupId(), getAssetVocabularyName());
		}
		catch (NoSuchVocabularyException e) {
			vocabulary = AssetVocabularyLocalServiceUtil.addVocabulary(
				userId, null, getAssetVocabularyTitle(),
				getAssetVocabularyDescription(), null, serviceContext);
		}

		return vocabulary.getVocabularyId();
	}

	public static long[] getAssetVocabularyIds(long[] groupIds)
		throws PortalException, SystemException {

		List<Long> vocabularyIds = new ArrayList<Long>();

		for (long groupId : groupIds) {
			try {
				AssetVocabulary vocabulary =
					AssetVocabularyLocalServiceUtil.getGroupVocabulary(
						groupId, getAssetVocabularyName());

				vocabularyIds.add(vocabulary.getVocabularyId());
			}
			catch (NoSuchVocabularyException e) {
			}
		}

		return ArrayUtil.toLongArray(vocabularyIds);
	}

	public static String getAssetVocabularyName() {
		return LanguageUtil.get(
			LocaleUtil.getDefault(), UserSegmentConstants.VOCABULARY_NAME);
	}

	public static Map<Locale, String> getAssetVocabularyTitle() {
		Map<Locale, String> titleMap = new HashMap<Locale, String>();

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			titleMap.put(
				locale,
				LanguageUtil.get(locale, UserSegmentConstants.VOCABULARY_NAME));
		}

		return titleMap;
	}

	public static List<UserSegment> getUserSegments(Hits hits)
		throws PortalException, SystemException {

		List<Document> documents = hits.toList();

		List<UserSegment> userSegments = new ArrayList<UserSegment>(
			documents.size());

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

}