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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

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

	/**
	* Returns the primary key of this anonymous user.
	*
	* @return the primary key of this anonymous user
	*/
	@Override
	public long getPrimaryKey() {
		return _anonymousUser.getPrimaryKey();
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

	/**
	* Returns the uuid of this anonymous user.
	*
	* @return the uuid of this anonymous user
	*/
	@Override
	public java.lang.String getUuid() {
		return _anonymousUser.getUuid();
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
	* Sets the anonymous user ID of this anonymous user.
	*
	* @param anonymousUserId the anonymous user ID of this anonymous user
	*/
	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUser.setAnonymousUserId(anonymousUserId);
	}

	/**
	* Returns the anonymous user uuid of this anonymous user.
	*
	* @return the anonymous user uuid of this anonymous user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getAnonymousUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUser.getAnonymousUserUuid();
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
	* Sets the company ID of this anonymous user.
	*
	* @param companyId the company ID of this anonymous user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_anonymousUser.setCompanyId(companyId);
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
	* Sets the user ID of this anonymous user.
	*
	* @param userId the user ID of this anonymous user
	*/
	@Override
	public void setUserId(long userId) {
		_anonymousUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this anonymous user.
	*
	* @return the user uuid of this anonymous user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _anonymousUser.getUserUuid();
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
	* Returns the user name of this anonymous user.
	*
	* @return the user name of this anonymous user
	*/
	@Override
	public java.lang.String getUserName() {
		return _anonymousUser.getUserName();
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
	* Returns the create date of this anonymous user.
	*
	* @return the create date of this anonymous user
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _anonymousUser.getCreateDate();
	}

	/**
	* Sets the create date of this anonymous user.
	*
	* @param createDate the create date of this anonymous user
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_anonymousUser.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this anonymous user.
	*
	* @return the modified date of this anonymous user
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _anonymousUser.getModifiedDate();
	}

	/**
	* Sets the modified date of this anonymous user.
	*
	* @param modifiedDate the modified date of this anonymous user
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_anonymousUser.setModifiedDate(modifiedDate);
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
	* Sets the last ip of this anonymous user.
	*
	* @param lastIp the last ip of this anonymous user
	*/
	@Override
	public void setLastIp(java.lang.String lastIp) {
		_anonymousUser.setLastIp(lastIp);
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

	/**
	* Sets the type settings of this anonymous user.
	*
	* @param typeSettings the type settings of this anonymous user
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_anonymousUser.setTypeSettings(typeSettings);
	}

	@Override
	public boolean isNew() {
		return _anonymousUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_anonymousUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _anonymousUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_anonymousUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _anonymousUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _anonymousUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_anonymousUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _anonymousUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_anonymousUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_anonymousUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_anonymousUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnonymousUserWrapper((AnonymousUser)_anonymousUser.clone());
	}

	@Override
	public int compareTo(AnonymousUser anonymousUser) {
		return _anonymousUser.compareTo(anonymousUser);
	}

	@Override
	public int hashCode() {
		return _anonymousUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<AnonymousUser> toCacheModel() {
		return _anonymousUser.toCacheModel();
	}

	@Override
	public AnonymousUser toEscapedModel() {
		return new AnonymousUserWrapper(_anonymousUser.toEscapedModel());
	}

	@Override
	public AnonymousUser toUnescapedModel() {
		return new AnonymousUserWrapper(_anonymousUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _anonymousUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _anonymousUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_anonymousUser.persist();
	}

	@Override
	public com.liferay.portal.model.User getUser() {
		return _anonymousUser.getUser();
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

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AnonymousUser getWrappedAnonymousUser() {
		return _anonymousUser;
	}

	@Override
	public AnonymousUser getWrappedModel() {
		return _anonymousUser;
	}

	@Override
	public void resetOriginalValues() {
		_anonymousUser.resetOriginalValues();
	}

	private AnonymousUser _anonymousUser;
}