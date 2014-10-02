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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Campaign}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Campaign
 * @generated
 */
public class CampaignWrapper implements Campaign, ModelWrapper<Campaign> {
	public CampaignWrapper(Campaign campaign) {
		_campaign = campaign;
	}

	@Override
	public Class<?> getModelClass() {
		return Campaign.class;
	}

	@Override
	public String getModelClassName() {
		return Campaign.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("campaignId", getCampaignId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("priority", getPriority());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this campaign.
	*
	* @return the primary key of this campaign
	*/
	@Override
	public long getPrimaryKey() {
		return _campaign.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign.
	*
	* @param primaryKey the primary key of this campaign
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaign.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this campaign.
	*
	* @return the uuid of this campaign
	*/
	@Override
	public java.lang.String getUuid() {
		return _campaign.getUuid();
	}

	/**
	* Sets the uuid of this campaign.
	*
	* @param uuid the uuid of this campaign
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_campaign.setUuid(uuid);
	}

	/**
	* Returns the campaign ID of this campaign.
	*
	* @return the campaign ID of this campaign
	*/
	@Override
	public long getCampaignId() {
		return _campaign.getCampaignId();
	}

	/**
	* Sets the campaign ID of this campaign.
	*
	* @param campaignId the campaign ID of this campaign
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_campaign.setCampaignId(campaignId);
	}

	/**
	* Returns the group ID of this campaign.
	*
	* @return the group ID of this campaign
	*/
	@Override
	public long getGroupId() {
		return _campaign.getGroupId();
	}

	/**
	* Sets the group ID of this campaign.
	*
	* @param groupId the group ID of this campaign
	*/
	@Override
	public void setGroupId(long groupId) {
		_campaign.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this campaign.
	*
	* @return the company ID of this campaign
	*/
	@Override
	public long getCompanyId() {
		return _campaign.getCompanyId();
	}

	/**
	* Sets the company ID of this campaign.
	*
	* @param companyId the company ID of this campaign
	*/
	@Override
	public void setCompanyId(long companyId) {
		_campaign.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this campaign.
	*
	* @return the user ID of this campaign
	*/
	@Override
	public long getUserId() {
		return _campaign.getUserId();
	}

	/**
	* Sets the user ID of this campaign.
	*
	* @param userId the user ID of this campaign
	*/
	@Override
	public void setUserId(long userId) {
		_campaign.setUserId(userId);
	}

	/**
	* Returns the user uuid of this campaign.
	*
	* @return the user uuid of this campaign
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaign.getUserUuid();
	}

	/**
	* Sets the user uuid of this campaign.
	*
	* @param userUuid the user uuid of this campaign
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_campaign.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this campaign.
	*
	* @return the user name of this campaign
	*/
	@Override
	public java.lang.String getUserName() {
		return _campaign.getUserName();
	}

	/**
	* Sets the user name of this campaign.
	*
	* @param userName the user name of this campaign
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_campaign.setUserName(userName);
	}

	/**
	* Returns the create date of this campaign.
	*
	* @return the create date of this campaign
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _campaign.getCreateDate();
	}

	/**
	* Sets the create date of this campaign.
	*
	* @param createDate the create date of this campaign
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_campaign.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this campaign.
	*
	* @return the modified date of this campaign
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _campaign.getModifiedDate();
	}

	/**
	* Sets the modified date of this campaign.
	*
	* @param modifiedDate the modified date of this campaign
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_campaign.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this campaign.
	*
	* @return the name of this campaign
	*/
	@Override
	public java.lang.String getName() {
		return _campaign.getName();
	}

	/**
	* Returns the localized name of this campaign in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this campaign
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _campaign.getName(locale);
	}

	/**
	* Returns the localized name of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this campaign. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _campaign.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this campaign in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this campaign
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _campaign.getName(languageId);
	}

	/**
	* Returns the localized name of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this campaign
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _campaign.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _campaign.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _campaign.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this campaign.
	*
	* @return the locales and localized names of this campaign
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _campaign.getNameMap();
	}

	/**
	* Sets the name of this campaign.
	*
	* @param name the name of this campaign
	*/
	@Override
	public void setName(java.lang.String name) {
		_campaign.setName(name);
	}

	/**
	* Sets the localized name of this campaign in the language.
	*
	* @param name the localized name of this campaign
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_campaign.setName(name, locale);
	}

	/**
	* Sets the localized name of this campaign in the language, and sets the default locale.
	*
	* @param name the localized name of this campaign
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_campaign.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_campaign.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this campaign from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this campaign
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_campaign.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this campaign from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this campaign
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_campaign.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the description of this campaign.
	*
	* @return the description of this campaign
	*/
	@Override
	public java.lang.String getDescription() {
		return _campaign.getDescription();
	}

	/**
	* Returns the localized description of this campaign in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this campaign
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _campaign.getDescription(locale);
	}

	/**
	* Returns the localized description of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this campaign. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _campaign.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this campaign in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this campaign
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _campaign.getDescription(languageId);
	}

	/**
	* Returns the localized description of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this campaign
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _campaign.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _campaign.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _campaign.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this campaign.
	*
	* @return the locales and localized descriptions of this campaign
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _campaign.getDescriptionMap();
	}

	/**
	* Sets the description of this campaign.
	*
	* @param description the description of this campaign
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_campaign.setDescription(description);
	}

	/**
	* Sets the localized description of this campaign in the language.
	*
	* @param description the localized description of this campaign
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_campaign.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this campaign in the language, and sets the default locale.
	*
	* @param description the localized description of this campaign
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_campaign.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_campaign.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this campaign from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this campaign
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_campaign.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this campaign from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this campaign
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_campaign.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Returns the start date of this campaign.
	*
	* @return the start date of this campaign
	*/
	@Override
	public java.util.Date getStartDate() {
		return _campaign.getStartDate();
	}

	/**
	* Sets the start date of this campaign.
	*
	* @param startDate the start date of this campaign
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_campaign.setStartDate(startDate);
	}

	/**
	* Returns the end date of this campaign.
	*
	* @return the end date of this campaign
	*/
	@Override
	public java.util.Date getEndDate() {
		return _campaign.getEndDate();
	}

	/**
	* Sets the end date of this campaign.
	*
	* @param endDate the end date of this campaign
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_campaign.setEndDate(endDate);
	}

	/**
	* Returns the priority of this campaign.
	*
	* @return the priority of this campaign
	*/
	@Override
	public int getPriority() {
		return _campaign.getPriority();
	}

	/**
	* Sets the priority of this campaign.
	*
	* @param priority the priority of this campaign
	*/
	@Override
	public void setPriority(int priority) {
		_campaign.setPriority(priority);
	}

	/**
	* Returns the active of this campaign.
	*
	* @return the active of this campaign
	*/
	@Override
	public boolean getActive() {
		return _campaign.getActive();
	}

	/**
	* Returns <code>true</code> if this campaign is active.
	*
	* @return <code>true</code> if this campaign is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _campaign.isActive();
	}

	/**
	* Sets whether this campaign is active.
	*
	* @param active the active of this campaign
	*/
	@Override
	public void setActive(boolean active) {
		_campaign.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _campaign.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_campaign.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _campaign.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaign.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _campaign.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _campaign.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaign.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaign.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_campaign.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_campaign.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaign.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _campaign.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _campaign.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_campaign.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_campaign.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignWrapper((Campaign)_campaign.clone());
	}

	@Override
	public int compareTo(Campaign campaign) {
		return _campaign.compareTo(campaign);
	}

	@Override
	public int hashCode() {
		return _campaign.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Campaign> toCacheModel() {
		return _campaign.toCacheModel();
	}

	@Override
	public Campaign toEscapedModel() {
		return new CampaignWrapper(_campaign.toEscapedModel());
	}

	@Override
	public Campaign toUnescapedModel() {
		return new CampaignWrapper(_campaign.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaign.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaign.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaign.persist();
	}

	@Override
	public java.lang.String getNameWithGroupName(java.util.Locale locale,
		long groupId) {
		return _campaign.getNameWithGroupName(locale, groupId);
	}

	@Override
	public java.lang.String getStatus() {
		return _campaign.getStatus();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignWrapper)) {
			return false;
		}

		CampaignWrapper campaignWrapper = (CampaignWrapper)obj;

		if (Validator.equals(_campaign, campaignWrapper._campaign)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _campaign.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Campaign getWrappedCampaign() {
		return _campaign;
	}

	@Override
	public Campaign getWrappedModel() {
		return _campaign;
	}

	@Override
	public void resetOriginalValues() {
		_campaign.resetOriginalValues();
	}

	private Campaign _campaign;
}