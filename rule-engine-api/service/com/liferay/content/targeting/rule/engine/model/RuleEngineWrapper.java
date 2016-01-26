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

package com.liferay.content.targeting.rule.engine.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RuleEngine}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleEngine
 * @generated
 */
public class RuleEngineWrapper implements RuleEngine, ModelWrapper<RuleEngine> {
	public RuleEngineWrapper(RuleEngine ruleEngine) {
		_ruleEngine = ruleEngine;
	}

	@Override
	public Class<?> getModelClass() {
		return RuleEngine.class;
	}

	@Override
	public String getModelClassName() {
		return RuleEngine.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dummyId", getDummyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dummyId = (Long)attributes.get("dummyId");

		if (dummyId != null) {
			setDummyId(dummyId);
		}
	}

	/**
	* Returns the primary key of this rule engine.
	*
	* @return the primary key of this rule engine
	*/
	@Override
	public long getPrimaryKey() {
		return _ruleEngine.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rule engine.
	*
	* @param primaryKey the primary key of this rule engine
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ruleEngine.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rule engine.
	*
	* @return the uuid of this rule engine
	*/
	@Override
	public java.lang.String getUuid() {
		return _ruleEngine.getUuid();
	}

	/**
	* Sets the uuid of this rule engine.
	*
	* @param uuid the uuid of this rule engine
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_ruleEngine.setUuid(uuid);
	}

	/**
	* Returns the dummy ID of this rule engine.
	*
	* @return the dummy ID of this rule engine
	*/
	@Override
	public long getDummyId() {
		return _ruleEngine.getDummyId();
	}

	/**
	* Sets the dummy ID of this rule engine.
	*
	* @param dummyId the dummy ID of this rule engine
	*/
	@Override
	public void setDummyId(long dummyId) {
		_ruleEngine.setDummyId(dummyId);
	}

	@Override
	public boolean isNew() {
		return _ruleEngine.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ruleEngine.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ruleEngine.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ruleEngine.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ruleEngine.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ruleEngine.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ruleEngine.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ruleEngine.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ruleEngine.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ruleEngine.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ruleEngine.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RuleEngineWrapper((RuleEngine)_ruleEngine.clone());
	}

	@Override
	public int compareTo(RuleEngine ruleEngine) {
		return _ruleEngine.compareTo(ruleEngine);
	}

	@Override
	public int hashCode() {
		return _ruleEngine.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<RuleEngine> toCacheModel() {
		return _ruleEngine.toCacheModel();
	}

	@Override
	public RuleEngine toEscapedModel() {
		return new RuleEngineWrapper(_ruleEngine.toEscapedModel());
	}

	@Override
	public RuleEngine toUnescapedModel() {
		return new RuleEngineWrapper(_ruleEngine.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ruleEngine.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ruleEngine.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ruleEngine.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RuleEngineWrapper)) {
			return false;
		}

		RuleEngineWrapper ruleEngineWrapper = (RuleEngineWrapper)obj;

		return Validator.equals(_ruleEngine, ruleEngineWrapper._ruleEngine);

	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RuleEngine getWrappedRuleEngine() {
		return _ruleEngine;
	}

	@Override
	public RuleEngine getWrappedModel() {
		return _ruleEngine;
	}

	@Override
	public void resetOriginalValues() {
		_ruleEngine.resetOriginalValues();
	}

	private RuleEngine _ruleEngine;
}