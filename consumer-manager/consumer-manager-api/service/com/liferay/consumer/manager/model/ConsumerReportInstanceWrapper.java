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

package com.liferay.consumer.manager.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ConsumerReportInstance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerReportInstance
 * @generated
 */
public class ConsumerReportInstanceWrapper implements ConsumerReportInstance,
	ModelWrapper<ConsumerReportInstance> {
	public ConsumerReportInstanceWrapper(
		ConsumerReportInstance consumerReportInstance) {
		_consumerReportInstance = consumerReportInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return ConsumerReportInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ConsumerReportInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("consumerReportInstanceId", getConsumerReportInstanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("consumerId", getConsumerId());
		attributes.put("reportCategoryKey", getReportCategoryKey());
		attributes.put("reportKey", getReportKey());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long consumerReportInstanceId = (Long)attributes.get(
				"consumerReportInstanceId");

		if (consumerReportInstanceId != null) {
			setConsumerReportInstanceId(consumerReportInstanceId);
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

		Long consumerId = (Long)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
		}

		String reportCategoryKey = (String)attributes.get("reportCategoryKey");

		if (reportCategoryKey != null) {
			setReportCategoryKey(reportCategoryKey);
		}

		String reportKey = (String)attributes.get("reportKey");

		if (reportKey != null) {
			setReportKey(reportKey);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	/**
	* Returns the primary key of this consumer report instance.
	*
	* @return the primary key of this consumer report instance
	*/
	@Override
	public long getPrimaryKey() {
		return _consumerReportInstance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this consumer report instance.
	*
	* @param primaryKey the primary key of this consumer report instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_consumerReportInstance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this consumer report instance.
	*
	* @return the uuid of this consumer report instance
	*/
	@Override
	public java.lang.String getUuid() {
		return _consumerReportInstance.getUuid();
	}

	/**
	* Sets the uuid of this consumer report instance.
	*
	* @param uuid the uuid of this consumer report instance
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_consumerReportInstance.setUuid(uuid);
	}

	/**
	* Returns the consumer report instance ID of this consumer report instance.
	*
	* @return the consumer report instance ID of this consumer report instance
	*/
	@Override
	public long getConsumerReportInstanceId() {
		return _consumerReportInstance.getConsumerReportInstanceId();
	}

	/**
	* Sets the consumer report instance ID of this consumer report instance.
	*
	* @param consumerReportInstanceId the consumer report instance ID of this consumer report instance
	*/
	@Override
	public void setConsumerReportInstanceId(long consumerReportInstanceId) {
		_consumerReportInstance.setConsumerReportInstanceId(consumerReportInstanceId);
	}

	/**
	* Returns the company ID of this consumer report instance.
	*
	* @return the company ID of this consumer report instance
	*/
	@Override
	public long getCompanyId() {
		return _consumerReportInstance.getCompanyId();
	}

	/**
	* Sets the company ID of this consumer report instance.
	*
	* @param companyId the company ID of this consumer report instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_consumerReportInstance.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this consumer report instance.
	*
	* @return the user ID of this consumer report instance
	*/
	@Override
	public long getUserId() {
		return _consumerReportInstance.getUserId();
	}

	/**
	* Sets the user ID of this consumer report instance.
	*
	* @param userId the user ID of this consumer report instance
	*/
	@Override
	public void setUserId(long userId) {
		_consumerReportInstance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this consumer report instance.
	*
	* @return the user uuid of this consumer report instance
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerReportInstance.getUserUuid();
	}

	/**
	* Sets the user uuid of this consumer report instance.
	*
	* @param userUuid the user uuid of this consumer report instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_consumerReportInstance.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this consumer report instance.
	*
	* @return the user name of this consumer report instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _consumerReportInstance.getUserName();
	}

	/**
	* Sets the user name of this consumer report instance.
	*
	* @param userName the user name of this consumer report instance
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_consumerReportInstance.setUserName(userName);
	}

	/**
	* Returns the create date of this consumer report instance.
	*
	* @return the create date of this consumer report instance
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _consumerReportInstance.getCreateDate();
	}

	/**
	* Sets the create date of this consumer report instance.
	*
	* @param createDate the create date of this consumer report instance
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_consumerReportInstance.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this consumer report instance.
	*
	* @return the modified date of this consumer report instance
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _consumerReportInstance.getModifiedDate();
	}

	/**
	* Sets the modified date of this consumer report instance.
	*
	* @param modifiedDate the modified date of this consumer report instance
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_consumerReportInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the consumer ID of this consumer report instance.
	*
	* @return the consumer ID of this consumer report instance
	*/
	@Override
	public long getConsumerId() {
		return _consumerReportInstance.getConsumerId();
	}

	/**
	* Sets the consumer ID of this consumer report instance.
	*
	* @param consumerId the consumer ID of this consumer report instance
	*/
	@Override
	public void setConsumerId(long consumerId) {
		_consumerReportInstance.setConsumerId(consumerId);
	}

	/**
	* Returns the report category key of this consumer report instance.
	*
	* @return the report category key of this consumer report instance
	*/
	@Override
	public java.lang.String getReportCategoryKey() {
		return _consumerReportInstance.getReportCategoryKey();
	}

	/**
	* Sets the report category key of this consumer report instance.
	*
	* @param reportCategoryKey the report category key of this consumer report instance
	*/
	@Override
	public void setReportCategoryKey(java.lang.String reportCategoryKey) {
		_consumerReportInstance.setReportCategoryKey(reportCategoryKey);
	}

	/**
	* Returns the report key of this consumer report instance.
	*
	* @return the report key of this consumer report instance
	*/
	@Override
	public java.lang.String getReportKey() {
		return _consumerReportInstance.getReportKey();
	}

	/**
	* Sets the report key of this consumer report instance.
	*
	* @param reportKey the report key of this consumer report instance
	*/
	@Override
	public void setReportKey(java.lang.String reportKey) {
		_consumerReportInstance.setReportKey(reportKey);
	}

	/**
	* Returns the name of this consumer report instance.
	*
	* @return the name of this consumer report instance
	*/
	@Override
	public java.lang.String getName() {
		return _consumerReportInstance.getName();
	}

	/**
	* Returns the localized name of this consumer report instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this consumer report instance
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _consumerReportInstance.getName(locale);
	}

	/**
	* Returns the localized name of this consumer report instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this consumer report instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _consumerReportInstance.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this consumer report instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this consumer report instance
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _consumerReportInstance.getName(languageId);
	}

	/**
	* Returns the localized name of this consumer report instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this consumer report instance
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _consumerReportInstance.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _consumerReportInstance.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _consumerReportInstance.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this consumer report instance.
	*
	* @return the locales and localized names of this consumer report instance
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _consumerReportInstance.getNameMap();
	}

	/**
	* Sets the name of this consumer report instance.
	*
	* @param name the name of this consumer report instance
	*/
	@Override
	public void setName(java.lang.String name) {
		_consumerReportInstance.setName(name);
	}

	/**
	* Sets the localized name of this consumer report instance in the language.
	*
	* @param name the localized name of this consumer report instance
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_consumerReportInstance.setName(name, locale);
	}

	/**
	* Sets the localized name of this consumer report instance in the language, and sets the default locale.
	*
	* @param name the localized name of this consumer report instance
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_consumerReportInstance.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_consumerReportInstance.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this consumer report instance from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this consumer report instance
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_consumerReportInstance.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this consumer report instance from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this consumer report instance
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_consumerReportInstance.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the description of this consumer report instance.
	*
	* @return the description of this consumer report instance
	*/
	@Override
	public java.lang.String getDescription() {
		return _consumerReportInstance.getDescription();
	}

	/**
	* Returns the localized description of this consumer report instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this consumer report instance
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _consumerReportInstance.getDescription(locale);
	}

	/**
	* Returns the localized description of this consumer report instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this consumer report instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _consumerReportInstance.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this consumer report instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this consumer report instance
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _consumerReportInstance.getDescription(languageId);
	}

	/**
	* Returns the localized description of this consumer report instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this consumer report instance
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _consumerReportInstance.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _consumerReportInstance.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _consumerReportInstance.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this consumer report instance.
	*
	* @return the locales and localized descriptions of this consumer report instance
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _consumerReportInstance.getDescriptionMap();
	}

	/**
	* Sets the description of this consumer report instance.
	*
	* @param description the description of this consumer report instance
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_consumerReportInstance.setDescription(description);
	}

	/**
	* Sets the localized description of this consumer report instance in the language.
	*
	* @param description the localized description of this consumer report instance
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_consumerReportInstance.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this consumer report instance in the language, and sets the default locale.
	*
	* @param description the localized description of this consumer report instance
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_consumerReportInstance.setDescription(description, locale,
			defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_consumerReportInstance.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this consumer report instance from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this consumer report instance
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_consumerReportInstance.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this consumer report instance from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this consumer report instance
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_consumerReportInstance.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Returns the type settings of this consumer report instance.
	*
	* @return the type settings of this consumer report instance
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _consumerReportInstance.getTypeSettings();
	}

	/**
	* Sets the type settings of this consumer report instance.
	*
	* @param typeSettings the type settings of this consumer report instance
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_consumerReportInstance.setTypeSettings(typeSettings);
	}

	@Override
	public boolean isNew() {
		return _consumerReportInstance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_consumerReportInstance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _consumerReportInstance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_consumerReportInstance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _consumerReportInstance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _consumerReportInstance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_consumerReportInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _consumerReportInstance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_consumerReportInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_consumerReportInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_consumerReportInstance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _consumerReportInstance.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _consumerReportInstance.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_consumerReportInstance.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_consumerReportInstance.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new ConsumerReportInstanceWrapper((ConsumerReportInstance)_consumerReportInstance.clone());
	}

	@Override
	public int compareTo(
		com.liferay.consumer.manager.model.ConsumerReportInstance consumerReportInstance) {
		return _consumerReportInstance.compareTo(consumerReportInstance);
	}

	@Override
	public int hashCode() {
		return _consumerReportInstance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.consumer.manager.model.ConsumerReportInstance> toCacheModel() {
		return _consumerReportInstance.toCacheModel();
	}

	@Override
	public com.liferay.consumer.manager.model.ConsumerReportInstance toEscapedModel() {
		return new ConsumerReportInstanceWrapper(_consumerReportInstance.toEscapedModel());
	}

	@Override
	public com.liferay.consumer.manager.model.ConsumerReportInstance toUnescapedModel() {
		return new ConsumerReportInstanceWrapper(_consumerReportInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _consumerReportInstance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _consumerReportInstance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_consumerReportInstance.persist();
	}

	@Override
	public boolean isInstantiable() {
		return _consumerReportInstance.isInstantiable();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConsumerReportInstanceWrapper)) {
			return false;
		}

		ConsumerReportInstanceWrapper consumerReportInstanceWrapper = (ConsumerReportInstanceWrapper)obj;

		if (Validator.equals(_consumerReportInstance,
					consumerReportInstanceWrapper._consumerReportInstance)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _consumerReportInstance.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ConsumerReportInstance getWrappedConsumerReportInstance() {
		return _consumerReportInstance;
	}

	@Override
	public ConsumerReportInstance getWrappedModel() {
		return _consumerReportInstance;
	}

	@Override
	public void resetOriginalValues() {
		_consumerReportInstance.resetOriginalValues();
	}

	private ConsumerReportInstance _consumerReportInstance;
}