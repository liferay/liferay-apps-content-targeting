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
 * This class is a wrapper for {@link Tactic}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Tactic
 * @generated
 */
@ProviderType
public class TacticWrapper implements Tactic, ModelWrapper<Tactic> {
	public TacticWrapper(Tactic tactic) {
		_tactic = tactic;
	}

	@Override
	public Class<?> getModelClass() {
		return Tactic.class;
	}

	@Override
	public String getModelClassName() {
		return Tactic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tacticId", getTacticId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("campaignId", getCampaignId());
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

		Long tacticId = (Long)attributes.get("tacticId");

		if (tacticId != null) {
			setTacticId(tacticId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
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
		return new TacticWrapper((Tactic)_tactic.clone());
	}

	@Override
	public int compareTo(com.liferay.content.targeting.model.Tactic tactic) {
		return _tactic.compareTo(tactic);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _tactic.getAvailableLanguageIds();
	}

	/**
	* Returns the campaign ID of this tactic.
	*
	* @return the campaign ID of this tactic
	*/
	@Override
	public long getCampaignId() {
		return _tactic.getCampaignId();
	}

	/**
	* Returns the company ID of this tactic.
	*
	* @return the company ID of this tactic
	*/
	@Override
	public long getCompanyId() {
		return _tactic.getCompanyId();
	}

	/**
	* Returns the create date of this tactic.
	*
	* @return the create date of this tactic
	*/
	@Override
	public Date getCreateDate() {
		return _tactic.getCreateDate();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _tactic.getDefaultLanguageId();
	}

	/**
	* Returns the description of this tactic.
	*
	* @return the description of this tactic
	*/
	@Override
	public java.lang.String getDescription() {
		return _tactic.getDescription();
	}

	/**
	* Returns the localized description of this tactic in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this tactic
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _tactic.getDescription(languageId);
	}

	/**
	* Returns the localized description of this tactic in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this tactic
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _tactic.getDescription(languageId, useDefault);
	}

	/**
	* Returns the localized description of this tactic in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this tactic
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _tactic.getDescription(locale);
	}

	/**
	* Returns the localized description of this tactic in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this tactic. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _tactic.getDescription(locale, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _tactic.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _tactic.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this tactic.
	*
	* @return the locales and localized descriptions of this tactic
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _tactic.getDescriptionMap();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tactic.getExpandoBridge();
	}

	/**
	* Returns the group ID of this tactic.
	*
	* @return the group ID of this tactic
	*/
	@Override
	public long getGroupId() {
		return _tactic.getGroupId();
	}

	/**
	* Returns the modified date of this tactic.
	*
	* @return the modified date of this tactic
	*/
	@Override
	public Date getModifiedDate() {
		return _tactic.getModifiedDate();
	}

	/**
	* Returns the name of this tactic.
	*
	* @return the name of this tactic
	*/
	@Override
	public java.lang.String getName() {
		return _tactic.getName();
	}

	/**
	* Returns the localized name of this tactic in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this tactic
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _tactic.getName(languageId);
	}

	/**
	* Returns the localized name of this tactic in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this tactic
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _tactic.getName(languageId, useDefault);
	}

	/**
	* Returns the localized name of this tactic in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this tactic
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _tactic.getName(locale);
	}

	/**
	* Returns the localized name of this tactic in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this tactic. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _tactic.getName(locale, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _tactic.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _tactic.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this tactic.
	*
	* @return the locales and localized names of this tactic
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getNameMap() {
		return _tactic.getNameMap();
	}

	/**
	* Returns the primary key of this tactic.
	*
	* @return the primary key of this tactic
	*/
	@Override
	public long getPrimaryKey() {
		return _tactic.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tactic.getPrimaryKeyObj();
	}

	/**
	* Returns the tactic ID of this tactic.
	*
	* @return the tactic ID of this tactic
	*/
	@Override
	public long getTacticId() {
		return _tactic.getTacticId();
	}

	/**
	* Returns the user ID of this tactic.
	*
	* @return the user ID of this tactic
	*/
	@Override
	public long getUserId() {
		return _tactic.getUserId();
	}

	/**
	* Returns the user name of this tactic.
	*
	* @return the user name of this tactic
	*/
	@Override
	public java.lang.String getUserName() {
		return _tactic.getUserName();
	}

	/**
	* Returns the user uuid of this tactic.
	*
	* @return the user uuid of this tactic
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _tactic.getUserUuid();
	}

	/**
	* Returns the uuid of this tactic.
	*
	* @return the uuid of this tactic
	*/
	@Override
	public java.lang.String getUuid() {
		return _tactic.getUuid();
	}

	@Override
	public int hashCode() {
		return _tactic.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _tactic.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tactic.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tactic.isNew();
	}

	@Override
	public void persist() {
		_tactic.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_tactic.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_tactic.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tactic.setCachedModel(cachedModel);
	}

	/**
	* Sets the campaign ID of this tactic.
	*
	* @param campaignId the campaign ID of this tactic
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_tactic.setCampaignId(campaignId);
	}

	/**
	* Sets the company ID of this tactic.
	*
	* @param companyId the company ID of this tactic
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tactic.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this tactic.
	*
	* @param createDate the create date of this tactic
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_tactic.setCreateDate(createDate);
	}

	/**
	* Sets the description of this tactic.
	*
	* @param description the description of this tactic
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_tactic.setDescription(description);
	}

	/**
	* Sets the localized description of this tactic in the language.
	*
	* @param description the localized description of this tactic
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_tactic.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this tactic in the language, and sets the default locale.
	*
	* @param description the localized description of this tactic
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_tactic.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_tactic.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this tactic from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this tactic
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap) {
		_tactic.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this tactic from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this tactic
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_tactic.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tactic.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tactic.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tactic.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this tactic.
	*
	* @param groupId the group ID of this tactic
	*/
	@Override
	public void setGroupId(long groupId) {
		_tactic.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this tactic.
	*
	* @param modifiedDate the modified date of this tactic
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_tactic.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this tactic.
	*
	* @param name the name of this tactic
	*/
	@Override
	public void setName(java.lang.String name) {
		_tactic.setName(name);
	}

	/**
	* Sets the localized name of this tactic in the language.
	*
	* @param name the localized name of this tactic
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_tactic.setName(name, locale);
	}

	/**
	* Sets the localized name of this tactic in the language, and sets the default locale.
	*
	* @param name the localized name of this tactic
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_tactic.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_tactic.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this tactic from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this tactic
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap) {
		_tactic.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this tactic from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this tactic
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_tactic.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_tactic.setNew(n);
	}

	/**
	* Sets the primary key of this tactic.
	*
	* @param primaryKey the primary key of this tactic
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tactic.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tactic.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tactic ID of this tactic.
	*
	* @param tacticId the tactic ID of this tactic
	*/
	@Override
	public void setTacticId(long tacticId) {
		_tactic.setTacticId(tacticId);
	}

	/**
	* Sets the user ID of this tactic.
	*
	* @param userId the user ID of this tactic
	*/
	@Override
	public void setUserId(long userId) {
		_tactic.setUserId(userId);
	}

	/**
	* Sets the user name of this tactic.
	*
	* @param userName the user name of this tactic
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tactic.setUserName(userName);
	}

	/**
	* Sets the user uuid of this tactic.
	*
	* @param userUuid the user uuid of this tactic
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tactic.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this tactic.
	*
	* @param uuid the uuid of this tactic
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_tactic.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.model.Tactic> toCacheModel() {
		return _tactic.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.model.Tactic toEscapedModel() {
		return new TacticWrapper(_tactic.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tactic.toString();
	}

	@Override
	public com.liferay.content.targeting.model.Tactic toUnescapedModel() {
		return new TacticWrapper(_tactic.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _tactic.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TacticWrapper)) {
			return false;
		}

		TacticWrapper tacticWrapper = (TacticWrapper)obj;

		if (Validator.equals(_tactic, tacticWrapper._tactic)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _tactic.getStagedModelType();
	}

	@Override
	public Tactic getWrappedModel() {
		return _tactic;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tactic.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tactic.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tactic.resetOriginalValues();
	}

	private final Tactic _tactic;
}