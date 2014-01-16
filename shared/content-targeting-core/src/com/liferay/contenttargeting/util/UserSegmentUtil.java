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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.NoSuchVocabularyException;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentUtil {

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

}