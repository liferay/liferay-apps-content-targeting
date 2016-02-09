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

package com.liferay.content.targeting.anonymous.users.model;

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
 * This class is a wrapper for {@link AnonymousUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUser
 * @generated
 */
@ProviderType
public class AnonymousUserWrapper implements AnonymousUser,
	ModelWrapper<AnonymousUser> {
	public AnonymousUserWrapper(AnonymousUser anonymousUser) {
		_anonymousUser = anonymousUser;
	}

	@Override
	public Class<?> getModelClass() {
		return AnonymousUser.class;
	}

	@Override
	public String getModelClassName() {
		return AnonymousUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lastIp", getLastIp());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
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

		String lastIp = (String)attributes.get("lastIp");

		if (lastIp != null) {
			setLastIp(lastIp);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new AnonymousUserWrapper((AnonymousUser)_anonymousUser.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.anonymous.users.model.AnonymousUser anonymousUser) {
		return _anonymousUser.compareTo(anonymousUser);
	}

	/**
	* Returns the anonymous user ID of this anonymous user.
	*
	* @return the anonymous user ID of this anonymous user
	*/
	@Override
	public long getAnonymousUserId() {
		return _anonymousUser.getAnonymousUserId();
	}

	/**
	* Returns the anonymous user uuid of this anonymous user.
	*
	* @return the anonymous user uuid of this anonymous user
	*/
	@Override
	public java.lang.String getAnonymousUserUuid() {
		return _anonymousUser.getAnonymousUserUuid();
	}

	/**
	* Returns the company ID of this anonymous user.
	*
	* @return the company ID of this anonymous user
	*/
	@Override
	public long getCompanyId() {
		return _anonymousUser.getCompanyId();
	}

	/**
	* Returns the create date of this anonymous user.
	*
	* @return the create date of this anonymous user
	*/
	@Override
	public Date getCreateDate() {
		return _anonymousUser.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _anonymousUser.getExpandoBridge();
	}

	/**
	* Returns the last ip of this anonymous user.
	*
	* @return the last ip of this anonymous user
	*/
	@Override
	public java.lang.String getLastIp() {
		return _anonymousUser.getLastIp();
	}

	/**
	* Returns the modified date of this anonymous user.
	*
	* @return the modified date of this anonymous user
	*/
	@Override
	public Date getModifiedDate() {
		return _anonymousUser.getModifiedDate();
	}

	/**
	* Returns the primary key of this anonymous user.
	*
	* @return the primary key of this anonymous user
	*/
	@Override
	public long getPrimaryKey() {
		return _anonymousUser.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _anonymousUser.getPrimaryKeyObj();
	}

	/**
	* Returns the type settings of this anonymous user.
	*
	* @return the type settings of this anonymous user
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _anonymousUser.getTypeSettings();
	}

	@Override
	public com.liferay.portal.kernel.model.User getUser() {
		return _anonymousUser.getUser();
	}

	/**
	* Returns the user ID of this anonymous user.
	*
	* @return the user ID of this anonymous user
	*/
	@Override
	public long getUserId() {
		return _anonymousUser.getUserId();
	}

	/**
	* Returns the user name of this anonymous user.
	*
	* @return the user name of this anonymous user
	*/
	@Override
	public java.lang.String getUserName() {
		return _anonymousUser.getUserName();
	}

	/**
	* Returns the user uuid of this anonymous user.
	*
	* @return the user uuid of this anonymous user
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _anonymousUser.getUserUuid();
	}

	/**
	* Returns the uuid of this anonymous user.
	*
	* @return the uuid of this anonymous user
	*/
	@Override
	public java.lang.String getUuid() {
		return _anonymousUser.getUuid();
	}

	@Override
	public int hashCode() {
		return _anonymousUser.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _anonymousUser.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _anonymousUser.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _anonymousUser.isNew();
	}

	@Override
	public void persist() {
		_anonymousUser.persist();
	}

	/**
	* Sets the anonymous user ID of this anonymous user.
	*
	* @param anonymousUserId the anonymous user ID of this anonymous user
	*/
	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUser.setAnonymousUserId(anonymousUserId);
	}

	/**
	* Sets the anonymous user uuid of this anonymous user.
	*
	* @param anonymousUserUuid the anonymous user uuid of this anonymous user
	*/
	@Override
	public void setAnonymousUserUuid(java.lang.String anonymousUserUuid) {
		_anonymousUser.setAnonymousUserUuid(anonymousUserUuid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_anonymousUser.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this anonymous user.
	*
	* @param companyId the company ID of this anonymous user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_anonymousUser.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this anonymous user.
	*
	* @param createDate the create date of this anonymous user
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_anonymousUser.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_anonymousUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_anonymousUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_anonymousUser.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the last ip of this anonymous user.
	*
	* @param lastIp the last ip of this anonymous user
	*/
	@Override
	public void setLastIp(java.lang.String lastIp) {
		_anonymousUser.setLastIp(lastIp);
	}

	/**
	* Sets the modified date of this anonymous user.
	*
	* @param modifiedDate the modified date of this anonymous user
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_anonymousUser.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_anonymousUser.setNew(n);
	}

	/**
	* Sets the primary key of this anonymous user.
	*
	* @param primaryKey the primary key of this anonymous user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_anonymousUser.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_anonymousUser.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type settings of this anonymous user.
	*
	* @param typeSettings the type settings of this anonymous user
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_anonymousUser.setTypeSettings(typeSettings);
	}

	/**
	* Sets the user ID of this anonymous user.
	*
	* @param userId the user ID of this anonymous user
	*/
	@Override
	public void setUserId(long userId) {
		_anonymousUser.setUserId(userId);
	}

	/**
	* Sets the user name of this anonymous user.
	*
	* @param userName the user name of this anonymous user
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_anonymousUser.setUserName(userName);
	}

	/**
	* Sets the user uuid of this anonymous user.
	*
	* @param userUuid the user uuid of this anonymous user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_anonymousUser.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this anonymous user.
	*
	* @param uuid the uuid of this anonymous user
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_anonymousUser.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> toCacheModel() {
		return _anonymousUser.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser toEscapedModel() {
		return new AnonymousUserWrapper(_anonymousUser.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _anonymousUser.toString();
	}

	@Override
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser toUnescapedModel() {
		return new AnonymousUserWrapper(_anonymousUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _anonymousUser.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnonymousUserWrapper)) {
			return false;
		}

		AnonymousUserWrapper anonymousUserWrapper = (AnonymousUserWrapper)obj;

		if (Validator.equals(_anonymousUser, anonymousUserWrapper._anonymousUser)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _anonymousUser.getStagedModelType();
	}

	@Override
	public AnonymousUser getWrappedModel() {
		return _anonymousUser;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _anonymousUser.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _anonymousUser.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_anonymousUser.resetOriginalValues();
	}

	private final AnonymousUser _anonymousUser;
}