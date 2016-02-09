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
 * This class is a wrapper for {@link RuleInstance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstance
 * @generated
 */
@ProviderType
public class RuleInstanceWrapper implements RuleInstance,
	ModelWrapper<RuleInstance> {
	public RuleInstanceWrapper(RuleInstance ruleInstance) {
		_ruleInstance = ruleInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return RuleInstance.class;
	}

	@Override
	public String getModelClassName() {
		return RuleInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ruleInstanceId", getRuleInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ruleKey", getRuleKey());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ruleInstanceId = (Long)attributes.get("ruleInstanceId");

		if (ruleInstanceId != null) {
			setRuleInstanceId(ruleInstanceId);
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

		String ruleKey = (String)attributes.get("ruleKey");

		if (ruleKey != null) {
			setRuleKey(ruleKey);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new RuleInstanceWrapper((RuleInstance)_ruleInstance.clone());
	}

	@Override
	public int compareTo(
		com.liferay.content.targeting.model.RuleInstance ruleInstance) {
		return _ruleInstance.compareTo(ruleInstance);
	}

	/**
	* Returns the company ID of this rule instance.
	*
	* @return the company ID of this rule instance
	*/
	@Override
	public long getCompanyId() {
		return _ruleInstance.getCompanyId();
	}

	/**
	* Returns the create date of this rule instance.
	*
	* @return the create date of this rule instance
	*/
	@Override
	public Date getCreateDate() {
		return _ruleInstance.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ruleInstance.getExpandoBridge();
	}

	/**
	* Returns the group ID of this rule instance.
	*
	* @return the group ID of this rule instance
	*/
	@Override
	public long getGroupId() {
		return _ruleInstance.getGroupId();
	}

	/**
	* Returns the modified date of this rule instance.
	*
	* @return the modified date of this rule instance
	*/
	@Override
	public Date getModifiedDate() {
		return _ruleInstance.getModifiedDate();
	}

	/**
	* Returns the primary key of this rule instance.
	*
	* @return the primary key of this rule instance
	*/
	@Override
	public long getPrimaryKey() {
		return _ruleInstance.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ruleInstance.getPrimaryKeyObj();
	}

	@Override
	public java.lang.String getRuleGuid() {
		return _ruleInstance.getRuleGuid();
	}

	/**
	* Returns the rule instance ID of this rule instance.
	*
	* @return the rule instance ID of this rule instance
	*/
	@Override
	public long getRuleInstanceId() {
		return _ruleInstance.getRuleInstanceId();
	}

	/**
	* Returns the rule key of this rule instance.
	*
	* @return the rule key of this rule instance
	*/
	@Override
	public java.lang.String getRuleKey() {
		return _ruleInstance.getRuleKey();
	}

	/**
	* Returns the type settings of this rule instance.
	*
	* @return the type settings of this rule instance
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _ruleInstance.getTypeSettings();
	}

	/**
	* Returns the user ID of this rule instance.
	*
	* @return the user ID of this rule instance
	*/
	@Override
	public long getUserId() {
		return _ruleInstance.getUserId();
	}

	/**
	* Returns the user name of this rule instance.
	*
	* @return the user name of this rule instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _ruleInstance.getUserName();
	}

	/**
	* Returns the user segment ID of this rule instance.
	*
	* @return the user segment ID of this rule instance
	*/
	@Override
	public long getUserSegmentId() {
		return _ruleInstance.getUserSegmentId();
	}

	@Override
	public java.lang.String getUserSegmentName(java.util.Locale locale) {
		return _ruleInstance.getUserSegmentName(locale);
	}

	/**
	* Returns the user uuid of this rule instance.
	*
	* @return the user uuid of this rule instance
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _ruleInstance.getUserUuid();
	}

	/**
	* Returns the uuid of this rule instance.
	*
	* @return the uuid of this rule instance
	*/
	@Override
	public java.lang.String getUuid() {
		return _ruleInstance.getUuid();
	}

	@Override
	public Map<java.lang.String, java.lang.String> getValues() {
		return _ruleInstance.getValues();
	}

	@Override
	public int hashCode() {
		return _ruleInstance.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ruleInstance.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ruleInstance.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ruleInstance.isNew();
	}

	@Override
	public void persist() {
		_ruleInstance.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ruleInstance.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this rule instance.
	*
	* @param companyId the company ID of this rule instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ruleInstance.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this rule instance.
	*
	* @param createDate the create date of this rule instance
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_ruleInstance.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ruleInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ruleInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ruleInstance.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this rule instance.
	*
	* @param groupId the group ID of this rule instance
	*/
	@Override
	public void setGroupId(long groupId) {
		_ruleInstance.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this rule instance.
	*
	* @param modifiedDate the modified date of this rule instance
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_ruleInstance.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_ruleInstance.setNew(n);
	}

	/**
	* Sets the primary key of this rule instance.
	*
	* @param primaryKey the primary key of this rule instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ruleInstance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ruleInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public void setRuleGuid(java.lang.String ruleGuid) {
		_ruleInstance.setRuleGuid(ruleGuid);
	}

	/**
	* Sets the rule instance ID of this rule instance.
	*
	* @param ruleInstanceId the rule instance ID of this rule instance
	*/
	@Override
	public void setRuleInstanceId(long ruleInstanceId) {
		_ruleInstance.setRuleInstanceId(ruleInstanceId);
	}

	/**
	* Sets the rule key of this rule instance.
	*
	* @param ruleKey the rule key of this rule instance
	*/
	@Override
	public void setRuleKey(java.lang.String ruleKey) {
		_ruleInstance.setRuleKey(ruleKey);
	}

	/**
	* Sets the type settings of this rule instance.
	*
	* @param typeSettings the type settings of this rule instance
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_ruleInstance.setTypeSettings(typeSettings);
	}

	/**
	* Sets the user ID of this rule instance.
	*
	* @param userId the user ID of this rule instance
	*/
	@Override
	public void setUserId(long userId) {
		_ruleInstance.setUserId(userId);
	}

	/**
	* Sets the user name of this rule instance.
	*
	* @param userName the user name of this rule instance
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_ruleInstance.setUserName(userName);
	}

	/**
	* Sets the user segment ID of this rule instance.
	*
	* @param userSegmentId the user segment ID of this rule instance
	*/
	@Override
	public void setUserSegmentId(long userSegmentId) {
		_ruleInstance.setUserSegmentId(userSegmentId);
	}

	/**
	* Sets the user uuid of this rule instance.
	*
	* @param userUuid the user uuid of this rule instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_ruleInstance.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this rule instance.
	*
	* @param uuid the uuid of this rule instance
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_ruleInstance.setUuid(uuid);
	}

	@Override
	public void setValues(Map<java.lang.String, java.lang.String> values) {
		_ruleInstance.setValues(values);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.content.targeting.model.RuleInstance> toCacheModel() {
		return _ruleInstance.toCacheModel();
	}

	@Override
	public com.liferay.content.targeting.model.RuleInstance toEscapedModel() {
		return new RuleInstanceWrapper(_ruleInstance.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ruleInstance.toString();
	}

	@Override
	public com.liferay.content.targeting.model.RuleInstance toUnescapedModel() {
		return new RuleInstanceWrapper(_ruleInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _ruleInstance.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RuleInstanceWrapper)) {
			return false;
		}

		RuleInstanceWrapper ruleInstanceWrapper = (RuleInstanceWrapper)obj;

		if (Validator.equals(_ruleInstance, ruleInstanceWrapper._ruleInstance)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _ruleInstance.getStagedModelType();
	}

	@Override
	public RuleInstance getWrappedModel() {
		return _ruleInstance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ruleInstance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ruleInstance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ruleInstance.resetOriginalValues();
	}

	private final RuleInstance _ruleInstance;
}