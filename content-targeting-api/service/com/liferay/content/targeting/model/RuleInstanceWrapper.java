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
 * This class is a wrapper for {@link RuleInstance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstance
 * @generated
 */
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

	/**
	* Returns the primary key of this rule instance.
	*
	* @return the primary key of this rule instance
	*/
	@Override
	public long getPrimaryKey() {
		return _ruleInstance.getPrimaryKey();
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

	/**
	* Returns the uuid of this rule instance.
	*
	* @return the uuid of this rule instance
	*/
	@Override
	public java.lang.String getUuid() {
		return _ruleInstance.getUuid();
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
	* Sets the rule instance ID of this rule instance.
	*
	* @param ruleInstanceId the rule instance ID of this rule instance
	*/
	@Override
	public void setRuleInstanceId(long ruleInstanceId) {
		_ruleInstance.setRuleInstanceId(ruleInstanceId);
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
	* Sets the group ID of this rule instance.
	*
	* @param groupId the group ID of this rule instance
	*/
	@Override
	public void setGroupId(long groupId) {
		_ruleInstance.setGroupId(groupId);
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
	* Sets the company ID of this rule instance.
	*
	* @param companyId the company ID of this rule instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ruleInstance.setCompanyId(companyId);
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
	* Sets the user ID of this rule instance.
	*
	* @param userId the user ID of this rule instance
	*/
	@Override
	public void setUserId(long userId) {
		_ruleInstance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rule instance.
	*
	* @return the user uuid of this rule instance
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleInstance.getUserUuid();
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
	* Returns the user name of this rule instance.
	*
	* @return the user name of this rule instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _ruleInstance.getUserName();
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
	* Returns the create date of this rule instance.
	*
	* @return the create date of this rule instance
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _ruleInstance.getCreateDate();
	}

	/**
	* Sets the create date of this rule instance.
	*
	* @param createDate the create date of this rule instance
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_ruleInstance.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rule instance.
	*
	* @return the modified date of this rule instance
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _ruleInstance.getModifiedDate();
	}

	/**
	* Sets the modified date of this rule instance.
	*
	* @param modifiedDate the modified date of this rule instance
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ruleInstance.setModifiedDate(modifiedDate);
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
	* Sets the rule key of this rule instance.
	*
	* @param ruleKey the rule key of this rule instance
	*/
	@Override
	public void setRuleKey(java.lang.String ruleKey) {
		_ruleInstance.setRuleKey(ruleKey);
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
	* Returns the type settings of this rule instance.
	*
	* @return the type settings of this rule instance
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _ruleInstance.getTypeSettings();
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

	@Override
	public boolean isNew() {
		return _ruleInstance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ruleInstance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ruleInstance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ruleInstance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ruleInstance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ruleInstance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ruleInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ruleInstance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ruleInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ruleInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ruleInstance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RuleInstanceWrapper((RuleInstance)_ruleInstance.clone());
	}

	@Override
	public int compareTo(RuleInstance ruleInstance) {
		return _ruleInstance.compareTo(ruleInstance);
	}

	@Override
	public int hashCode() {
		return _ruleInstance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<RuleInstance> toCacheModel() {
		return _ruleInstance.toCacheModel();
	}

	@Override
	public RuleInstance toEscapedModel() {
		return new RuleInstanceWrapper(_ruleInstance.toEscapedModel());
	}

	@Override
	public RuleInstance toUnescapedModel() {
		return new RuleInstanceWrapper(_ruleInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ruleInstance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ruleInstance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ruleInstance.persist();
	}

	@Override
	public java.lang.String getRuleGuid() {
		return _ruleInstance.getRuleGuid();
	}

	@Override
	public java.lang.String getUserSegmentName(java.util.Locale locale) {
		return _ruleInstance.getUserSegmentName(locale);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getValues() {
		return _ruleInstance.getValues();
	}

	@Override
	public void setRuleGuid(java.lang.String ruleGuid) {
		_ruleInstance.setRuleGuid(ruleGuid);
	}

	@Override
	public void setValues(
		java.util.Map<java.lang.String, java.lang.String> values) {
		_ruleInstance.setValues(values);
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

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RuleInstance getWrappedRuleInstance() {
		return _ruleInstance;
	}

	@Override
	public RuleInstance getWrappedModel() {
		return _ruleInstance;
	}

	@Override
	public void resetOriginalValues() {
		_ruleInstance.resetOriginalValues();
	}

	private RuleInstance _ruleInstance;
}