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
 * This class is a wrapper for {@link Consumer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Consumer
 * @generated
 */
public class ConsumerWrapper implements Consumer, ModelWrapper<Consumer> {
	public ConsumerWrapper(Consumer consumer) {
		_consumer = consumer;
	}

	@Override
	public Class<?> getModelClass() {
		return Consumer.class;
	}

	@Override
	public String getModelClassName() {
		return Consumer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("consumerId", getConsumerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("consumerKey", getConsumerKey());
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

		Long consumerId = (Long)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
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

		String consumerKey = (String)attributes.get("consumerKey");

		if (consumerKey != null) {
			setConsumerKey(consumerKey);
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

	/**
	* Returns the primary key of this consumer.
	*
	* @return the primary key of this consumer
	*/
	@Override
	public long getPrimaryKey() {
		return _consumer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this consumer.
	*
	* @param primaryKey the primary key of this consumer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_consumer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this consumer.
	*
	* @return the uuid of this consumer
	*/
	@Override
	public java.lang.String getUuid() {
		return _consumer.getUuid();
	}

	/**
	* Sets the uuid of this consumer.
	*
	* @param uuid the uuid of this consumer
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_consumer.setUuid(uuid);
	}

	/**
	* Returns the consumer ID of this consumer.
	*
	* @return the consumer ID of this consumer
	*/
	@Override
	public long getConsumerId() {
		return _consumer.getConsumerId();
	}

	/**
	* Sets the consumer ID of this consumer.
	*
	* @param consumerId the consumer ID of this consumer
	*/
	@Override
	public void setConsumerId(long consumerId) {
		_consumer.setConsumerId(consumerId);
	}

	/**
	* Returns the company ID of this consumer.
	*
	* @return the company ID of this consumer
	*/
	@Override
	public long getCompanyId() {
		return _consumer.getCompanyId();
	}

	/**
	* Sets the company ID of this consumer.
	*
	* @param companyId the company ID of this consumer
	*/
	@Override
	public void setCompanyId(long companyId) {
		_consumer.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this consumer.
	*
	* @return the user ID of this consumer
	*/
	@Override
	public long getUserId() {
		return _consumer.getUserId();
	}

	/**
	* Sets the user ID of this consumer.
	*
	* @param userId the user ID of this consumer
	*/
	@Override
	public void setUserId(long userId) {
		_consumer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this consumer.
	*
	* @return the user uuid of this consumer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumer.getUserUuid();
	}

	/**
	* Sets the user uuid of this consumer.
	*
	* @param userUuid the user uuid of this consumer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_consumer.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this consumer.
	*
	* @return the user name of this consumer
	*/
	@Override
	public java.lang.String getUserName() {
		return _consumer.getUserName();
	}

	/**
	* Sets the user name of this consumer.
	*
	* @param userName the user name of this consumer
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_consumer.setUserName(userName);
	}

	/**
	* Returns the create date of this consumer.
	*
	* @return the create date of this consumer
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _consumer.getCreateDate();
	}

	/**
	* Sets the create date of this consumer.
	*
	* @param createDate the create date of this consumer
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_consumer.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this consumer.
	*
	* @return the modified date of this consumer
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _consumer.getModifiedDate();
	}

	/**
	* Sets the modified date of this consumer.
	*
	* @param modifiedDate the modified date of this consumer
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_consumer.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the consumer key of this consumer.
	*
	* @return the consumer key of this consumer
	*/
	@Override
	public java.lang.String getConsumerKey() {
		return _consumer.getConsumerKey();
	}

	/**
	* Sets the consumer key of this consumer.
	*
	* @param consumerKey the consumer key of this consumer
	*/
	@Override
	public void setConsumerKey(java.lang.String consumerKey) {
		_consumer.setConsumerKey(consumerKey);
	}

	/**
	* Returns the name of this consumer.
	*
	* @return the name of this consumer
	*/
	@Override
	public java.lang.String getName() {
		return _consumer.getName();
	}

	/**
	* Returns the localized name of this consumer in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this consumer
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _consumer.getName(locale);
	}

	/**
	* Returns the localized name of this consumer in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this consumer. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _consumer.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this consumer in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this consumer
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _consumer.getName(languageId);
	}

	/**
	* Returns the localized name of this consumer in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this consumer
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _consumer.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _consumer.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _consumer.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this consumer.
	*
	* @return the locales and localized names of this consumer
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _consumer.getNameMap();
	}

	/**
	* Sets the name of this consumer.
	*
	* @param name the name of this consumer
	*/
	@Override
	public void setName(java.lang.String name) {
		_consumer.setName(name);
	}

	/**
	* Sets the localized name of this consumer in the language.
	*
	* @param name the localized name of this consumer
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_consumer.setName(name, locale);
	}

	/**
	* Sets the localized name of this consumer in the language, and sets the default locale.
	*
	* @param name the localized name of this consumer
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_consumer.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_consumer.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this consumer from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this consumer
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_consumer.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this consumer from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this consumer
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_consumer.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the description of this consumer.
	*
	* @return the description of this consumer
	*/
	@Override
	public java.lang.String getDescription() {
		return _consumer.getDescription();
	}

	/**
	* Returns the localized description of this consumer in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this consumer
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _consumer.getDescription(locale);
	}

	/**
	* Returns the localized description of this consumer in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this consumer. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _consumer.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this consumer in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this consumer
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _consumer.getDescription(languageId);
	}

	/**
	* Returns the localized description of this consumer in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this consumer
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _consumer.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _consumer.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _consumer.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this consumer.
	*
	* @return the locales and localized descriptions of this consumer
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _consumer.getDescriptionMap();
	}

	/**
	* Sets the description of this consumer.
	*
	* @param description the description of this consumer
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_consumer.setDescription(description);
	}

	/**
	* Sets the localized description of this consumer in the language.
	*
	* @param description the localized description of this consumer
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_consumer.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this consumer in the language, and sets the default locale.
	*
	* @param description the localized description of this consumer
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_consumer.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_consumer.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this consumer from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this consumer
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_consumer.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this consumer from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this consumer
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_consumer.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public boolean isNew() {
		return _consumer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_consumer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _consumer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_consumer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _consumer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _consumer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_consumer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _consumer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_consumer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_consumer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_consumer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _consumer.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _consumer.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_consumer.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_consumer.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new ConsumerWrapper((Consumer)_consumer.clone());
	}

	@Override
	public int compareTo(com.liferay.consumer.manager.model.Consumer consumer) {
		return _consumer.compareTo(consumer);
	}

	@Override
	public int hashCode() {
		return _consumer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.consumer.manager.model.Consumer> toCacheModel() {
		return _consumer.toCacheModel();
	}

	@Override
	public com.liferay.consumer.manager.model.Consumer toEscapedModel() {
		return new ConsumerWrapper(_consumer.toEscapedModel());
	}

	@Override
	public com.liferay.consumer.manager.model.Consumer toUnescapedModel() {
		return new ConsumerWrapper(_consumer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _consumer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _consumer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_consumer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConsumerWrapper)) {
			return false;
		}

		ConsumerWrapper consumerWrapper = (ConsumerWrapper)obj;

		if (Validator.equals(_consumer, consumerWrapper._consumer)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _consumer.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Consumer getWrappedConsumer() {
		return _consumer;
	}

	@Override
	public Consumer getWrappedModel() {
		return _consumer;
	}

	@Override
	public void resetOriginalValues() {
		_consumer.resetOriginalValues();
	}

	private Consumer _consumer;
}