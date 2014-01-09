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

package com.liferay.contenttargeting.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CTUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTUser
 * @generated
 */
public class CTUserWrapper implements CTUser, ModelWrapper<CTUser> {
	public CTUserWrapper(CTUser ctUser) {
		_ctUser = ctUser;
	}

	@Override
	public Class<?> getModelClass() {
		return CTUser.class;
	}

	@Override
	public String getModelClassName() {
		return CTUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("CTUserId", getCTUserId());
		attributes.put("groupId", getGroupId());
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

		Long CTUserId = (Long)attributes.get("CTUserId");

		if (CTUserId != null) {
			setCTUserId(CTUserId);
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
	* Returns the primary key of this c t user.
	*
	* @return the primary key of this c t user
	*/
	@Override
	public long getPrimaryKey() {
		return _ctUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this c t user.
	*
	* @param primaryKey the primary key of this c t user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ctUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this c t user.
	*
	* @return the uuid of this c t user
	*/
	@Override
	public java.lang.String getUuid() {
		return _ctUser.getUuid();
	}

	/**
	* Sets the uuid of this c t user.
	*
	* @param uuid the uuid of this c t user
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_ctUser.setUuid(uuid);
	}

	/**
	* Returns the c t user ID of this c t user.
	*
	* @return the c t user ID of this c t user
	*/
	@Override
	public long getCTUserId() {
		return _ctUser.getCTUserId();
	}

	/**
	* Sets the c t user ID of this c t user.
	*
	* @param CTUserId the c t user ID of this c t user
	*/
	@Override
	public void setCTUserId(long CTUserId) {
		_ctUser.setCTUserId(CTUserId);
	}

	/**
	* Returns the c t user uuid of this c t user.
	*
	* @return the c t user uuid of this c t user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCTUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUser.getCTUserUuid();
	}

	/**
	* Sets the c t user uuid of this c t user.
	*
	* @param CTUserUuid the c t user uuid of this c t user
	*/
	@Override
	public void setCTUserUuid(java.lang.String CTUserUuid) {
		_ctUser.setCTUserUuid(CTUserUuid);
	}

	/**
	* Returns the group ID of this c t user.
	*
	* @return the group ID of this c t user
	*/
	@Override
	public long getGroupId() {
		return _ctUser.getGroupId();
	}

	/**
	* Sets the group ID of this c t user.
	*
	* @param groupId the group ID of this c t user
	*/
	@Override
	public void setGroupId(long groupId) {
		_ctUser.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this c t user.
	*
	* @return the company ID of this c t user
	*/
	@Override
	public long getCompanyId() {
		return _ctUser.getCompanyId();
	}

	/**
	* Sets the company ID of this c t user.
	*
	* @param companyId the company ID of this c t user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ctUser.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this c t user.
	*
	* @return the user ID of this c t user
	*/
	@Override
	public long getUserId() {
		return _ctUser.getUserId();
	}

	/**
	* Sets the user ID of this c t user.
	*
	* @param userId the user ID of this c t user
	*/
	@Override
	public void setUserId(long userId) {
		_ctUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this c t user.
	*
	* @return the user uuid of this c t user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this c t user.
	*
	* @param userUuid the user uuid of this c t user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_ctUser.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this c t user.
	*
	* @return the user name of this c t user
	*/
	@Override
	public java.lang.String getUserName() {
		return _ctUser.getUserName();
	}

	/**
	* Sets the user name of this c t user.
	*
	* @param userName the user name of this c t user
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_ctUser.setUserName(userName);
	}

	/**
	* Returns the create date of this c t user.
	*
	* @return the create date of this c t user
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _ctUser.getCreateDate();
	}

	/**
	* Sets the create date of this c t user.
	*
	* @param createDate the create date of this c t user
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_ctUser.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this c t user.
	*
	* @return the modified date of this c t user
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _ctUser.getModifiedDate();
	}

	/**
	* Sets the modified date of this c t user.
	*
	* @param modifiedDate the modified date of this c t user
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ctUser.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the last ip of this c t user.
	*
	* @return the last ip of this c t user
	*/
	@Override
	public java.lang.String getLastIp() {
		return _ctUser.getLastIp();
	}

	/**
	* Sets the last ip of this c t user.
	*
	* @param lastIp the last ip of this c t user
	*/
	@Override
	public void setLastIp(java.lang.String lastIp) {
		_ctUser.setLastIp(lastIp);
	}

	/**
	* Returns the type settings of this c t user.
	*
	* @return the type settings of this c t user
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _ctUser.getTypeSettings();
	}

	/**
	* Sets the type settings of this c t user.
	*
	* @param typeSettings the type settings of this c t user
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_ctUser.setTypeSettings(typeSettings);
	}

	@Override
	public boolean isNew() {
		return _ctUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ctUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ctUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ctUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ctUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ctUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ctUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ctUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ctUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ctUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ctUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CTUserWrapper((CTUser)_ctUser.clone());
	}

	@Override
	public int compareTo(CTUser ctUser) {
		return _ctUser.compareTo(ctUser);
	}

	@Override
	public int hashCode() {
		return _ctUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<CTUser> toCacheModel() {
		return _ctUser.toCacheModel();
	}

	@Override
	public CTUser toEscapedModel() {
		return new CTUserWrapper(_ctUser.toEscapedModel());
	}

	@Override
	public CTUser toUnescapedModel() {
		return new CTUserWrapper(_ctUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ctUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ctUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ctUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTUserWrapper)) {
			return false;
		}

		CTUserWrapper ctUserWrapper = (CTUserWrapper)obj;

		if (Validator.equals(_ctUser, ctUserWrapper._ctUser)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _ctUser.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CTUser getWrappedCTUser() {
		return _ctUser;
	}

	@Override
	public CTUser getWrappedModel() {
		return _ctUser;
	}

	@Override
	public void resetOriginalValues() {
		_ctUser.resetOriginalValues();
	}

	private CTUser _ctUser;
}