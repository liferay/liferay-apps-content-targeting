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
 * This class is a wrapper for {@link ReportInstance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstance
 * @generated
 */
@ProviderType
public class ReportInstanceWrapper implements ReportInstance,
	ModelWrapper<ReportInstance> {
	public ReportInstanceWrapper(ReportInstance reportInstance) {
		_reportInstance = reportInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return ReportInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ReportInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("reportInstanceId", getReportInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("reportKey", getReportKey());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long reportInstanceId = (Long)attributes.get("reportInstanceId");

		if (reportInstanceId != null) {
			setReportInstanceId(reportInstanceId);
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

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new ReportInstanceWrapper((ReportInstance)_reportInstance.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.model.ReportInstance reportInstance) {
		return _reportInstance.compareTo(reportInstance);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _reportInstance.getAvailableLanguageIds();
	}

	/**
	* Returns the class name of this report instance.
	*
	* @return the class name of this report instance
	*/
	@Override
	public java.lang.String getClassName() {
		return _reportInstance.getClassName();
	}

	/**
	* Returns the class p k of this report instance.
	*
	* @return the class p k of this report instance
	*/
	@Override
	public long getClassPK() {
		return _reportInstance.getClassPK();
	}

	/**
	* Returns the company ID of this report instance.
	*
	* @return the company ID of this report instance
	*/
	@Override
	public long getCompanyId() {
		return _reportInstance.getCompanyId();
	}

	/**
	* Returns the create date of this report instance.
	*
	* @return the create date of this report instance
	*/
	@Override
	public Date getCreateDate() {
		return _reportInstance.getCreateDate();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _reportInstance.getDefaultLanguageId();
	}

	/**
	* Returns the description of this report instance.
	*
	* @return the description of this report instance
	*/
	@Override
	public java.lang.String getDescription() {
		return _reportInstance.getDescription();
	}

	/**
	* Returns the localized description of this report instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this report instance
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _reportInstance.getDescription(languageId);
	}

	/**
	* Returns the localized description of this report instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this report instance
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _reportInstance.getDescription(languageId, useDefault);
	}

	/**
	* Returns the localized description of this report instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this report instance
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _reportInstance.getDescription(locale);
	}

	/**
	* Returns the localized description of this report instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this report instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _reportInstance.getDescription(locale, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _reportInstance.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _reportInstance.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this report instance.
	*
	* @return the locales and localized descriptions of this report instance
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _reportInstance.getDescriptionMap();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _reportInstance.getExpandoBridge();
	}

	/**
	* Returns the group ID of this report instance.
	*
	* @return the group ID of this report instance
	*/
	@Override
	public long getGroupId() {
		return _reportInstance.getGroupId();
	}

	/**
	* Returns the modified date of this report instance.
	*
	* @return the modified date of this report instance
	*/
	@Override
	public Date getModifiedDate() {
		return _reportInstance.getModifiedDate();
	}

	/**
	* Returns the name of this report instance.
	*
	* @return the name of this report instance
	*/
	@Override
	public java.lang.String getName() {
		return _reportInstance.getName();
	}

	/**
	* Returns the localized name of this report instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this report instance
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _reportInstance.getName(languageId);
	}

	/**
	* Returns the localized name of this report instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this report instance
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _reportInstance.getName(languageId, useDefault);
	}

	/**
	* Returns the localized name of this report instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this report instance
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _reportInstance.getName(locale);
	}

	/**
	* Returns the localized name of this report instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this report instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _reportInstance.getName(locale, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _reportInstance.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _reportInstance.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this report instance.
	*
	* @return the locales and localized names of this report instance
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getNameMap() {
		return _reportInstance.getNameMap();
	}

	/**
	* Returns the primary key of this report instance.
	*
	* @return the primary key of this report instance
	*/
	@Override
	public long getPrimaryKey() {
		return _reportInstance.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reportInstance.getPrimaryKeyObj();
	}

	/**
	* Returns the report instance ID of this report instance.
	*
	* @return the report instance ID of this report instance
	*/
	@Override
	public long getReportInstanceId() {
		return _reportInstance.getReportInstanceId();
	}

	/**
	* Returns the report key of this report instance.
	*
	* @return the report key of this report instance
	*/
	@Override
	public java.lang.String getReportKey() {
		return _reportInstance.getReportKey();
	}

	@Override
	public java.lang.String getReportName(java.util.Locale locale) {
		return _reportInstance.getReportName(locale);
	}

	@Override
	public java.lang.String getTypeName(java.util.Locale locale) {
		return _reportInstance.getTypeName(locale);
	}

	/**
	* Returns the type settings of this report instance.
	*
	* @return the type settings of this report instance
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _reportInstance.getTypeSettings();
	}

	/**
	* Returns the user ID of this report instance.
	*
	* @return the user ID of this report instance
	*/
	@Override
	public long getUserId() {
		return _reportInstance.getUserId();
	}

	/**
	* Returns the user name of this report instance.
	*
	* @return the user name of this report instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _reportInstance.getUserName();
	}

	/**
	* Returns the user uuid of this report instance.
	*
	* @return the user uuid of this report instance
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _reportInstance.getUserUuid();
	}

	/**
	* Returns the uuid of this report instance.
	*
	* @return the uuid of this report instance
	*/
	@Override
	public java.lang.String getUuid() {
		return _reportInstance.getUuid();
	}

	@Override
	public int hashCode() {
		return _reportInstance.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _reportInstance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _reportInstance.isEscapedModel();
	}

	@Override
	public boolean isInstantiable() {
		return _reportInstance.isInstantiable();
	}

	@Override
	public boolean isNew() {
		return _reportInstance.isNew();
	}

	@Override
	public void persist() {
		_reportInstance.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_reportInstance.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_reportInstance.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_reportInstance.setCachedModel(cachedModel);
	}

	/**
	* Sets the class name of this report instance.
	*
	* @param className the class name of this report instance
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_reportInstance.setClassName(className);
	}

	/**
	* Sets the class p k of this report instance.
	*
	* @param classPK the class p k of this report instance
	*/
	@Override
	public void setClassPK(long classPK) {
		_reportInstance.setClassPK(classPK);
	}

	/**
	* Sets the company ID of this report instance.
	*
	* @param companyId the company ID of this report instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_reportInstance.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this report instance.
	*
	* @param createDate the create date of this report instance
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_reportInstance.setCreateDate(createDate);
	}

	/**
	* Sets the description of this report instance.
	*
	* @param description the description of this report instance
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_reportInstance.setDescription(description);
	}

	/**
	* Sets the localized description of this report instance in the language.
	*
	* @param description the localized description of this report instance
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_reportInstance.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this report instance in the language, and sets the default locale.
	*
	* @param description the localized description of this report instance
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_reportInstance.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_reportInstance.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this report instance from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this report instance
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap) {
		_reportInstance.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this report instance from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this report instance
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_reportInstance.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_reportInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_reportInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_reportInstance.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this report instance.
	*
	* @param groupId the group ID of this report instance
	*/
	@Override
	public void setGroupId(long groupId) {
		_reportInstance.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this report instance.
	*
	* @param modifiedDate the modified date of this report instance
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_reportInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this report instance.
	*
	* @param name the name of this report instance
	*/
	@Override
	public void setName(java.lang.String name) {
		_reportInstance.setName(name);
	}

	/**
	* Sets the localized name of this report instance in the language.
	*
	* @param name the localized name of this report instance
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_reportInstance.setName(name, locale);
	}

	/**
	* Sets the localized name of this report instance in the language, and sets the default locale.
	*
	* @param name the localized name of this report instance
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_reportInstance.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_reportInstance.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this report instance from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this report instance
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap) {
		_reportInstance.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this report instance from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this report instance
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_reportInstance.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_reportInstance.setNew(n);
	}

	/**
	* Sets the primary key of this report instance.
	*
	* @param primaryKey the primary key of this report instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_reportInstance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_reportInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the report instance ID of this report instance.
	*
	* @param reportInstanceId the report instance ID of this report instance
	*/
	@Override
	public void setReportInstanceId(long reportInstanceId) {
		_reportInstance.setReportInstanceId(reportInstanceId);
	}

	/**
	* Sets the report key of this report instance.
	*
	* @param reportKey the report key of this report instance
	*/
	@Override
	public void setReportKey(java.lang.String reportKey) {
		_reportInstance.setReportKey(reportKey);
	}

	/**
	* Sets the type settings of this report instance.
	*
	* @param typeSettings the type settings of this report instance
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_reportInstance.setTypeSettings(typeSettings);
	}

	/**
	* Sets the user ID of this report instance.
	*
	* @param userId the user ID of this report instance
	*/
	@Override
	public void setUserId(long userId) {
		_reportInstance.setUserId(userId);
	}

	/**
	* Sets the user name of this report instance.
	*
	* @param userName the user name of this report instance
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_reportInstance.setUserName(userName);
	}

	/**
	* Sets the user uuid of this report instance.
	*
	* @param userUuid the user uuid of this report instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_reportInstance.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this report instance.
	*
	* @param uuid the uuid of this report instance
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_reportInstance.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.model.ReportInstance> toCacheModel() {
		return _reportInstance.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance toEscapedModel() {
		return new ReportInstanceWrapper(_reportInstance.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _reportInstance.toString();
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance toUnescapedModel() {
		return new ReportInstanceWrapper(_reportInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _reportInstance.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReportInstanceWrapper)) {
			return false;
		}

		ReportInstanceWrapper reportInstanceWrapper = (ReportInstanceWrapper)obj;

		if (Validator.equals(_reportInstance,
					reportInstanceWrapper._reportInstance)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _reportInstance.getStagedModelType();
	}

	@Override
	public ReportInstance getWrappedModel() {
		return _reportInstance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _reportInstance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _reportInstance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_reportInstance.resetOriginalValues();
	}

	private final ReportInstance _reportInstance;
}