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
 * This class is a wrapper for {@link Rule}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Rule
 * @generated
 */
public class RuleWrapper implements Rule, ModelWrapper<Rule> {
	public RuleWrapper(Rule rule) {
		_rule = rule;
	}

	@Override
	public Class<?> getModelClass() {
		return Rule.class;
	}

	@Override
	public String getModelClassName() {
		return Rule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ruleId", getRuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("segmentId", getSegmentId());
		attributes.put("type", getType());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
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

		Long segmentId = (Long)attributes.get("segmentId");

		if (segmentId != null) {
			setSegmentId(segmentId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	/**
	* Returns the primary key of this rule.
	*
	* @return the primary key of this rule
	*/
	@Override
	public long getPrimaryKey() {
		return _rule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rule.
	*
	* @param primaryKey the primary key of this rule
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rule.
	*
	* @return the uuid of this rule
	*/
	@Override
	public java.lang.String getUuid() {
		return _rule.getUuid();
	}

	/**
	* Sets the uuid of this rule.
	*
	* @param uuid the uuid of this rule
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rule.setUuid(uuid);
	}

	/**
	* Returns the rule ID of this rule.
	*
	* @return the rule ID of this rule
	*/
	@Override
	public long getRuleId() {
		return _rule.getRuleId();
	}

	/**
	* Sets the rule ID of this rule.
	*
	* @param ruleId the rule ID of this rule
	*/
	@Override
	public void setRuleId(long ruleId) {
		_rule.setRuleId(ruleId);
	}

	/**
	* Returns the group ID of this rule.
	*
	* @return the group ID of this rule
	*/
	@Override
	public long getGroupId() {
		return _rule.getGroupId();
	}

	/**
	* Sets the group ID of this rule.
	*
	* @param groupId the group ID of this rule
	*/
	@Override
	public void setGroupId(long groupId) {
		_rule.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rule.
	*
	* @return the company ID of this rule
	*/
	@Override
	public long getCompanyId() {
		return _rule.getCompanyId();
	}

	/**
	* Sets the company ID of this rule.
	*
	* @param companyId the company ID of this rule
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rule.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rule.
	*
	* @return the user ID of this rule
	*/
	@Override
	public long getUserId() {
		return _rule.getUserId();
	}

	/**
	* Sets the user ID of this rule.
	*
	* @param userId the user ID of this rule
	*/
	@Override
	public void setUserId(long userId) {
		_rule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rule.
	*
	* @return the user uuid of this rule
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rule.getUserUuid();
	}

	/**
	* Sets the user uuid of this rule.
	*
	* @param userUuid the user uuid of this rule
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rule.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rule.
	*
	* @return the user name of this rule
	*/
	@Override
	public java.lang.String getUserName() {
		return _rule.getUserName();
	}

	/**
	* Sets the user name of this rule.
	*
	* @param userName the user name of this rule
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rule.setUserName(userName);
	}

	/**
	* Returns the create date of this rule.
	*
	* @return the create date of this rule
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rule.getCreateDate();
	}

	/**
	* Sets the create date of this rule.
	*
	* @param createDate the create date of this rule
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rule.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rule.
	*
	* @return the modified date of this rule
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rule.getModifiedDate();
	}

	/**
	* Sets the modified date of this rule.
	*
	* @param modifiedDate the modified date of this rule
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rule.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the segment ID of this rule.
	*
	* @return the segment ID of this rule
	*/
	@Override
	public long getSegmentId() {
		return _rule.getSegmentId();
	}

	/**
	* Sets the segment ID of this rule.
	*
	* @param segmentId the segment ID of this rule
	*/
	@Override
	public void setSegmentId(long segmentId) {
		_rule.setSegmentId(segmentId);
	}

	/**
	* Returns the type of this rule.
	*
	* @return the type of this rule
	*/
	@Override
	public java.lang.String getType() {
		return _rule.getType();
	}

	/**
	* Sets the type of this rule.
	*
	* @param type the type of this rule
	*/
	@Override
	public void setType(java.lang.String type) {
		_rule.setType(type);
	}

	/**
	* Returns the type settings of this rule.
	*
	* @return the type settings of this rule
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _rule.getTypeSettings();
	}

	/**
	* Sets the type settings of this rule.
	*
	* @param typeSettings the type settings of this rule
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_rule.setTypeSettings(typeSettings);
	}

	@Override
	public boolean isNew() {
		return _rule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RuleWrapper((Rule)_rule.clone());
	}

	@Override
	public int compareTo(com.liferay.contenttargeting.model.Rule rule) {
		return _rule.compareTo(rule);
	}

	@Override
	public int hashCode() {
		return _rule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.contenttargeting.model.Rule> toCacheModel() {
		return _rule.toCacheModel();
	}

	@Override
	public com.liferay.contenttargeting.model.Rule toEscapedModel() {
		return new RuleWrapper(_rule.toEscapedModel());
	}

	@Override
	public com.liferay.contenttargeting.model.Rule toUnescapedModel() {
		return new RuleWrapper(_rule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RuleWrapper)) {
			return false;
		}

		RuleWrapper ruleWrapper = (RuleWrapper)obj;

		if (Validator.equals(_rule, ruleWrapper._rule)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _rule.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Rule getWrappedRule() {
		return _rule;
	}

	@Override
	public Rule getWrappedModel() {
		return _rule;
	}

	@Override
	public void resetOriginalValues() {
		_rule.resetOriginalValues();
	}

	private Rule _rule;
}