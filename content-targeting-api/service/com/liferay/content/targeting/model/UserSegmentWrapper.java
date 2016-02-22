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

package com.liferay.content.targeting.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserSegment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserSegment
 * @generated
 */
@ProviderType
public class UserSegmentWrapper implements UserSegment,
	ModelWrapper<UserSegment> {
	public UserSegmentWrapper(UserSegment userSegment) {
		_userSegment = userSegment;
	}

	@Override
	public Class<?> getModelClass() {
		return UserSegment.class;
	}

	@Override
	public String getModelClassName() {
		return UserSegment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("assetCategoryId", getAssetCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long assetCategoryId = (Long)attributes.get("assetCategoryId");

		if (assetCategoryId != null) {
			setAssetCategoryId(assetCategoryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new UserSegmentWrapper((UserSegment)_userSegment.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.model.UserSegment userSegment) {
		return _userSegment.compareTo(userSegment);
	}

	/**
	* Returns the asset category ID of this user segment.
	*
	* @return the asset category ID of this user segment
	*/
	@Override
	public long getAssetCategoryId() {
		return _userSegment.getAssetCategoryId();
	}

	@Override
	public long getAssetCategoryId(long groupId) {
		return _userSegment.getAssetCategoryId(groupId);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _userSegment.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this user segment.
	*
	* @return the company ID of this user segment
	*/
	@Override
	public long getCompanyId() {
		return _userSegment.getCompanyId();
	}

	/**
	* Returns the create date of this user segment.
	*
	* @return the create date of this user segment
	*/
	@Override
	public Date getCreateDate() {
		return _userSegment.getCreateDate();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _userSegment.getDefaultLanguageId();
	}

	/**
	* Returns the description of this user segment.
	*
	* @return the description of this user segment
	*/
	@Override
	public java.lang.String getDescription() {
		return _userSegment.getDescription();
	}

	/**
	* Returns the localized description of this user segment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this user segment
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _userSegment.getDescription(languageId);
	}

	/**
	* Returns the localized description of this user segment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this user segment
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _userSegment.getDescription(languageId, useDefault);
	}

	/**
	* Returns the localized description of this user segment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this user segment
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _userSegment.getDescription(locale);
	}

	/**
	* Returns the localized description of this user segment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this user segment. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _userSegment.getDescription(locale, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _userSegment.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _userSegment.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this user segment.
	*
	* @return the locales and localized descriptions of this user segment
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _userSegment.getDescriptionMap();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userSegment.getExpandoBridge();
	}

	/**
	* Returns the group ID of this user segment.
	*
	* @return the group ID of this user segment
	*/
	@Override
	public long getGroupId() {
		return _userSegment.getGroupId();
	}

	/**
	* Returns the modified date of this user segment.
	*
	* @return the modified date of this user segment
	*/
	@Override
	public Date getModifiedDate() {
		return _userSegment.getModifiedDate();
	}

	/**
	* Returns the name of this user segment.
	*
	* @return the name of this user segment
	*/
	@Override
	public java.lang.String getName() {
		return _userSegment.getName();
	}

	/**
	* Returns the localized name of this user segment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this user segment
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _userSegment.getName(languageId);
	}

	/**
	* Returns the localized name of this user segment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this user segment
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _userSegment.getName(languageId, useDefault);
	}

	/**
	* Returns the localized name of this user segment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this user segment
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _userSegment.getName(locale);
	}

	/**
	* Returns the localized name of this user segment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this user segment. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _userSegment.getName(locale, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _userSegment.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _userSegment.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this user segment.
	*
	* @return the locales and localized names of this user segment
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getNameMap() {
		return _userSegment.getNameMap();
	}

	@Override
	public java.lang.String getNameWithGroupName(java.util.Locale locale,
		long groupId) {
		return _userSegment.getNameWithGroupName(locale, groupId);
	}

	/**
	* Returns the primary key of this user segment.
	*
	* @return the primary key of this user segment
	*/
	@Override
	public long getPrimaryKey() {
		return _userSegment.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userSegment.getPrimaryKeyObj();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances() {
		return _userSegment.getRuleInstances();
	}

	/**
	* Returns the user ID of this user segment.
	*
	* @return the user ID of this user segment
	*/
	@Override
	public long getUserId() {
		return _userSegment.getUserId();
	}

	/**
	* Returns the user name of this user segment.
	*
	* @return the user name of this user segment
	*/
	@Override
	public java.lang.String getUserName() {
		return _userSegment.getUserName();
	}

	/**
	* Returns the user segment ID of this user segment.
	*
	* @return the user segment ID of this user segment
	*/
	@Override
	public long getUserSegmentId() {
		return _userSegment.getUserSegmentId();
	}

	/**
	* Returns the user uuid of this user segment.
	*
	* @return the user uuid of this user segment
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userSegment.getUserUuid();
	}

	/**
	* Returns the uuid of this user segment.
	*
	* @return the uuid of this user segment
	*/
	@Override
	public java.lang.String getUuid() {
		return _userSegment.getUuid();
	}

	@Override
	public int hashCode() {
		return _userSegment.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _userSegment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userSegment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userSegment.isNew();
	}

	@Override
	public boolean isRuleEnabled(
		com.liferay.content.targeting.api.model.Rule rule)
		throws java.lang.Exception {
		return _userSegment.isRuleEnabled(rule);
	}

	@Override
	public void persist() {
		_userSegment.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_userSegment.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_userSegment.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	* Sets the asset category ID of this user segment.
	*
	* @param assetCategoryId the asset category ID of this user segment
	*/
	@Override
	public void setAssetCategoryId(long assetCategoryId) {
		_userSegment.setAssetCategoryId(assetCategoryId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userSegment.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this user segment.
	*
	* @param companyId the company ID of this user segment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userSegment.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this user segment.
	*
	* @param createDate the create date of this user segment
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userSegment.setCreateDate(createDate);
	}

	/**
	* Sets the description of this user segment.
	*
	* @param description the description of this user segment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_userSegment.setDescription(description);
	}

	/**
	* Sets the localized description of this user segment in the language.
	*
	* @param description the localized description of this user segment
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_userSegment.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this user segment in the language, and sets the default locale.
	*
	* @param description the localized description of this user segment
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_userSegment.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_userSegment.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this user segment from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this user segment
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap) {
		_userSegment.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this user segment from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this user segment
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_userSegment.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userSegment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userSegment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userSegment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this user segment.
	*
	* @param groupId the group ID of this user segment
	*/
	@Override
	public void setGroupId(long groupId) {
		_userSegment.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this user segment.
	*
	* @param modifiedDate the modified date of this user segment
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userSegment.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this user segment.
	*
	* @param name the name of this user segment
	*/
	@Override
	public void setName(java.lang.String name) {
		_userSegment.setName(name);
	}

	/**
	* Sets the localized name of this user segment in the language.
	*
	* @param name the localized name of this user segment
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_userSegment.setName(name, locale);
	}

	/**
	* Sets the localized name of this user segment in the language, and sets the default locale.
	*
	* @param name the localized name of this user segment
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_userSegment.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_userSegment.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this user segment from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this user segment
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap) {
		_userSegment.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this user segment from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this user segment
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_userSegment.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_userSegment.setNew(n);
	}

	/**
	* Sets the primary key of this user segment.
	*
	* @param primaryKey the primary key of this user segment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userSegment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userSegment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this user segment.
	*
	* @param userId the user ID of this user segment
	*/
	@Override
	public void setUserId(long userId) {
		_userSegment.setUserId(userId);
	}

	/**
	* Sets the user name of this user segment.
	*
	* @param userName the user name of this user segment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_userSegment.setUserName(userName);
	}

	/**
	* Sets the user segment ID of this user segment.
	*
	* @param userSegmentId the user segment ID of this user segment
	*/
	@Override
	public void setUserSegmentId(long userSegmentId) {
		_userSegment.setUserSegmentId(userSegmentId);
	}

	/**
	* Sets the user uuid of this user segment.
	*
	* @param userUuid the user uuid of this user segment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userSegment.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this user segment.
	*
	* @param uuid the uuid of this user segment
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_userSegment.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.model.UserSegment> toCacheModel() {
		return _userSegment.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.model.UserSegment toEscapedModel() {
		return new UserSegmentWrapper(_userSegment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userSegment.toString();
	}

	@Override
	public com.liferay.content.targeting.model.UserSegment toUnescapedModel() {
		return new UserSegmentWrapper(_userSegment.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _userSegment.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserSegmentWrapper)) {
			return false;
		}

		UserSegmentWrapper userSegmentWrapper = (UserSegmentWrapper)obj;

		if (Validator.equals(_userSegment, userSegmentWrapper._userSegment)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _userSegment.getStagedModelType();
	}

	@Override
	public UserSegment getWrappedModel() {
		return _userSegment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userSegment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userSegment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userSegment.resetOriginalValues();
	}

	private final UserSegment _userSegment;
}